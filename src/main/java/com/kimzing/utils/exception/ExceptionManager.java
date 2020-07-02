package com.kimzing.utils.exception;

/**
 * 异常管理类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 15:09
 */
public class ExceptionManager {

    private ExceptionManager() {}

    /**
     * 创建自定义异常
     *
     * @param code
     * @return
     */
    public static BusinessException create(String code) {
        return new BusinessException(code);
    }

}
