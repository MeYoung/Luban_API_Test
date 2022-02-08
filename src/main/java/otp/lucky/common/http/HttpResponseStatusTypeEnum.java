package otp.lucky.common.http;

/**
 * @Author shijin.huang
 * @Date 2021/10/20
 */
public enum HttpResponseStatusTypeEnum {
    OK_200(200, "OK"),
    CREATED_201(201, "Created"),
    ACCEPTED_202(202, "Accepted"),
    NO_CONTENT_204(204, "No Content"),
    NOT_MODIFIED_304(304, "Not Modified"),
    BAD_REQUEST_400(400, "Bad Request"),
    UNAUTHORIZED_401(401, "Unauthorized"),
    FORBIDDEN_403(403, "Forbidden"),
    NOT_FOUND_404(404, "Not Found"),
    CONFLICT_409(409, "Conflict"),
    UNSUPPORTED_MEDIA_TYPE_415(415, "Unsupported Media Type"),
    EXPECTATION_FAILED_417(417, "Expectation Failed"),
    UNPROCESSABLE_ENTITY_422(422, "Unprocessable Entity");

    private int code;
    private String message;

    HttpResponseStatusTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
