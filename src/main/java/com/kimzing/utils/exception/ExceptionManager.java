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
    public static CustomException createByCode(String code) {
        return new CustomException(code, null);
    }

    public static CustomException createByMessage(String message) {
        return new CustomException(null, message);
    }

    public static CustomException createByCodeAndMessage(String code, String message) {
        return new CustomException(code, message);
    }
}
