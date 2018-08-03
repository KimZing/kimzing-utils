package com.kingboy.common.utils.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/26 下午1:25
 * @desc Excel工具类. 只针对单个类内的属性进行转换。
 * 额外说明:本工具类支持设置数据行的格式，但由于这个功能占用执行时间过多(大约十倍)，所以在205行注释掉了，有需要可以打开
 * 使用说明-博客:http://blog.csdn.net/kingboyworld/article/details/76253785
 */
public final class ExcelUtils {

    private ExcelUtils() { }

    /**
     * 将List转换成Excel
     * @param list 数据集合
     * @param filePath java7中的文件操作  创建方式:Paths.get("文件地址");
     * @param <T> bean类型
     * @return
     * @throws Exception
     */
    public static <T> void listToExcel(List<T> list, Path filePath, Map<String, Map<String, String>> fieldMapper,
                                       ExcelStyle headStyle, ExcelStyle contentStyle) throws Exception {
        //List为null或者empty抛出异常
        Optional.ofNullable(list)
                .filter(l -> !l.isEmpty())
                .orElseThrow(NullPointerException::new);

        //1. 获取类的字符串属性
        List<Excel> excelList = getExcelAnnoList(list.get(0).getClass());
        //2. 创建工件薄,工件表
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        //3. 设置表头
        setHead(excelList, sheet, headStyle);
        //4. 设置内容
        setContent(list, sheet, fieldMapper, contentStyle);
        //5. 写文件
        workbook.write(Files.newOutputStream(filePath));
    }

    //每次转换多少行
    private static Integer size = 1_000;

    /**
     * excel转换为List,基本思路是拼接成Json,然后用Json工具转换为List
     * 必需保证类里面的带有Excel注解属性的顺序和Excel文件中标题的顺序相对应
     * @param filePath 文件路径    创建方式:Paths.get("文件地址");
     * @param clazz 类
     * @param <T>
     * @return
     */
    public static<T> List<T> excelToList(Path filePath, Class<T> clazz, Map<String, Map<String, String>> fieldMapper)
            throws Exception {
        Workbook workbook = new XSSFWorkbook(Files.newInputStream(filePath));
        Sheet sheet = workbook.getSheetAt(0);

        //1. 获取类和Excel表格对应的属性，有序放入ArrayList中
        ArrayList<String> fieldList = getFieldNameByExcelAnno(clazz);
        //2. 获取结果
        ArrayList<T> resultList = getClazzArrayList(sheet, clazz, fieldList, fieldMapper);
        return resultList;
    }



    /*------------------------------ExcelToList的调用方法------------------------------------*/

    /**
     *
     * @param sheet 工作表
     * @param fieldList 获取类中有映射关系的属性名
     * @param <T>
     * @return
     */
    private static <T> ArrayList<T> getClazzArrayList(Sheet sheet, Class<T> clazz, ArrayList<String> fieldList,
                                                      Map<String, Map<String, String>> fieldMapper) {
        //数据行数
        int rowNumber = sheet.getPhysicalNumberOfRows() - 1;
        //读取次数
        int times = rowNumber / size + 1;
        //结果集
        ArrayList<T> result = new ArrayList<T>(rowNumber);
        Stream.iterate(1, i -> i + 1)
                .limit(times - 1)
                .forEach(i -> {
                    result.addAll(getArrayListFromMap(
                            readExcel((i - 1) * size + 1, i == times ? rowNumber : size, sheet, fieldList),
                            clazz,
                            fieldMapper)
                    );
                });
        return result;
    }

