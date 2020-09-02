package com.lucky.params.papi.base;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-07
 *
 * 获取验证码 参数q
 */

@Data
public class IdentifyCodeSmsP {

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码类型
     *
     * 0- 忘记密码
     *
     * 1- 修改密码
     *
     * 3-意向客户登录
     *
     * 4-意向签到登录
     *
     * 5-注册
     *
     * 6-注册用户登录
     *
     * 8-员工端改密码
     *
     * 9-luckycoffee临时登录
     */
    private Integer codeType;
}
