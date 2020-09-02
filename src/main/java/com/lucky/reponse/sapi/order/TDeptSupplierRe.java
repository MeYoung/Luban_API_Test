package com.lucky.reponse.sapi.order;

import lombok.Data;

/**
 * @author shijin.huang
 * @date 2019-10-22
 * @content 配送商信息
 */

@Data
public class TDeptSupplierRe {

    private Long deptId;

    private Long supplierId;

    /**
     * 是否强制停止 0否 1是
     */
    private Integer forceStopCooperation;
    /**
     * 优先级
     */
    private Integer level;

    /**
     * 门店使用状态
     */
    private Integer status;

    private String supplierCity;

    private String supplierName;

    private String supplierNo;
    private Integer supplierStatus;
    private Integer supplierType;
}
