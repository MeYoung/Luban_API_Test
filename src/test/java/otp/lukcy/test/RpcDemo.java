package otp.lukcy.test;

import com.alibaba.fastjson.JSON;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.RedirectConfig.redirectConfig;

/**
 * @Author shijin.huang
 * @Date 2021/10/12
 */
@Slf4j
public class RpcDemo {



    @Test
    public void tt() {
        String login = "https://bsportal.luckincoffee.com/webapi/auth/login";
        String body = "{\n" +
                "    \"username\": \"shijin.huang\",\n" +
                "    \"password\": \"Hshijin1237.\",\n" +
                "    \"appKey\": \"\",\n" +
                "    \"callback\": \"\",\n" +
                "    \"rtnUrl\": \"https%3A%2F%2Fbsportal.luckincoffee.com\"\n" +
                "}";
        log.info(JSON.toJSONString(body));
        Response response2 = given().contentType("application/json").body(body).post(login);
        log.info(response2.getBody().prettyPrint());

        Map<String, String> cookies = response2.getCookies();
        log.info("headers,===== {}",response2.getHeaders());

        String ge="http://otp.luckincoffee.com/api/workbench/task?_=1634115130308";
        String body2 ="{\n" +
                "    \"planType\": [],\n" +
                "    \"belongUser\": [],\n" +
                "    \"startTime\": \"2021-09-13\",\n" +
                "    \"endTime\": \"2021-10-13\"\n" +
                "}";
        Response response3 = given().cookies(cookies).header("x-csrf-token","snLvcRITNeLIZzUCXqS6tlj4").contentType("application/json").body(body2).post(ge);
        log.info("response3:{}",response3.getBody().prettyPrint());

        RestAssured.config = config().redirect(redirectConfig().followRedirects(false).and().maxRedirects(20));

        String url = "https://bsportal.luckincoffee.com/webapi/project/visit?id=230&envId=8513";
        Response response = given().cookies(cookies)
                .get(url);
        log.info("status:{}",response.getStatusCode());
        log.info("headers:{}", response.getHeaders().get("Location"));
        Map<String,String> cookies2 = response.getCookies();
        Header header =  response.getHeaders().get("Location");

      Response response1 =   given().cookies(cookies2).get(header.getValue());
      
      response1.getBody().prettyPrint();
    }
}
