package otp.lucky.common.http;

/**
 * @Author shijin.huang
 * @Date 2021/10/20
 * <p>
 * http 请求方法类型
 */
public enum HttpMethodTypeEnum {

    HEAD("HEAD"),
    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE"),
    PATCH("PATCH"),
    OPTIONS("OPTIONS");

    
    private final String value;

    HttpMethodTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }
}
