package otp.lucky.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Author shijin.huang
 * @Date 2022/01/25
 */

@Slf4j
public class Get {

    public static Response get(String url) {
        Response response = given()
                .get(url);
        log.info("Get Response Body: {}", response.getBody());
        return response;
    }

    public static Response get(String url, String contentType) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return get(url, contentType, cookies, new HashMap<>(10));
    }

    public static Response get(String url, String contentType, Map<String, Object> params) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return get(url, contentType, cookies, params);
    }

    public static Response get(String url, Map<String, Object> params) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return get(url, ContentTypeEnum.FROM_URLENCODED.value(), cookies, params);
    }

    public static Response get(String url, String contentType, Map<String, String> cookies, Map<String, Object> params) {
        Response response = given().filter(new RestAssuredRequestFilter())
                .contentType(contentType)
                .cookies(cookies)
                .params(params)
                .get(url.trim());
        return response;
    }

    public static Response get(String url, Object object) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return get(url, ContentTypeEnum.FROM_URLENCODED.value(), cookies, object);
    }


    public static Response get(String url, String contentType, Object object) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return get(url, contentType, cookies, object);
    }

    public static Response get(String url, String contentType, Map<String, String> cookies, Object object) {
        // 字符串转map
        HashMap params = JSONObject.parseObject(JSON.toJSONString(object), HashMap.class);
        Response response = given().filter(new RestAssuredRequestFilter())
                .contentType(contentType)
                .cookies(cookies)
                .params(params)
                .get(url.trim());
        return response;
    }

}
