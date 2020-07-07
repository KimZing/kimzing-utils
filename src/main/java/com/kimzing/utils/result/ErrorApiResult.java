package com.kimzing.utils.result;


import java.io.Serializable;

/**
 * 成功返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 17:19
 */
public final class ErrorApiResult extends ApiResult implements Serializable {

    private static final long serialVersionUID = 1L;

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
