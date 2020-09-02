package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-13
 *
 * 意向项目对象 q
 */

@Data
public class ApplyProjectP {

    /**
     * 意向项目编号
     */
    private String applyProjectNo;


    /**
     * 意向项目编号（选址用）
     */
    private String thirdPurpose;
}
