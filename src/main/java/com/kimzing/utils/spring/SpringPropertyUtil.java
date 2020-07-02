package com.kimzing.utils.spring;

import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * 获取Spring容器内属性信息.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/6 12:47
 */
public final class SpringPropertyUtil {

    private static Environment environment = SpringContextUtil.getSingleBeanByClass(Environment.class);

    private SpringPropertyUtil() {
    }

    /**
     * see getValue(String)
     *
     * @param key
     * @return
     */
    public static String getValue(@NotNull Integer key) {
        Assert.notNull(key, "key can not be null!");
        return getValue(key.toString());
    }

    /**
     * 根据Key获取Spring上下文中的属性配置
     * <p>
     * key不存在，返回null
     * </p>
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        return environment.getProperty(key);
    }

    /**
     * see getValueWithDefault(String)
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getValueWithDefault(@NotNull Integer key, String defaultValue) {
        Assert.notNull(key, "key can not be null!");
        return getValueWithDefault(key.toString(), defaultValue);
    }

    /**
     * 根据Key获取Spring上下文中的属性配置
     * <p>
     * key不存在，返回defaultValue
     * </p>
     *
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public static String getValueWithDefault(String key, String defaultValue) {
        return environment.getProperty(key, defaultValue);
    }

}
