package com.kingboy.common.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Json工具.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public final class JsonUtils {

    /**
     * json串转换为对象.
     * <p></p>
     * @param json
     * @param clazz
     * @return T
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:18
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 对象转换为json.
     * <p></p>
     * @param object
     * @return java.lang.String
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:20
     */
    public static String beanToJson(Object object) {
            return JSON.toJSONString(object);
    }

    /**
     * 对象转换为json,可以带上date的格式化.
     * <p></p>
     * @param object
     * @param dateFormat
     * @return java.lang.String
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:20
     */
    public static String beanToJson(Object object, String dateFormat) {
        if (Objects.isNull(dateFormat) || "".equals(dateFormat)) {
            return JSON.toJSONString(object);
        }
        return JSON.toJSONStringWithDateFormat(object, dateFormat);

    }

    /**
     * json返回List.
     * <p></p>
     * @param arrayJson
     * @param clazz
     * @param dateFormat
     * @return java.util.List<T>
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:19
     */
    public static <T> List<T> jsonToList(String arrayJson, Class<T> clazz, String dateFormat) {
        String temp = JSONObject.DEFFAULT_DATE_FORMAT;
        if (!"".equals(dateFormat) && dateFormat != null) {
            JSONObject.DEFFAULT_DATE_FORMAT = dateFormat;
        }
        List<T> list = JSON.parseArray(arrayJson, clazz);
        JSONObject.DEFFAULT_DATE_FORMAT = temp;
        return list;
    }

    /**
     * 反序列化Map.
     * <p></p>
     * @param mapJson
     * @param keyType
     * @param valueType
     * @return java.util.Map
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:19
     */
    public static <K, V> Map jsonMap(String mapJson, Class<K> keyType, Class<V> valueType) {
        return JSON.parseObject(mapJson, new TypeReference<Map<K, V>>() { });
    }
}
