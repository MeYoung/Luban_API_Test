package com.lucky.params.papi.user;

import lombok.Data;

/**
 * @Author admin
 * @ModifyTime 2020/4/27 15:48
 * @Description 合伙人提现登陆参数
 */
@Data
public class LoginParam {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * 注册id
     */
    private String regId;

    /**
     * 渠道
     */
    private Integer origin;
    /**
     * 图片验证码
     */
    private String identifyCode;

}
