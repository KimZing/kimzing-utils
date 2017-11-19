package com.king.common.utils.apiresult;

import lombok.Data;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:59
 * @desc  错误返回.
 */
@Data
public class ErrorApiResult extends AbstractApiResult {

    private String msg;

    ErrorApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
