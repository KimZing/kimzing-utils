package com.kimzing.utils.result;

/**
 * 返回数据包装体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public abstract class AbstractApiResult {

    /**
     * 状态码
     */
    protected String code;

    /**
     * 成功的返回.
     *
     * @param data 数据
     * @return ApiResult 正常返回体
     */
    public static AbstractApiResult success(Object data) {
        return new SuccessApiResult(data);
    }

    /**
     * 错误返回.
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return ApiResult 错误返回体
     */
    public static AbstractApiResult error(String errorCode, String errorMessage) {
        return new ErrorApiResult(errorCode, errorMessage);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
