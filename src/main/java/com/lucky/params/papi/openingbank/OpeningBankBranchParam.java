package com.lucky.params.papi.openingbank;

import lombok.Data;

/**
 * @Author admin
 * @ModifyTime 2020/4/28 9:15
 * @Description 开户行支行请求参数
 */
@Data
public class OpeningBankBranchParam {
    /**
     * 银行编码
     */
    private String bankCod   ;
    /**
     * 当前页
     */
    private Integer  page;
    /**
     * 每页大小
     */
    private Integer  rows;

    /**
     * 银行支行名称
     */
    private String name;

}
