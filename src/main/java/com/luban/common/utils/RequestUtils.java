package com.luban.common.utils;


import com.alibaba.fastjson.JSON;
import com.luban.common.report.TestStep;
import com.luban.params.BaseData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by shijin.huang on 2019/5/7
 * <p>
 * 简单封装了 post 和 get 请求方法，可以更具自己业务更改
 */
@Slf4j
public class RequestUtils {

    /**
     * get 请求
     *
     * @param url         请求地址
     * @param contentType contentType
     * @param cookies     cookies
     * @param headers     headers
     * @param mapParams   入参
     * @return
     */
    public static Response get(String url, String contentType, Map<String, String> cookies, Map<String, String> headers, Map<String, Object> mapParams) {
        log.info("请求URL：" + url);
        String jsonString = JSON.toJSONString(mapParams);
        log.info("请求参数：" + jsonString);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .cookies(cookies)
                .params(mapParams)
                .get(url);
        String body = response.getBody().asString();
        log.info("请求结果返回:" + body);
        new JsonPath(body).prettyPrint();
        TestStep.step(url, jsonString, body);
        return response;
    }


    /**
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, Object> params) {
        String contentType = "application/x-www-form-urlencoded";
        Response response = get(url, contentType, null, null, params);
        return response.getBody().asString();
    }

    /**
     * post 请求
     *
     * @param url         请求地址
     * @param contentType
     * @param cookies
     * @param headers
     * @param params      入参字符串
     * @return
     */
    public static Response post(String url, String contentType, Map<String, String> cookies, Map<String, String> headers, String params) {
        log.info("请求URL：" + url);
        log.info("请求参数：" + params);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .cookies(cookies)
                .body(params)
                .post(url);
        log.info("请求状态码：" + response.getStatusCode());
        String body = response.getBody().asString();
        log.info("请求结果:" + body);
        new JsonPath(body).prettyPrint();
        TestStep.step(url, params, body);
        return response;
    }

    /**
     * post 请求
     *
     * @param url    请求地址
     * @param params 请求参数，json格式的字符串
     * @return
     */
    public static String post(String url, String params) {
        String contentType = "application/json";
        Response response = post(url, contentType, null, null, params);
        String body = response.getBody().asString();
        return body;
    }

    /**
     * post 请求
     *
     * @param url    请求地址
     * @param object 请求参数，对象
     * @return
     */
    public static String post(String url, Object object) {
        String params = JSON.toJSONString(object);
        return post(url, params);
    }

    /**
     * post 请求
     *
     * @param url 请求地址
     * @param map
     * @return
     */
    public static String post(String url, Map<String, Object> map) {
        String jsonString = JSON.toJSONString(map);
        return post(url, jsonString);
    }


    /**
     * 文件上传，必须把文件放在test/resources下，并传入路径
     *
     * @param url         请求地址
     * @param object      q 对象
     * @param controlName 上传字段名
     * @param mimiType    上传类型 如图片的image/jpg
     * @param filePath    相对 test/resources 的路径
     * @return
     */
    public String postUpload(String url, String controlName, String mimiType, String filePath, Object object) {
        String qStr = JSON.toJSONString(object);
        log.info("请求URL：" + url);
        log.info("请求参数：" + qStr);
        String path = System.getProperty("user.dir");
        Response response = given()
                .contentType("multipart/form-data")
                .multiPart(controlName, new File(path + "/src/test/resources" + filePath), mimiType)
                .body(qStr)
                .post(url);
        log.info("请求状态码：" + response.getStatusCode());
        String body = response.getBody().asString();
        log.info("请求结果:" + body);
        TestStep.step(url, qStr, body);
        new JsonPath(body).prettyPrint();
        return body;
    }

}
