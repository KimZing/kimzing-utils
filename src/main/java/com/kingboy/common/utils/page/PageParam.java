package com.kingboy.common.utils.page;

import java.util.Objects;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:54
 * @desc  分页请求参数封装
 */
public class PageParam {

    //当前页
    private Integer page = 1;

    //每页容量
    private Integer size = 10;

    public PageParam() {}

    public PageParam(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public Integer getHibernatePage() {
        return page - 1;
    }

    public Integer getMybatisPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (Objects.nonNull(page)) {
            this.page = page;
        }
    }

    public void setSize(Integer size) {
        if (Objects.nonNull(size)) {
            this.size = size;
        }
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }
}
