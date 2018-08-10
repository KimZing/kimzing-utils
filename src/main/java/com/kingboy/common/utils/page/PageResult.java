package com.kingboy.common.utils.page;

import com.kingboy.common.utils.mapper.MapperUtils;

import java.util.List;

/**
 * 分页结果.
 * <p>
 *     MybatisPlus与PageHelper开源库中的分页功能已经做得很好了,可以直接使用自带的分页
 * </p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public class PageResult {

    /**
     * 分页参数
     */
    private PageParam pageParam;

    /**
     * 分页数据
     */
    private List data;

    public PageResult(PageParam pageParam, List data) {
        this.pageParam = pageParam;
        this.data = data;
    }

    public void convertType(Class clazz) {
        this.data = MapperUtils.mapperList(this.data, clazz);
    }

    public PageParam getPageParam() {
        return pageParam;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
