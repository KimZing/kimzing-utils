package com.kimzing.utils.result;

/**
 * 错误返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public class ErrorApiResult extends AbstractApiResult {

    /**
     * 错误信息
     */
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
