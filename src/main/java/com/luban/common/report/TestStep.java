package com.luban.common.report;

import com.alibaba.fastjson.JSONObject;
import com.luban.params.BaseData;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shijin.huang
 * @date 2019-08-12
 * <p>
 * 报告中写入测试步骤
 */
@Slf4j
public class TestStep {

    public static void step(String URL, String Body, String Respond) {
        requestStep(URL, Body);
        respondStep(Respond);
    }

    @Attachment("请求报文")
    public static String requestStep(String URL, String body) {
        String str = body;
        try {
            //格式化json串
            boolean prettyFormat = true;
            JSONObject jsonObject = JSONObject.parseObject(body);
            str = JSONObject.toJSONString(jsonObject, prettyFormat);

        } catch (Exception e) {
            log.error("请求报文非json格式，解析错误");
        }

        //报告展现请求报文
        return URL + "\n" + str;
    }


    @Attachment("响应报文")
    public static String respondStep(String respond) {
        String str = respond;
        try {
            //格式化json串
            boolean prettyFormat = true;
            JSONObject jsonObject = JSONObject.parseObject(respond);
            str = JSONObject.toJSONString(jsonObject, prettyFormat);
        } catch (Exception e) {
            log.error("响应报文非json格式，解析错误");
        }
        //报告展现响应报文
        return str;
    }


    @Attachment("初始化数据")
    public static String baseDataStep(BaseData baseData) {
        return baseData.toString();
    }


}
