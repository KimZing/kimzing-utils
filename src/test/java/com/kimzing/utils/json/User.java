package com.kimzing.utils.json;

import java.time.LocalDateTime;

/**
 * 用户.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 14:53
 */
public class User {

    private String name;

    private Integer age;

    private LocalDateTime birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
