package com.kimzing.utils.json;

import com.google.gson.*;
import com.kimzing.utils.string.StringUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Json工具.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public final class JsonUtil {

    private static GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();

    private static Gson gson = gsonBuilder.create();

    /**
     * 判断字符串是否是有效的json
     * @param json
     * @return
     */
    public static boolean isValid(String json) {
        if (StringUtil.isBlank(json)) {
            return false;
        }
        JsonElement jsonElement;
        try {
            jsonElement = JsonParser.parseString(json);
        } catch (Exception e) {
            return false;
        }
        if (jsonElement == null) {
            return false;
        }
        if (!jsonElement.isJsonObject()) {
            return false;
        }
        return true;
    }

    /**
     * json串转换为对象.
     *
     * @param json
     * @param clazz
     * @return T
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        if (StringUtil.isBlank(json)) {
            return null;
        }
        return gson.fromJson(json, clazz);
    }

    /**
     * json串转换为对象.
     *
     * @param json
     * @param clazz
     * @return T
     */
    public static <T> T jsonToBean(String json, Class<T> clazz, String dateTimeFormat) {
        if (StringUtil.isBlank(json)) {
            return null;
        }
        if (Objects.isNull(dateTimeFormat) || "".equals(dateTimeFormat)) {
            return jsonToBean(json, clazz);
        }
        Gson gson = gsonBuilder.setDateFormat(dateTimeFormat)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeSerializerAdapter(dateTimeFormat)).create();
        return gson.fromJson(json, clazz);
    }

    /**
     * 对象转换为json.
     *
     * @param object
     * @return java.lang.String
     */
    public static String beanToJson(Object object) {
        if (Objects.isNull(object)) {
            return null;
        }
        return gson.toJson(object);
    }

    /**
     * 对象转换为json,可以带上date的格式化.
     *
     * @param object
     * @param dateTimeFormat
     * @return java.lang.String
     */
    public static String beanToJson(Object object, String dateTimeFormat) {
        if (Objects.isNull(object)) {
            return null;
        }
        if (Objects.isNull(dateTimeFormat) || "".equals(dateTimeFormat)) {
            return beanToJson(object);
        }
        return gsonBuilder.setDateFormat(dateTimeFormat)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializerAdapter(dateTimeFormat))
                .create()
                .toJson(object);

    }

    /**
     * json返回List.
     *
     * @param jsonList
     * @param clazz
     * @return java.util.List<T>
     */
    public static <T> List<T> jsonToList(String jsonList, Class<T> clazz) {
        if (StringUtil.isBlank(jsonList)) {
            return null;
        }
        return gson.fromJson(jsonList, getListType(clazz));
    }

    /**
     * json返回List.
     *
     * @param jsonList
     * @param clazz
     * @param dateTimeFormat
     * @return java.util.List<T>
     */
    public static <T> List<T> jsonToList(String jsonList, Class<T> clazz, String dateTimeFormat) {
        if (StringUtil.isBlank(jsonList)) {
            return null;
        }
        if (StringUtil.isBlank(dateTimeFormat)) {
            return jsonToList(jsonList, clazz);
        }
        Gson gson = gsonBuilder
                .setDateFormat(dateTimeFormat)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeSerializerAdapter(dateTimeFormat)).create();
        return gson.fromJson(jsonList, getListType(clazz));
    }

    /**
     * 反序列化Map.
     *
     * @param jsonMap
     * @param keyType
     * @param valueType
     * @return java.util.Map
     */
    public static <K, V> Map<K, V> jsonToMap(String jsonMap, Class<K> keyType, Class<V> valueType) {
        if (StringUtil.isBlank(jsonMap)) {
            return null;
        }
        return gson.fromJson(jsonMap, getMapType(keyType, valueType));
    }

    /**
     * 反序列化Map.
     *
     * @param jsonMap
     * @param keyType
     * @param valueType
     * @return java.util.Map
     */
    public static <K, V> Map<K, V> jsonToMap(String jsonMap, Class<K> keyType, Class<V> valueType, String dateTimeFormat) {
        if (StringUtil.isBlank(jsonMap)) {
            return null;
        }
        if (StringUtil.isBlank(dateTimeFormat)) {
            return jsonToMap(jsonMap, keyType, valueType);
        }
        Gson gson = gsonBuilder
                .setDateFormat(dateTimeFormat)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeSerializerAdapter(dateTimeFormat)).create();
        return gson.fromJson(jsonMap, getMapType(keyType, valueType));
    }

    private static Type getMapType(Class key, Class value) {
        return new ParameterizedType() {
            @Override
            public Type getRawType() {
                return Map.class;
            }
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{key, value};
            }
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

    private static <T> Type getListType(Class<T> clazz) {
        return new ParameterizedType() {
            @Override
            public Type getRawType() {
                return List.class;
            }
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{clazz};
            }
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

}

/**
 * LocalDateTime序列化
 */
class LocalDateTimeSerializerAdapter implements JsonSerializer<LocalDateTime> {

    private String dateTimePattern;

    public LocalDateTimeSerializerAdapter(String dateTimePattern) {
        this.dateTimePattern = dateTimePattern;
    }

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(dateTimePattern)));
    }

}

/**
 * LocalDateTime反序列化
 */
class LocalDateTimeDeSerializerAdapter implements JsonDeserializer<LocalDateTime> {

    private String dateTimePattern;

    public LocalDateTimeDeSerializerAdapter(String dateTimePattern) {
        this.dateTimePattern = dateTimePattern;
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern(dateTimePattern)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();
        return LocalDateTime.parse(json.getAsString(), formatter);
    }
}