package com.lucky.common.report;

import com.alibaba.fastjson.JSONObject;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import com.lucky.params.FinalText;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shijin.huang
 * @date 2019-08-12
 */
@Slf4j
public class TestStep {

    public static String failStep(String className, String methodName, String sendEmail) {
        String url = reRunUrl(className, methodName, sendEmail);
        log.error("重跑url:" + url);
        return url;
    }

    public static String failStep(String className, String methodName) {
        String url = reRunUrl(className, methodName, "");
        log.error("重跑URL：" + url);
        return url;
    }

    public static String successStep(String className, String methodName) {
        String url = reRunUrl(className, methodName, "");
        return url;
    }

    @Attachment(value = "单独重跑", type = "text/html")
    public static String reRunUrl(String className, String methodName, String sendEmail) {
        BaseData baseData = BaseDataUtils.getBaseData();
        String env = baseData.getEnv();
        String url = "";
        if (FinalText.ENV_TEST.equals(env)) {
            url = FinalText.JENKINS_TEST + "className=" + className + "&methodName=" + methodName + "&sendEmail=" + sendEmail;
        } else if (FinalText.ENV_PRE.equals(env)) {
            url = FinalText.JENKINS_PRE + "className=" + className + "&methodName=" + methodName + "&sendEmail=" + sendEmail;
        }
        return html(url, className, methodName);
    }

    private static String html(String url, String className, String methodName) {
        String html = "<html>\n" +
                "<head>\n" +
                "    <script language=\"javascript\">\n" +
                "        function print() {\n" +
                "            var a = myform.email.value;\n" +
                "            window.open(`" + url + "`+a,'_blank').location;\n" +
                "        }\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h4>手动运行该用例，点击运行后请等待结果发送到邮箱</h4>\n" +
                "    <h4>类名:" + className + "   方法名：" + methodName + "</h4>\n" +
                "    <form name=\"myform\">\n" +
                "       结果接收邮箱： <input type=\"text\" name=\"email\" id=\"email\" size=\"30\"/>\n" +
                "        <input type=\"button\" name=\"button\" value=\"运 行（不要重复点击）\" onclick=\"print()\" />\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        return html;
    }

    public static void step(String url, String body, String response) {
        requestStep(url, body);
        respondStep(response);
    }

    @Attachment("请求报文")
    public static String requestStep(String url, String body) {
        String str = body;
        try {
            //格式化json串
            boolean prettyFormat = true;
            JSONObject jsonObject = JSONObject.parseObject(body);
            str = JSONObject.toJSONString(jsonObject, prettyFormat);

        } catch (Exception e) {
            log.error("请求报文非json格式，解析错误");
            return url + "\n" + str;
        }

        //报告展现请求报文
        return url + "\n" + str;
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

    @Step("OTP平台用例ID:")
    public static String setCaseID(String caseId) {
        return caseId;
    }

}
