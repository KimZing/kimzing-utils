package com.kingboy.common.utils.page;


import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:53
 * @param <T> 实体类型
 * @desc  分页容器.
 */
public class PageResult<T> {

    //当前页
    private Integer pageNum;

    //每页容量
    private Integer pageSize;

    //总条数
    private Long total;

    //分页数据
    private List<T> data;

    public PageResult() {}

    public PageResult(Integer pageNum, Integer pageSize, Long total, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
