package com.kimzing.utils.po;

import java.time.LocalDateTime;

/**
 * 数据实体公共属性.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/28 13:10
 */
public abstract class AbstractPO {

    protected  Integer id;

    protected Integer deleted;

    protected String creator;

    protected String modifier;

    protected LocalDateTime createTime;

    protected LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public AbstractPO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public AbstractPO setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public AbstractPO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getModifier() {
        return modifier;
    }

    public AbstractPO setModifier(String modifier) {
        this.modifier = modifier;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public AbstractPO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public AbstractPO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
