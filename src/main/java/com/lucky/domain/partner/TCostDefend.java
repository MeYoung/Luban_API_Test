package com.lucky.domain.partner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 成本维护表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_cost_defend")
public class TCostDefend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 门店序号
     */
    private String shopNcCode;

    /**
     * 费用编号
     */
    private String feeNo;

    /**
     * 费用名称
     */
    private String feeName;

    /**
     * 费用类型(固定or月度） ， 枚举类
     */
    private Integer feeType;

    /**
     * 缴费日期（费用类型为月度才有值）
     */
    private Date paymentDate;

    /**
     * 金额
     */
    private BigDecimal amountMoney;

    /**
     * 新建人id
     */
    private Integer creatorId;

    /**
     * 新建人
     */
    private String creatorName;

    /**
     * 新建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Integer modifierId;

    /**
     * 最后修改人
     */
    private String modifierName;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 意向项目编号
     */
    private String applyProjectNo;

    /**
     * 最后修改来源
     */
    private String modifyOrigin;


}
