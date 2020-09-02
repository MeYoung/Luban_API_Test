package com.lucky.params.papi.openingbank;

import lombok.Data;

/**
 * @Author admin
 * @ModifyTime 2020/4/28 9:16
 * @Description 开户行请求参数
 */
@Data
public class OpeningBankParam {
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页大小
     */
    private Integer rows;

    /**
     * 名称
     */
    private String name;
}
