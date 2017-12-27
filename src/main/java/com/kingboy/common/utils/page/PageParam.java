package com.kingboy.common.utils.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:54
 * @desc  分页请求参数封装, 仅适用于hibernate.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    //当前页
    private Integer page = 1;

    //每页容量
    private Integer size = 10;

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
}
