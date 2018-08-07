package com.kingboy.common.utils.result;

/**
 * 正确返回体.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public class SuccessApiResult extends ApiResult {

    /**
     * 响应数据
     */
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
