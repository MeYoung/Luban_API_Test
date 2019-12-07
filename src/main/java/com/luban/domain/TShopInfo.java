package com.luban.domain;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_shop_info
 * @author 
 */
@Table(name = "t_shop_info")
@Data
public class TShopInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 门店序号
     */
    private String sequenceNumber;

    /**
     * 编号
     */
    private String shopNo;

}