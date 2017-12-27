package com.kingboy.common.utils.excel;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/26 下午4:58
 * @desc 设置Excel的样式.使用了build模式，链式赋值
 */
@Data
@NoArgsConstructor
public class ExcelStyle {

    //对齐方式
    private HorizontalAlignment align;

    //字体  "黑体"等
    private String fontName;

    //是否加粗，对表头不生效
    private boolean isBold;

    //字体大小
    private short size;

    //字体颜色
    private short fontColor;

    //边框粗细
    private BorderStyle borderStyle;

    //背景颜色
    private short backColor;
}