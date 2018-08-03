package com.kingboy.common.utils.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:54
 * @desc  属性映射工具.
 */
public final class MapperUtils {

    /**
     * 构建一个Mapper工厂
     */
    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    /**
     * 将s属性映射到R的具体实例上
     * @param s 已有的Bean,源Bean
     * @param rClass
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> R mapperBean(S s, Class<R> rClass) {
        return MAPPER_FACTORY.getMapperFacade().map(s, rClass);
    }

    /**
     * 将s属性映射到R的具体实例上,如果转换的属性名不一样，可以传入Map进行说明
     * @param s 已有的Bean,源Bean
     * @param rClass
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> R mapperBean(S s, Class<R> rClass, Map<String, String> diffFieldMap) {
        ClassMapBuilder<?, R> classMap = MAPPER_FACTORY.classMap(s.getClass(), rClass);
        diffFieldMap.forEach(classMap::field);
        classMap.byDefault()
                .register();
        return MAPPER_FACTORY.getMapperFacade().map(s, rClass);
    }

    /**
     * 将s的集合射成R的集合
     * @param sList 已有的Bean的集合
     * @param rClass 要转换的类型
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> List<R> mapperList(List<S> sList, Class<R> rClass) {
        return MAPPER_FACTORY.getMapperFacade().mapAsList(sList, rClass);
    }

    /**
     * 将s的集合射成R的集合,不同的属性通过Map<String, String> 传入
     * @param sList 已有的Bean的集合
     * @param rClass 要转换的类型
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> List<R> mapperList(List<S> sList, Class<R> rClass, Map<String, String> diffFieldMap) {
        if (sList.isEmpty()) {
            return Collections.emptyList();
        }
        ClassMapBuilder<?, R> classMap = MAPPER_FACTORY.classMap(sList.get(0).getClass(), rClass);
        diffFieldMap.forEach(classMap::field);
        classMap.byDefault()
                .register();
        return MAPPER_FACTORY.getMapperFacade().mapAsList(sList, rClass);
    }
}