    /**
     * 解析Json字符串
     * @param mapList Excel表中的数据
     * @param clazz
     * @param fieldMapper 属性转换容器
     * @param <T>
     * @return
     */
    private static <T> List<T> getArrayListFromMap(List<Map<String, String>> mapList, Class<T> clazz,
                                                   Map<String, Map<String, String>> fieldMapper) {
        //记录默认的日期格式
        String tempDateFormat = JSONObject.DEFFAULT_DATE_FORMAT;
        //设置日期编码
        getFieldWithExcel(clazz)
                .filter(field -> field.getType() == Date.class || field.getType() == LocalDateTime.class)
                .findFirst()
                .ifPresent(field ->
                        JSONObject.DEFFAULT_DATE_FORMAT = field.getAnnotation(Excel.class).dateFormat());

        //转换属性
        if (fieldMapper != null) {
            mapList.stream().forEach(map -> {
                map.forEach((key, value) -> {
                    if (fieldMapper.get(key) != null) {
                        //真实的属性值
                        String realValue = fieldMapper.get(key).get(value);
                        //如果有对应的值，就设置对应的值
                        map.put(key, realValue == null ? value : realValue);
                    }
                });
            });
        }

        List<T> list = JSON.parseArray(JSON.toJSONString(mapList), clazz);
        //还原默认的日期格式
        JSONObject.DEFFAULT_DATE_FORMAT = tempDateFormat;

        return list;
    }

    /**
     * 读取指定数量的数据，每行都拼接成一个Map<String, String>的集合
     * @param start 开始行
     * @param size 长度
     * @param sheet
     * @param fieldList 获取类中有映射关系的属性名
     * @return
     */
    private static <T> ArrayList<Map<String, String>> readExcel(int start, int size, Sheet sheet, ArrayList<String> fieldList) {
        ArrayList<Map<String, String>> listMap = new ArrayList<>();
        for (int i = start; i < start + size; i++) {
            Map<String, String> map = new TreeMap<>();
            for (int j = 0; j < fieldList.size(); j++) {
                map.put(fieldList.get(j), sheet.getRow(i).getCell(j).getStringCellValue());
            }
            listMap.add(map);
        }
        return listMap;
    }

    /**
     * 获取属性名
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> ArrayList<String> getFieldNameByExcelAnno(Class<T> clazz) throws Exception {
        return getFieldWithExcel(clazz)
                .map(field -> field.getName())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*------------------------------ListToExcel的调用方法------------------------------------*/

    /**
     * 写入内容
     * @param list 数据内容
     * @param sheet
     * @param fieldMapper 属性转换
     * @param <T>
     */
    private static <T> void setContent(List<T> list, Sheet sheet, Map<String, Map<String, String>> fieldMapper, ExcelStyle contentStyle) {
        Stream.iterate(0, item -> item + 1).limit(list.size())
                .forEach(item -> {
                    //当前行
                    Row row = sheet.createRow(item + 1);
                    //每个对象的属性值
                    List<String> fieldValue = getFiledValueIfIsExcel(list.get(item), fieldMapper);
                    Stream.iterate(0, i -> i + 1)
                            .limit(fieldValue.size())
                            .forEach(i -> {
                                Cell cell = row.createCell(i);
                                cell.setCellType(CellType.STRING);
                                //cell.setCellStyle(getContentStyle(sheet.getWorkbook(), contentStyle));
                                cell.setCellValue(fieldValue.get(i));
                            });
                });
    }

    /**
     * 写入标题
     * @param excelList 标题
     * @param sheet
     */
    private static void setHead(List<Excel> excelList, Sheet sheet, ExcelStyle headStyle) {
        Row row = sheet.createRow(0);
        Stream.iterate(0, item -> item + 1)
                .limit(excelList.size())
                .forEach(item -> {
                    Cell cell = row.createCell(item);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue(excelList.get(item).name());
                    cell.setCellStyle(getTitleStyle(sheet.getWorkbook(), headStyle));
                    sheet.setColumnWidth(item, excelList.get(item).width() * 2 << 6);
                });
    }

    /**
     * 设置头样式
     * @param workbook
     * @return
     */
    private static CellStyle getTitleStyle(Workbook workbook, ExcelStyle headStyle) {
        CellStyle cellStyle = workbook.createCellStyle();
        headStyle = headStyle == null ? new ExcelStyle() : headStyle;

        //对齐方式
        cellStyle.setAlignment(headStyle.getAlign() == null ? HorizontalAlignment.CENTER : headStyle.getAlign());

        //设置字体
        Font font = workbook.createFont();
        String fontName = headStyle.getFontName();
        font.setFontName(null == fontName ? "黑体" : fontName);
        //字体大小
        font.setFontHeightInPoints(headStyle.getSize() <= 0 ? 14 : headStyle.getSize());
        font.setBold(true);
        font.setColor(headStyle.getFontColor() <= 0 ? HSSFColor.BLACK.index : headStyle.getFontColor());
        cellStyle.setFont(font);

        //背景
        cellStyle.setFillForegroundColor(headStyle.getBackColor() <= 0
                ? HSSFColor.SEA_GREEN.index
                : headStyle.getBackColor());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        BorderStyle border = headStyle.getBorderStyle() == null ? BorderStyle.MEDIUM : headStyle.getBorderStyle();
        //边框
        cellStyle.setBorderLeft(border);
        cellStyle.setBorderTop(border);
        cellStyle.setBorderRight(border);
        cellStyle.setBorderBottom(border);

        //自动换行
        //cellStyle.setWrapText(true);
        return cellStyle;
    }

