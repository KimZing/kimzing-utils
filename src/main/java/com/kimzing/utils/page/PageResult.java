package com.kimzing.utils.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/5 15:33
 */
public class PageResult<T> implements Serializable {

    public PageResult() { }

    public PageResult(Long total, PageParam pageParam, List<T> data) {
        this(total, pageParam.getPageNum(), pageParam.getPageSize(), data);
    }

    public PageResult(Long total, Integer pageNum, Integer pageSize, List<T> data) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.data = data;
    }

    /**
     * 总条数
     */
    private Long total;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 分页数据
     */
    private List<T> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
