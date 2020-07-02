package com.kimzing.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

/**
 * Spring容器工具.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-07-17 10:41
 */
public final class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 根据Class获取T的实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getSingleBeanByClass(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 根据名称和Class获取T实例
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getSingleBeanByNameAndClass(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 以Map形式获取T的所有实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansByTypeToMap(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

    /**
     * 以Collection形式获取T的所有实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Collection<T> getBeansByTypeToCollection(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz).values();
    }


    /**
     * 获取当前上下文对象
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
