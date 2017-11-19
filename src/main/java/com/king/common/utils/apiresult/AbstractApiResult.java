package com.king.common.utils.apiresult;

import lombok.Data;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午7:19
 * @desc  返回体.
 */
@Data
public abstract class AbstractApiResult {

    protected String code;

    /**
     * 成功的返回
     * @param data 数据
     * @return 正常返回体
     */
    public static AbstractApiResult success(Object data) {
        return new SuccessApiResult(data);
    }

    /**
     * 错误返回
     * @param errorCode 错误码
     * @param errorMessage 错误信息
     * @return 错误返回体
     */
    public static AbstractApiResult error(String errorCode, String errorMessage) {
        return new ErrorApiResult(errorCode, errorMessage);
    }


}
