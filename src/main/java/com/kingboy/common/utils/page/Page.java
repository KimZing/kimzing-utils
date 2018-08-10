package com.kingboy.common.utils.page;

import com.kingboy.common.utils.mapper.MapperUtils;

import java.util.ArrayList;
import java.util.Collections;
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
public class Page {

    /**
     * 当前页
     */
    private Integer page = 1;

    /**
     * 每页容量
     */
    private Integer size = 10;


    /**
     * 总页数
     */
    private Long total = 0L;

    /**
     * 分页数据
     */
    private List data = Collections.emptyList();

    public Page() {
        //do nothing
    }

    public Page(Integer page, Integer size) {
        this(page, size, 0L, Collections.emptyList());
    }

    public Page(Integer page, Integer size, Long total, List data) {
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
        if (page > 0) {
            this.page = page;
        }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
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

    public void setData(List data) {
        if (data != null && data.size() > 0) {
            this.data = data;
        }
    }
}
