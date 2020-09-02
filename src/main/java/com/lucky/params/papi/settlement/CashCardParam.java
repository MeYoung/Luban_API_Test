package com.lucky.params.papi.settlement;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author admin
 * @ModifyTime 2020/4/27 13:36
 * @Description 合伙人提现请求参数实体类，参考fi.base下的CashOutApplyDTO
 */
@Data
public class CashCardParam {
    /**
     * 门店主体ID(目前门店级别)
     */
    private Long financeBodyId;
    /**
     * 真实账户ID
     */
    private Long realAccountId;
    /**
     * 提现金额【不要带有逗号】
     */
    private BigDecimal amount;
}
