package com.lucky.params.papi.business.fixedfee;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 左轮(haiyong.he @ luckincoffee.com)
 * @desc
 * @name FixedFeeP
 * @date 2020/5/8
 **/
@Data
public class FixedFeeP {

    /**
     * 费用编号
     */
    private String feeNo;

    /**
     * 费用名称
     */
    private String feeName;

    /**
     * 缴费日期（月度费用才有值）
     */
    private Date paymentDate;

    /**
     * 金额
     */
    private BigDecimal amountMoney;
}
