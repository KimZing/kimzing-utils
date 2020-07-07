package com.kimzing.utils.result;


/**
 * 成功返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 17:19
 */
public final class ErrorApiResult extends ApiResult {

    /**
     * 错误信息
     */
    public String message;

    public ErrorApiResult(String code, String message) {
        this.timestamp = System.currentTimeMillis();
        this.code = code;
        this.message = message;
    }

}
