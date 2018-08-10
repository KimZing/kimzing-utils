package com.kingboy.common.utils.page;

/**
 * 分页参数.
 * <p>
 *     MybatisPlus与PageHelper开源库中的分页功能已经做得很好了,可以直接使用自带的分页
 * </p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public class PageParam {

    /**
     * 当前页
     */
    private Integer page = 1;

    /**
     *每页容量
     */
    private Integer size = 10;

    public PageParam() {
        //do nothing
    }

    /**
     * 构造方法
     * <p></p>
     * @param page 当前页
     * @param size 分页容量
     * @return null
     * @author KingBoy
     * @since 2018-08-10 14:11:01
     *
     */
    public PageParam(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public void setPage(Integer page) {
        if (page > 0) {
            this.page = page;
        }
    }

    public void setSize(Integer size) {
        if (size > 0) {
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
