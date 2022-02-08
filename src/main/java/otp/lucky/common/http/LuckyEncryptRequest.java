package otp.lucky.common.http;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
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
public class LuckyEncryptRequest {

    public static String post(String apiurl, String uid, String cid, String q, String secKey) {
        //        加密q
        String qAes = AESCryptorUtil.encrypt(q, secKey);
        //        生成 sign
        String sign = SignUtil.getSignStr(uid, cid, qAes, secKey);
        log.info("请求URL：" + apiurl);
        log.info("请求q参数：" + q);
        Map<String, Object> params = new HashMap<>();
        params.put("cid",cid);
//       String uid =  BaseData.getInstance().getData().get("uid");
        params.put("uid",cid);
        params.put("sign",sign);
        params.put("q",qAes);

       Response response =  Post.postFrom(apiurl,params);

        log.info("请求状态码：" + response.getStatusCode());
        String bodyAes = response.getBody().asString();
//        解密
        String body = AESCryptorUtil.decrypt(bodyAes, secKey);
        log.info("API Post Response:" + body);
        new JsonPath(body).prettyPrint();
        return body;
    }
}
