package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-07-01
 * <p>
 * 意向用户对象
 */

@Data
public class ApplyUserP extends RegistrationInfoP {

    /**
     * 手机号
     */
    private String mobile;


    /**
     * 性别
     */
    private Integer applyGender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String presentAddress;
}
