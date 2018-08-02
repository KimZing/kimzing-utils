package com.kingboy.common.utils.result;

/**
 * @author    kingboy--KingBoyWorld@163.com
 * @date    2017/7/21 上午11:28
 * @desc    正确返回体
 */
public class SuccessApiResult extends ApiResult {

    private Object data;

    SuccessApiResult(Object data) {
        this.code = "0";
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
