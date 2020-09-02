package com.lucky.params.papi.base;

import lombok.Data;

/**
 * Created by liping.li on 2020-04-27
 *
 * 登陆参数 q
 */

@Data
public class LoginP {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 来源
     */
    private String origin;


}
