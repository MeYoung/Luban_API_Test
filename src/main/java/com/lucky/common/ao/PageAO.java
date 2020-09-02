package com.lucky.common.ao;

import java.io.Serializable;

/**
 * <p>分页公共AO</p>
 *
 * @author zhihong.chen
 * Create date 2018/10/20
 */
public class PageAO implements Serializable {

    private static final long serialVersionUID = 5259495142741328012L;
    /**
     * 第几页（从1开始）
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 偏移量
     */
    private Integer start;

    /**
     * 数据权限类型
     */
    private Integer dataAuthType;

    /**
     * 登陆用户id
     */
    private Long currentEmployeeId;

    /**
     * 部门权限范围
     */
    private String deptAuthScope;

    /**
     * 城市权限范围
     */
    private String cityAuthScope;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        if(pageNo != null && pageSize != null){
            this.start = (this.pageNo > 0 ? this.pageNo - 1 : 0) * this.pageSize;
            return start;
        }else{
            return null;
        }
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 获取 数据权限类型
     *
     * @return dataAuthType 数据权限类型
     */
    public Integer getDataAuthType() {
        return this.dataAuthType;
    }

    /**
     * 设置 数据权限类型
     *
     * @param dataAuthType 数据权限类型
     */
    public void setDataAuthType(Integer dataAuthType) {
        this.dataAuthType = dataAuthType;
    }

    /**
     * 获取 登陆用户id
     *
     * @return currentEmployeeId 登陆用户id
     */
    public Long getCurrentEmployeeId() {
        return this.currentEmployeeId;
    }

    /**
     * 设置 登陆用户id
     *
     * @param currentEmployeeId 登陆用户id
     */
    public void setCurrentEmployeeId(Long currentEmployeeId) {
        this.currentEmployeeId = currentEmployeeId;
    }

    /**
     * 获取 部门权限范围
     *
     * @return deptAuthScope 部门权限范围
     */
    public String getDeptAuthScope() {
        return this.deptAuthScope;
    }

    /**
     * 设置 部门权限范围
     *
     * @param deptAuthScope 部门权限范围
     */
    public void setDeptAuthScope(String deptAuthScope) {
        this.deptAuthScope = deptAuthScope;
    }

    /**
     * 获取 城市权限范围
     *
     * @return cityAuthScope 城市权限范围
     */
    public String getCityAuthScope() {
        return this.cityAuthScope;
    }

    /**
     * 设置 城市权限范围
     *
     * @param cityAuthScope 城市权限范围
     */
    public void setCityAuthScope(String cityAuthScope) {
        this.cityAuthScope = cityAuthScope;
    }
}
