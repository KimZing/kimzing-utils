package com.kimzing.utils.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 业务实体公共属性.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 13:10
 */
public abstract class AbstractBO {

    protected  Integer id;

    protected Integer deleted;

    protected String creator;

    protected String modifier;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public AbstractBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public AbstractBO setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public AbstractBO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getModifier() {
        return modifier;
    }

    public AbstractBO setModifier(String modifier) {
        this.modifier = modifier;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public AbstractBO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public AbstractBO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
