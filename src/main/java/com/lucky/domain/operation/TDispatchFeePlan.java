package com.lucky.domain.operation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 配送费方案
 *
 * @author shijin.huang
 */

@Data
@Table(name ="t_dispatch_fee_plan")
public class TDispatchFeePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 城市Id
     */
    private Long cityId;

    /**
     * 配送费规则方案id
     */
    private Long dispatchFeeRuleId;

    /**
     * 是否默认的适用时间段
     */
    private Integer isDefault;

    /**
     * 适用时间段起始时间
     */
    private LocalDate startTime;

    /**
     * 适用时间段截止时间
     */
    private LocalDate endTime;

    /**
     * 免配送费订单金额下限
     */
    private BigDecimal freeMinAmount;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建人名称
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Long lastModifyBy;

    /**
     * 最后修改人名称
     */
    private String lastModifierName;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastModifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 品牌主数据编号
     */
    private String brandMainDataNo;


}
