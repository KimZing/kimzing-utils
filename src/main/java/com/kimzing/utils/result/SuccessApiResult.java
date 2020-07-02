package com.kimzing.utils.result;

/**
 * 成功返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 17:19
 */
public final class SuccessApiResult<T> extends ApiResult {

    public SuccessApiResult() {
        this(null);
    }

    public SuccessApiResult(T data) {
        this.ts = System.currentTimeMillis();
        this.code = "0";
        this.message = "SUCCESS";
        this.data = data;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
