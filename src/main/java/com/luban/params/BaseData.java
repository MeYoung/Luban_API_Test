package com.luban.params;

import lombok.Data;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

/**
 * Created by shijin.huang on 2019/7/20
 * <p>
 * 存放登录用户相关信息和公共全局变量
 */
@Data
public class BaseData {


    /**
     * APP 版本
     */
    private String appversion;
    /**
     * 环境
     */
    private String env;
    /**
     * uid
     */
    private String uid;
    /**
     * 登录账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * cookies
     */
    private Map<String,String> cookies;
    /**
     * 平台
     */
    private String platform;

    /**
     * base 服务地址
     */
    private String baseURL;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * operation 库的SqlSession
     */
    private SqlSession sessionOperation;


}
