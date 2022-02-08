package otp.lucky.common.http;

import io.restassured.http.Cookies;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shijin.huang
 * @Date 2021/10/21
 * <p>
 * 全局 Cookies 存储
 */
public class GlobalCookieManager extends Cookies {

    private GlobalCookieManager() {
    }

    private static volatile GlobalCookieManager globalCookieManager;

    public static GlobalCookieManager getInstance() {
        if (globalCookieManager == null) {
            synchronized (GlobalCookieManager.class) {
                if (globalCookieManager == null) {
                    globalCookieManager = new GlobalCookieManager();
                }
            }
        }
        return globalCookieManager;
    }


    @Setter
    @Getter
    private Map<String, String> cookies = new HashMap<>();


}
