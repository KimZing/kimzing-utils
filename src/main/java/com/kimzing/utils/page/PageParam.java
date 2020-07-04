package com.kimzing.utils.page;

import java.io.Serializable;

/**
 * 分页查询对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:38
 */
public class PageParam implements Serializable {

    /**
     * 当前页数
     */
    private Integer pageNum;

    /**
     * 分页大小
     */
    private Integer pageSize;

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
}
