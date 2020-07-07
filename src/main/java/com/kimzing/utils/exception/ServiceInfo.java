package com.kimzing.utils.exception;

import java.io.Serializable;

/**
 * 服务信息.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/7 17:34
 */
public class ServiceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务地址
     */
    private String host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
