package otp.api;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import otp.lucky.common.http.ContentTypeEnum;
import otp.lucky.common.http.Get;
import otp.lucky.common.http.GlobalCookieManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author shijin.huang
 * @Date 2021/10/21
 */
@Slf4j
public class APITest {


    @Test
    public void tt21(){
        String a="feature-20211207-21.11.2.1-xray+12312fasdf123123+sources.jar";

            String[] arr =a.split("\\+");

        for (int i = 0; i < arr.length ; i++) {
            log.info(arr[i]);
        }

    }


    @Test
    public void t3(){
        Map map = new HashMap();
        map.put("adf","fd123123123123");
        GlobalCookieManager.getInstance().setCookies(map);
        Map<String, Object> pa = new HashMap<>();
        pa.put("sfasfasf",123);
        pa.put("aaa",true);
        pa.put("ccccc","stringggggg");
        String body  = Get.get("https://www.baidu.com", ContentTypeEnum.FROM_URLENCODED.value(),pa).getBody().toString();
//        log.info(body);
    }

    @Test
    public void test1() {
        //链式构建请求

/*        String url="";

        String result2 = HttpRequest.post(url)
                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        Console.log(result2);*/
    }


    @Test
    public void tt() {

        String str = "AaABbBcBbcvQv…\\”->\\“bc";
        char[] c = str.toCharArray();
/*        if (c.length <= 2)
            System.out.println(c);*/
        int j = -1;
        for (int i = 0; i < str.length() - 2; i++) {
            if (c[i] == c[i + 2] && c[i] != c[i + 1]) {
                j = i + 2;
                i++;
                System.out.println(c[i]);
            } else if (i != j) {
                System.out.print(c[i]);
            }
        }
    }

    @Test
    public void tttt() {
        int count =0;
        for (int i = 1 ;i <= 12; i++) {
           count +=  tt2(i);
        }
        log.info("{}",count);

    }

    public int tt2(int i) {

            if (i == 1 || i == 2)
                 return  1;
            else
                 return  tt2(i-1) + tt2(i-2);

    }
}
