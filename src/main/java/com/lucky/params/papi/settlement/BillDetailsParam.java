package com.lucky.params.papi.settlement;

import lombok.Data;

/**
 * @Author fengsen.deng
 * @ModifyTime 2020/4/27 18:35
 * @Description 合伙人提现记录详情查询参数
 */
@Data
public class BillDetailsParam {
    /**
     * 门店主体ID 【当queryType=2时，必传】
     */
    private String financeBodyId;
    /**
     * 提现工单ID【账单和交易-交易流水-查询 列表的transactionId，当queryType=1时，必传】
     */
    private Long id;
    /**
     * 查询类型
     */
    private Integer queryType;
    /**
     * 当前页（分页）
     */
    private Integer page;
    /**
     * 显示行数（分页）
     */
    private Integer rows;
}
