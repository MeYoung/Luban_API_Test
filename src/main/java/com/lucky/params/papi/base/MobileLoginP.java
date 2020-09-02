package com.lucky.params.papi.base;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-13
 * <p>
 * 手机号登陆参数 q
 */

@Data
public class MobileLoginP {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机验证码
     */
    private String identifyCodeSms;


    /**
     * 用户类型
     * <p>
     * 0-意向客户登录
     * <p>
     * 1-注册用户登录
     * <p>
     * 2-瑞划算用户登录
     */
    private String userType;

    /**
     * 来源
     * <p>
     * 0-h5
     * <p>
     * 20- android
     * <p>
     * 21- ios
     */
    private Integer origin;

}
