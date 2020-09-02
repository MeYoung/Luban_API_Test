package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-15
 *
 * 查询选址详情 参数q
 */

@Data
public class ExpansionInfoP {

    /**
     * 项目id
     */
    private String projectId;


    /**
     * 意向编号
     */
    private String thirdPurpose;
}
