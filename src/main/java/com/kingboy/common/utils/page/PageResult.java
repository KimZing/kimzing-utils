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
     * 当前页
     */
    private Integer page;

    /**
     * 每页容量
     */
    private Integer size;


    /**
     * 总页数
     */
    private Long total;

    /**
     * 分页数据
     */
    private List data;

    public PageResult(PageParam pageParam, List data) {
        this(pageParam, 0L, data);
    }

    public PageResult(PageParam pageParam, Long total, List data) {
        this(pageParam.getPage(), pageParam.getSize(), total, data);
    }

    public PageResult(Integer page, Integer size, Long total, List data) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = data;
    }

    public void convert(Class clazz) {
        this.data = MapperUtils.mapperList(this.data, clazz);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
