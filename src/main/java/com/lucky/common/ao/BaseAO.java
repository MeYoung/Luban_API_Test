package com.lucky.common.ao;

import java.util.Date;

/**
 * Created by wujinjiang on 2017/6/30.
 */
public class BaseAO {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 状态 0 无效 1有效
     */
    private Integer status;
    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建人名字
     */
    private String creatorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改人
     */
    private Long lastModifyBy;

    /**
     * 最后修改人名字
     */
    private String lastModifierName;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(Long lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
