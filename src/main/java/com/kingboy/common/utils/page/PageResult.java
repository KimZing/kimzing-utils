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
    private long page;
    //总数量
    private long size;
    //分页数据
    private List<T> list;

    public PageResult() {}

    public PageResult(long page, long size, List<T> list) {
        this.page = page;
        this.size = size;
        this.list = list;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
