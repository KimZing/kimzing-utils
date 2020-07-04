package com.kimzing.utils.po;

/**
 * 是否删除.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:42
 */
public enum DeleteEnum {

    DELETED("已删除"),
    NOT_DELETE("未删除");

    private String name;

    DeleteEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
