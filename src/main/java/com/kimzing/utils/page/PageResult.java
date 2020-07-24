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

    public PageResult(Long total, PageParam pageParam, List<T> list) {
        this(total, pageParam.getPageNum(), pageParam.getPageSize(), list);
    }

    public PageResult(Long total, Integer pageNum, Integer pageSize, List<T> list) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
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
    private List<T> list;

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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
