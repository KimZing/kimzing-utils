package com.kingboy.common.utils.page;


import com.kingboy.common.utils.mapper.MapperUtils;

import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:53
 * @desc  PageResul工厂.
 */
public class PageResultFactory {

    public  <T, E> PageResult<E> createAndConvert(long page, long count, List<T> data, Class<E> dtoClass) {
        List<E> dtoList = MapperUtils.mapperList(data, dtoClass);
        PageResult<E> pageResult = new PageResult<>(page, count, dtoList);
        return pageResult;
    }

}
