package com.king.common.utils.page;


import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:53
 * @param <T> 实体类型
 * @desc  分页容器.
 */
public class PageResult<T> {

    private PageResult() { }
    //当前页
    private Integer page;
    //总数量
    private Integer count;
    //分页数据
    private List<T> list;

    public  PageResult(int page, int count, List<T> list) {
        this.page = page;
        this.count = count;
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
