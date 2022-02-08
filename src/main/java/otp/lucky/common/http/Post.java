package otp.lucky.common.http;

import com.alibaba.fastjson.JSON;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Author shijin.huang
 * @Date 2022/01/25
 */
public class Post {

    public static Response postFrom(String url, String contentType, Map<String, String> cookies, Map<String, Object> params) {

        Response response = given().filter(new RestAssuredRequestFilter())
                .contentType(contentType)
                .cookies(cookies)
                .params(params)
                .post(url);
        return response;
    }

    public static Response postFrom(String url, Map<String, Object> params) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return postFrom(url, ContentTypeEnum.FROM_URLENCODED.value(), cookies, params);
    }

    public static Response postJson(String url, Map<String, String> cookies, Object object) {
        String params = JSON.toJSONString(object);
        Response response = given().filter(new RestAssuredRequestFilter())
                .contentType(ContentTypeEnum.JSON.value())
                .cookies(cookies)
                .body(params)
                .post(url);
        return response;
    }

    public static Response postJson(String url, Object object) {
        Map<String, String> cookies = GlobalCookieManager.getInstance().getCookies();
        return postJson(url, cookies, object);
    }


}
