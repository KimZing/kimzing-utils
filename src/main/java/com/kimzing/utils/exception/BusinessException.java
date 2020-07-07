package com.kimzing.utils.exception;

import java.util.List;

/**
 * 自定义业务异常类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/24 14:17
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String code, String message) {
        this.timestamp = System.currentTimeMillis();
        this.code = code;
        this.message = message;
    }

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 异常code码
     */
    private String code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 服务调用链信息
     */
    private List<ServiceInfo> services;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ServiceInfo> getServices() {
        return services;
    }

    public void setServices(List<ServiceInfo> services) {
        this.services = services;
    }
}
