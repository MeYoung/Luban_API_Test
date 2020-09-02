package com.lucky.params.papi.withdrawablecash;

import lombok.Data;

/**
 * @Author admin
 * @ModifyTime 2020/4/28 9:30
 * @Description 银行卡查询参数
 */
@Data
public class WithDrawableCashParam {
    /**
     * 上级主体mid【当前用户ID】
     */
    private String userId;
    /**
     * 第几页
     */
    private Integer page;
    /**
     * 行数
     */
    private Integer rows;
}
