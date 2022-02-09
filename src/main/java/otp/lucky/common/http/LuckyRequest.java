package otp.lucky.common.http;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import otp.lucky.common.report.TestStep;
import otp.lucky.common.utils.AESCryptorUtil;
import otp.lucky.common.utils.SignUtil;
import otp.lucky.params.BaseData;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Author shijin.huang
 * @Date 2022/01/25
 */
@Slf4j
public class LuckyRequest {

    public static String post(String apiurl, String cid, String q, String secKey) {
        String uid = BaseData.getInstance().getData().get("uid").toString();
        //        加密q
        String qAes = AESCryptorUtil.encrypt(q, secKey);
        //        生成 sign
        String sign = SignUtil.getSignStr(uid, cid, qAes, secKey);
        log.info("请求URL：{}", apiurl);
        log.info("请求q参数：{}", q);
        Map<String, Object> params = new HashMap<>(4);
        params.put("cid", cid);
        params.put("uid", cid);
        params.put("sign", sign);
        params.put("q", qAes);
        Response response = given()
                .contentType(ContentTypeEnum.FROM_URLENCODED.value())
                .params(params)
                .post(apiurl);
        log.info("请求状态码：" + response.getStatusCode());
        String bodyAes = response.getBody().asString();
//        解密
        String body = AESCryptorUtil.decrypt(bodyAes, secKey);
        log.info("API Post Response:");
        new JsonPath(body).prettyPrint();
        TestStep.step(apiurl, q, body);
        return body;
    }
}
