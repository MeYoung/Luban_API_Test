package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-07-02
 * <p>
 * 合作伙伴注册
 */

@Data
public class RegisterP {


    /**
     * 注册手机号
     */
    private String phoneNum;

    /**
     * 手机验证码
     */
    private String identifyCodeSms;
}
