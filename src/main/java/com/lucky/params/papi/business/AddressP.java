package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-07-03
 */

@Data
public class AddressP {

    /**
     * 查询范围
     * <p>
     * 省:0
     * 市:1
     * 区:2
     */
    private Integer scope = 0;


    /**
     * 上级单元id,查询省市可空
     */
    private Integer itemId;


    /**
     * 用户名或者手机
     */
    private String userName;
}
