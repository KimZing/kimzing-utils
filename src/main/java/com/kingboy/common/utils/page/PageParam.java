package com.kingboy.common.utils.page;

import java.util.Objects;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:54
 * @desc  分页请求参数封装
 */
public class PageParam {

    //当前页
    private Integer pageNum = 1;

    //每页容量
    private Integer pageSize = 10;

    public PageParam() {}

    public PageParam(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getHibernatePageNum() {
        return pageNum - 1;
    }

    public Integer getMybatisPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (Objects.nonNull(pageNum)) {
            this.pageNum = pageNum;
        }
    }

    public void setPageSize(Integer pageSize) {
        if (Objects.nonNull(pageSize)) {
            this.pageSize = pageSize;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }
}
