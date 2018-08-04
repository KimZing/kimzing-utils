package com.kingboy.common.utils.result;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:59
 * @desc  错误返回.
 */
public class ErrorApiResult extends ApiResult {

    private String message;

    ErrorApiResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
