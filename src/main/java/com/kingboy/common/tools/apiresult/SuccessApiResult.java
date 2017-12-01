package com.kingboy.common.tools.apiresult;

import lombok.Data;

/**
 * @author    kingboy--KingBoyWorld@163.com
 * @date    2017/7/21 上午11:28
 * @desc    正确返回体
 */
@Data
public class SuccessApiResult extends AbstractApiResult {

    private Object data;

    SuccessApiResult(Object data) {
        this.code = "0";
        this.data = data;
    }

}
