package com.kimzing.utils.exception;

import java.io.Serializable;
import java.util.Map;

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
    private String appName;

    /**
     * 接口名称
     */
    private String interName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 服务地址
     */
    private String address;

    /**
     * 附加信息
     */
    private Map<String, Object> attach;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getInterName() {
        return interName;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Object> getAttach() {
        return attach;
    }

    public void setAttach(Map<String, Object> attach) {
        this.attach = attach;
    }
}
