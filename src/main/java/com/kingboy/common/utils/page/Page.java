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
    private List data = Collections.emptyList();

    public Page() {
        //do nothing
    }

    /**
     * 构造函数.
     * <p></p>
     * @param page
     * @param size
     * @return null
     * @author KingBoy
     * @since 2018-08-10 23:23:26
     *
     */
    public Page(Long page, Long size) {
        this(page, size, 0L, Collections.emptyList());
    }

    /**
     * 构造函数
     * @param page
     * @param size
     * @param total
     * @param data
     */
    public Page(Long page, Long size, Long total, List data) {
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
     * <p></p>
     * @return java.lang.Integer
     * @author KingBoy
     * @since 2018-08-10 23:26:33
     *
     */
    public Long getStart() {
        return (this.page - 1) * this.size;
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

    public void setData(List data) {
        if (data != null && data.size() > 0) {
            this.data = data;
        }
    }
}
