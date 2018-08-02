package com.kingboy.common.utils.result;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:59
 * @desc  错误返回.
 */
public class ErrorApiResult extends ApiResult {

    private String msg;

    ErrorApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
