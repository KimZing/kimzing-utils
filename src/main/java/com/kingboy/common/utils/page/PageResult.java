package com.kingboy.common.utils.page;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:53
 * @param <T> 实体类型
 * @desc  分页容器.
 */
@Data
@NoArgsConstructor
public class PageResult<T> {

    //当前页
    private Integer page;
    //总数量
    private long size;
    //分页数据
    private List<T> list;

    public PageResult(int page, long size, List<T> list) {
        this.page = page;
        this.size = size;
        this.list = list;
    }

}