    /**
     * 设置内容样式，占用过大，并没有开启这个功能
     * @param workbook
     * @return
     */
    private static CellStyle getContentStyle(Workbook workbook, ExcelStyle contentStyle) {
        contentStyle = contentStyle == null ? new ExcelStyle() : contentStyle;
        CellStyle cellStyle = workbook.createCellStyle();

        //对齐方式
        cellStyle.setAlignment(contentStyle.getAlign() == null ? HorizontalAlignment.LEFT : contentStyle.getAlign());

        //设置字体
        Font font = workbook.createFont();
        String fontName = contentStyle.getFontName();
        font.setFontName(null == fontName ? "黑体" : fontName);
        //字体大小
        font.setFontHeightInPoints(contentStyle.getSize() <= 0 ? 12 : contentStyle.getSize());
        font.setBold(contentStyle.isBold());
        font.setColor(contentStyle.getFontColor() <= 0 ? HSSFColor.BLACK.index : contentStyle.getFontColor());
        cellStyle.setFont(font);

        //背景
        cellStyle.setFillForegroundColor(contentStyle.getBackColor() <= 0
                ? HSSFColor.WHITE.index
                : contentStyle.getBackColor());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        BorderStyle border = contentStyle.getBorderStyle() == null ? BorderStyle.THIN : contentStyle.getBorderStyle();
        //边框
        cellStyle.setBorderLeft(border);
        cellStyle.setBorderTop(border);
        cellStyle.setBorderRight(border);
        cellStyle.setBorderBottom(border);

        //自动换行
        //cellStyle.setWrapText(true);
        return cellStyle;
    }

    /**
     * 拿到一个类中属性上的Excel注解
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> List<Excel> getExcelAnnoList(Class<T> clazz) throws Exception {
        return  getFieldWithExcel(clazz)
                .map(field -> field.getAnnotation(Excel.class))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 获取带有Excel注解的属性
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> Stream<Field> getFieldWithExcel(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields)
                .filter(field -> {
                    Excel excel = field.getAnnotation(Excel.class);
                    return excel != null && !excel.skip();
                });
    }

    /**
     * 获取一个类包含Excel注解的属性的值
     * @param t
     * @param <T>
     * @return
     */
    private static  <T> List<String> getFiledValueIfIsExcel(T t, Map<String, Map<String, String>> fieldMapper) {
        return getFieldWithExcel(t.getClass()).map(field -> {
            field.setAccessible(true);
            Object o = null;

            try {
                o = field.get(t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //如果属性值为空，返回空字符串
            if (Objects.isNull(o)) {
                o =  "";
            }
            //如果是Date类型
            if (o instanceof Date) {
                o =  new SimpleDateFormat(field.getAnnotation(Excel.class).dateFormat()).format((Date) o);
            }
            //如果是LocalDateTime类型，支持Java8LocalDateTime
            if (o instanceof LocalDateTime) {
                o =  ((LocalDateTime) o).format(DateTimeFormatter.ofPattern(field.getAnnotation(Excel.class).dateFormat()));
            }
            //bool和int属性转换，感觉最常用这两个，其它的需要再扩充
            if (fieldMapper != null && (o instanceof Boolean || o instanceof Integer)) {
                Map<String, String> map = fieldMapper.get(field.getName());
                o =  map == null ? o : map.get(o.toString()) == null ? o : map.get(o.toString());
            }
            //其它的返回toString
            return o.toString();

        }).collect(Collectors.toCollection(ArrayList::new));
    }

}