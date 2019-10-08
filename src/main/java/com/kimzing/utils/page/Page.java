package com.kimzing.utils.page;

import com.kimzing.utils.mapper.MapperUtils;

import java.util.Collections;
import java.util.List;

/**
 * 分页结果.
 * <p>
 * MybatisPlus与PageHelper开源库中的分页功能已经做得很好了,可以直接使用自带的分页
 * </p>
 *
 * @param <T>
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public class Page<T> {

    /**
     * 当前页
     */
    private Long page = 1L;

    /**
     * 每页容量
     */
    private Long size = 10L;


    /**
     * 总页数
     */
    private Long total = 0L;

    /**
     * 分页数据
     */
    private List<T> data = Collections.emptyList();

    public Page() {
        //do nothing
    }

    /**
     * 构造函数.
     *
     * @param page
     * @param size
     * @return null
     */
    public Page(Long page, Long size) {
        this(page, size, 0L, Collections.emptyList());
    }

    /**
     * 构造函数
     *
     * @param page
     * @param size
     * @param total
     * @param data
     */
    public Page(Long page, Long size, Long total, List<T> data) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = data;
    }

    public void convert(Class clazz) {
        this.data = MapperUtils.mapperList(this.data, clazz);
    }

    /**
     * 获取数据库查询起始数.
     *
     * @return java.lang.Integer
     */
    public Long getStart() {
        if (page > 0 && size > 0) {
            return (this.page - 1L) * this.size;
        }
        return 0L;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        if (page > 0) {
            this.page = page;
        }
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        if (size > 0) {
            this.size = size;
        }
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        if (total >= 0) {
            this.total = total;
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List<T> data) {
        if (data != null && data.size() > 0) {
            this.data = data;
        }
    }
}
