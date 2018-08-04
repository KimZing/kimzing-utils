package com.kingboy.common.utils.page;


import com.github.pagehelper.Page;
import com.kingboy.common.utils.mapper.MapperUtils;

import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:53
 * @desc  PageResul工厂.
 */
public class PageResultFactory {

    public static <T, E> PageResult<E> createAndConvert(Integer pageNum, Integer pageSize, Long total, List<T> data, Class<E> dtoClass) {
        List<E> dtoList = MapperUtils.mapperList(data, dtoClass);
        PageResult<E> pageResult = new PageResult<>(pageNum, pageSize, total, dtoList);
        return pageResult;
    }

    /**
     * 为PageHelper提供
     * @param page
     * @param dtoClass
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> PageResult<E> createAndConvert(Page<T> page, Class<E> dtoClass) {
        List<E> dtoList = MapperUtils.mapperList(page.getResult(), dtoClass);
        PageResult<E> pageResult = new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), dtoList);
        return pageResult;
    }

}
