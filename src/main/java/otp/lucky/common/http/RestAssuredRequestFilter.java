package otp.lucky.common.http;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author shijin.huang
 * @Date 2022/02/08
 */
@Slf4j
public class RestAssuredRequestFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {

        Response response = ctx.next(requestSpec, responseSpec);
        String method = requestSpec.getMethod();

        log.info("请求方法:{}", method);

        log.info("请求地址：{}", requestSpec.getURI());

        log.info("请求头部信息:\n{}", requestSpec.getHeaders().toString());
            // todo post打印体


        log.info("返回状态码:{} {}", response.getStatusCode(), response.getStatusLine());
        log.info("返回体:");
        response.prettyPrint();
        return response;
    }
}
