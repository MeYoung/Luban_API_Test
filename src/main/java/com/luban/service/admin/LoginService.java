package com.luban.service.admin;

import com.alibaba.fastjson.JSON;
import com.luban.common.utils.RequestUtils;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijin.huang
 * @date 2019-09-10
 */
public class LoginService {

    /**
     * admin 登录
     *
     * @param baseLoginURL base url
     * @param userName     账号
     * @param password     密码
     * @return cookies
     */
    public static Map<String, String> login(String baseLoginURL, String userName, String password) {
        String loginUrl = baseLoginURL + "/xxx/login.do_";
        Map<String, Object> params = new HashMap<>();
        params.put("username", userName);
        params.put("password", password);
        String jsonString = JSON.toJSONString(params);
        String contentType = "application/json";
        Response response = RequestUtils.post(loginUrl, contentType, null, null, jsonString);
        Map<String, String> loginCookeis = response.getCookies();
        return loginCookeis;
    }
}
