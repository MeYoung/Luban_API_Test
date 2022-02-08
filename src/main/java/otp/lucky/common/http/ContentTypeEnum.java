package otp.lucky.common.http;

/**
 * @Author shijin.huang
 * @Date 2021/10/20
 * <p>
 * HTTP 请求头Content-Type类型
 */
public enum ContentTypeEnum {
    JSON("application/json;charset=UTF-8"),

    APP_XML("application/xml"),

    TEXT_XML("text/xml"),

    FROM_URLENCODED("application/x-www-form-urlencoded;charset=UTF-8"),

    //    上传
    MULTIPART_FORM_DTA("multipart/form-data");


    private final String value;

    ContentTypeEnum(final String v) {
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
