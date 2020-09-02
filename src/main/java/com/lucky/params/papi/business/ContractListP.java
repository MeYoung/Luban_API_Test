package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-06
 *
 * 合同列表参数q
 */

@Data
public class ContractListP {


    /**
     * 意向项目编号
     */
    private String applyProjectNo;

    /**
     * 合同类型
     *
     * 0- 合同列表(合作合同,销售协议,设计协议)
     * 1- 意向合同(意向书)
     */
    private Integer bizType;
}
