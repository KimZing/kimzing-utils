package com.kimzing.utils.exception;

/**
 * 自定义业务异常类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/24 14:17
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String code) {
        super(code);
    }

}
