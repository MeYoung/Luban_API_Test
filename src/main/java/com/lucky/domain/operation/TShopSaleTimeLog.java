package com.lucky.domain.operation;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 门店营业时间记录表
 *
 * @author shijin.huang
 */

@Data
@Table(name ="t_shop_sale_time_log")
public class TShopSaleTimeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    private LocalDateTime logDate;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 门店ID
     */
    private Long shopId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 门店序号
     */
    private String sequenceNumber;

    /**
     * 营业开始时间
     */
    private String saleStartTime;

    /**
     * 营业结束时间
     */
    private String saleEndTime;

    /**
     * 营业时间方案ID
     */
    private Long saleTimePlanId;

    /**
     * 时间方案编号
     */
    private String planNo;

    /**
     * 时间方案名称
     */
    private String planName;

    /**
     * 方案类型：1：营业时间方案，2：配送时间方案,3：特殊营业时间方案，4：特殊配送时间方案
     */
    private Integer planType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 运营合作模式主数据编号：直营，代理
     */
    private String cooperationMainDataNo;

    /**
     * 运营合作模式名称：直营，代理
     */
    private String cooperationName;

    /**
     * 品牌主数据编号
     */
    private String brandMainDataNo;

    /**
     * 品牌名称
     */
    private String brandName;


}
