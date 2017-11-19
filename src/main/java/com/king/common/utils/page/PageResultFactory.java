package com.king.common.utils.page;


import com.king.common.utils.mapper.MapperUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:53
 * @desc  PageResul工厂.
 */
public class PageResultFactory {

    public  <T> PageResult createPageResult(int page, int count, List<T> data) {
        return new PageResult<T>(page, count, data);
    }

    public  <E> PageResult<E> convert(PageResult pageResult, Class<E> dtoClass) {
        List<E> dtoList = MapperUtils.mapperList(pageResult.getList(), dtoClass);
        return new PageResult<E>(pageResult.getPage(), pageResult.getCount(), dtoList);
    }

    public <T, E> PageResult<E> convert(PageResult<T> pageResult, Function<T, E> function) {
        return new PageResult<E>(pageResult.getPage(), pageResult.getCount(),
                pageResult.getList().stream().map(function).collect(Collectors.toList()));
    }

}
