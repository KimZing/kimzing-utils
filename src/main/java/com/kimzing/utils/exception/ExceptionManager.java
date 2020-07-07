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
     * 创建业务异常
     *
     * @param code
     * @return
     */
    public static BusinessException createByCode(String code) {
        return new BusinessException(code, null);
    }

    public static BusinessException createByMessage(String message) {
        return new BusinessException(null, message);
    }

    public static BusinessException createByCodeAndMessage(String code, String message) {
        return new BusinessException(code, message);
    }
}
