package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-07-01
 * <p>
 * 保存完成注册信息
 */

@Data
public class RegistrationInfoP {


    /**
     * 意向用户名
     */
    private String applyName;

    /**
     * 省份
     */
    private String provinceName;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 行业
     */
    private String engageJob;

    /**
     * 是否有店铺
     */
    private Integer isExistShop;

    /**
     * 是否自己经营
     */
    private Integer isOperationSelf;

    /**
     * 设置密码 Zc123456
     */
    private String password = "a94e62ea84024fbc8d88ba2cc83c9e65fb952f07";


    /**
     * 临时Uid
     */
    private String tempUid;

    /**
     * 手机号码
     */
    private String mobile;
}
