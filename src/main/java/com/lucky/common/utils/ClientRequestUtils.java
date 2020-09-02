package com.lucky.common.utils;//package com.lucky.common.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.lucky.common.report.TestStep;
//import com.lucky.params.BaseData;
//import com.lucky.params.FinalText;
//import com.lucky.service.admin.operation.LoginService;
//import io.qameta.allure.Attachment;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.SqlSession;
//import org.testng.Assert;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
//import tk.mybatis.mapper.mapperhelper.MapperHelper;
//
//import java.io.File;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//
///**
// * @author shijin.huang
// * @date 2019-09-09
// */
//@Slf4j
//public class ClientRequestUtils {
//
//    public BaseData baseData = new BaseData();
//
////    @Parameters({"env", "platform", "capiUserName"})
//    @BeforeSuite
////    public void initializationData(String env, String platform, String capiUserName) {
////    public void initializationData(String env, String platform, String capiUserName, String appversionCapi) {
//     public void initializationData(){
//        String env = "test";
//        String platform = "android";
//        String capiUserName = "13512341234";
//        String appversionCapi = "2820";
//        EnvReaderUtils envReaderUtils = new EnvReaderUtils(env + ".properties");
//        baseData.setEnv(env);
//        baseData.setPlatform(platform);
//        System.out.println("=================================================================================================");
//        log.info("连接数据库。。。。。。");
//        System.out.println("=================================================================================================");
//        dbConnection(envReaderUtils);
//        System.out.println("=================================================================================================");
//        log.info("数据库连接完成！！！！！！");
//        System.out.println("=================================================================================================");
//
//        log.info("Admin 登录 。。。。。。");
//        System.out.println("=================================================================================================");
//        String adminUserName = envReaderUtils.getValue("admin.login.userName");
//        String adminPassword = envReaderUtils.getValue("admin.login.password");
//        String adminLoginBaseUrl = envReaderUtils.getValue("admin.login.url.base");
////        必须放于CLogin之前，因为cLogin获取验证码 需要用到cookies
//        Map<String, String> cookies = adminlogin(adminLoginBaseUrl, adminUserName, adminPassword);
//        log.info("Admin web cookies" + cookies);
//        baseData.setCookies(cookies);
//        System.out.println("=================================================================================================");
//        log.info("Admin 登录完成！！！！！！");
//        System.out.println("=================================================================================================");
//        baseData.setUserNameCapi(capiUserName);
//    }
//
//    /**
//     * 数据库连接
//     *
//     * @param envReaderUtils 环境相关配置
//     */
//    private void dbConnection(EnvReaderUtils envReaderUtils) {
//        String dbOperation = envReaderUtils.getValue("db.operation");
//        String dbEhr = envReaderUtils.getValue("db.ehr");
////        String dbDispatch = envReaderUtils.getValue("db.dispatch");
////        String dbDispatchRouter = envReaderUtils.getValue("db.dispatchrouter");
//
//        //        数据链接
//        SqlSession sessionOperation = SQLExecuteUtils.run(dbOperation);
//        SqlSession sessionEhr = SQLExecuteUtils.run(dbEhr);
////        SqlSession sessionDispatch = SQLExecuteUtils.run(dbDispatch);
////        SqlSession sessionDispatchRouter = SQLExecuteUtils.run(dbDispatchRouter);
//
//        //  创建一个MapperHelper 注意每个库都需要创建
//        MapperHelper mapperHelper = new MapperHelper();
//        mapperHelper.processConfiguration(sessionOperation.getConfiguration());
//        mapperHelper.processConfiguration(sessionEhr.getConfiguration());
////        mapperHelper.processConfiguration(sessionDispatch.getConfiguration());
////        mapperHelper.processConfiguration(sessionDispatchRouter.getConfiguration());
//
//
//        if (!FinalText.ENV_PRE.equals(baseData.getEnv())) {
//            String dbOrderAll = envReaderUtils.getValue("db.order_all");
//            SqlSession sessionOrderAll = SQLExecuteUtils.run(dbOrderAll);
//            mapperHelper.processConfiguration(sessionOrderAll.getConfiguration());
//            baseData.setSessionOrderAll(sessionOrderAll);
//        }
//
//
//        //        设置 baseData
//        baseData.setSessionOperation(sessionOperation);
//        baseData.setSessionEhr(sessionEhr);
////        baseData.setSessionDispatch(sessionDispatch);
////        baseData.setSessionDispatchRouter(sessionDispatchRouter);
//
//    }
//
//
//    @Attachment("关闭 数据库等 链接")
//    @AfterSuite
//    public void closed() {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        if (baseData.getSessionOperation() != null) {
//            baseData.getSessionOperation().close();
//        }
//
//        if (baseData.getSessionDispatch() != null) {
//            baseData.getSessionDispatch().close();
//        }
//
//        if (baseData.getSessionEhr() != null) {
//            baseData.getSessionEhr().close();
//        }
//
//
//        if (baseData.getSessionDispatchRouter() != null) {
//            baseData.getSessionDispatchRouter().close();
//        }
//
//
//        if (baseData.getSessionOrderAll() != null) {
//            baseData.getSessionOrderAll().close();
//        }
//
//
//        System.out.println("=================================================================================================");
//        log.info("关闭资源完成！！！！！！");
//        System.out.println("=================================================================================================");
//    }
//
//
//    /**
//     * admin login
//     *
//     * @param adminloginBaseUrl baseUrl
//     * @param adminUserName     登录账号
//     * @param adminPassword     登录密码
//     * @return 登录的cookies
//     */
//    private Map<String, String> adminlogin(String adminloginBaseUrl, String adminUserName, String adminPassword) {
//        //      Admin 登录 获取cookies
//        return LoginService.login(adminloginBaseUrl, adminUserName, adminPassword);
//    }
//
//
//    /**
//     * API Get 请求
//     *
//     * @param apiPath api路径。
//     * @param qStr    q参数
//     * @return response body
//     */
//    public String get(String apiPath, String qStr) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String secKey = baseData.getSecKey();
////        q 加密
//        String q = AesToolsUtils.encrypt(qStr, secKey);
//        String baseURL = baseData.getBaseURL();
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        log.info("请求q参数：" + qStr);
////        生成sign
//        String sign = SignUtils.getSignStr(uid, cid, q, secKey);
//
//        Response response = given()
//                .param("cid", cid)
//                .param("uid", uid)
//                .param("sign", sign)
//                .param("q", q)
//                .get(url);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("API Get Response:" + body);
//        new JsonPath(body).prettyPrint();
//        TestStep.step(url, qStr, body);
//        return body;
//    }
//
//
//    /**
//     * API Get 请求
//     *
//     * @param apiPath api路径。
//     * @param object  请求q对象
//     * @return reponse body
//     */
//    public String get(String apiPath, Object object) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String secKey = baseData.getSecKey();
//        String baseURL = baseData.getBaseURL();
//        String qStr = JSON.toJSONString(object);
////        q 加密
//        String q = AesToolsUtils.encrypt(qStr, secKey);
////        生成sign
//        String sign = SignUtils.getSignStr(uid, cid, q, secKey);
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        log.info("请求q参数：" + qStr);
//        Response response = given()
//                .param("cid", cid)
//                .param("uid", uid)
//                .param("sign", sign)
//                .param("q", q)
//                .get(url);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("API Get Response:" + body);
//        new JsonPath(body).prettyPrint();
//        TestStep.step(url, qStr, body);
//        return body;
//    }
//
//    /**
//     * API Get 请求
//     *
//     * @param apiPath API路径
//     * @return reponse body
//     */
//    public String get(String apiPath) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String secKey = baseData.getSecKey();
//        String baseURL = baseData.getBaseURL();
////        加密q
//        String q = AesToolsUtils.encrypt("{}", secKey);
////        生成 sign
//        String sign = SignUtils.getSignStr(uid, cid, q, secKey);
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        Response response = given()
//                .param("cid", cid)
//                .param("uid", uid)
//                .param("sign", sign)
//                .param("q", q)
//                .get(baseURL + apiPath);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("DAPI Get Response:" + body);
//        new JsonPath(body).prettyPrint();
//        TestStep.step(url, "{}", body);
//        return body;
//    }
//
//    /**
//     * API Post 请求
//     *
//     * @param apiPath API路径
//     * @param qStr    请求q字符串
//     * @return response body
//     */
//    public String post(String apiPath, String qStr) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String secKey = baseData.getSecKey();
//        String baseURL = baseData.getBaseURL();
//        //        加密q
//        String qAes = AesToolsUtils.encrypt(qStr, secKey);
////        生成 sign
//        String sign = SignUtils.getSignStr(uid, cid, qAes, secKey);
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        log.info("请求q参数：" + qStr);
//        Response response = given()
//                .param("cid", cid)
//                .param("uid", uid)
//                .param("sign", sign)
//                .param("q", qAes)
//                .post(url);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("API Post Response:" + body);
//        new JsonPath(body).prettyPrint();
//        TestStep.step(url, qStr, body);
//        return body;
//    }
//
//    /**
//     * API Post 请求
//     *
//     * @param apiPath API路径
//     * @param object  请求q对象
//     * @return response body
//     */
//    public String post(String apiPath, Object object) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String secKey = baseData.getSecKey();
//        String baseURL = baseData.getBaseURL();
//        String qStr = JSON.toJSONString(object);
////        q 加密
//        String q = AesToolsUtils.encrypt(qStr, secKey);
////        生成sign
//        String sign = SignUtils.getSignStr(uid, cid, q, secKey);
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        log.info("请求q参数：" + qStr);
//        Response response = given()
//                .param("cid", cid)
//                .param("uid", uid)
//                .param("sign", sign)
//                .param("q", q)
//                .post(url);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("API Post Response:" + body);
//        new JsonPath(body).prettyPrint();
//        TestStep.step(url, qStr, body);
//        return body;
//    }
//
//    /**
//     * 文件上传，必须把文件放在test/resources下，并传入路径
//     *
//     * @param apiPath     api路径
//     * @param object      q 对象
//     * @param controlName 上传字段名
//     * @param mimiType    上传类型 如图片的image/jpg
//     * @param filePath    相对 test/resources 的路径
//     * @return response
//     */
//    public String post(String apiPath, Object object, String controlName, String mimiType, String filePath) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String baseURL = baseData.getBaseURL();
//        String qStr = JSON.toJSONString(object);
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        log.info("请求q参数：" + qStr);
//        String secKey = baseData.getSecKey();
//        //        加密q
//        String qAes = AesToolsUtils.encrypt(qStr, secKey);
////        生成 sign
//        String sign = SignUtils.getSignStr(uid, cid, qAes, secKey);
//        // Given
//        String path = System.getProperty("user.dir");
//        Response response = given()
//                .contentType("multipart/form-data")
//                .multiPart(controlName, new File(path + "/src/test/resources" + filePath), mimiType)
//                .queryParam("cid", cid)
//                .queryParam("uid", uid)
//                .queryParam("sign", sign)
//                .queryParam("q", qAes)
//                .post(url);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("API Post Response:" + body);
//        TestStep.step(url, qStr, body);
//        new JsonPath(body).prettyPrint();
//        return body;
//    }
//
//
//    /**
//     * 文件上传，必须把文件放在test/resources下，并传入路径
//     *
//     * @param apiPath      api路径
//     * @param object       q 对象
//     * @param controlName1 上传字段名
//     * @param mimiType1    上传类型 如图片的image/jpg
//     * @param filePath1    相对 test/resources 的路径
//     * @return response
//     */
//    public String post(String apiPath, Object object, String controlName1, String mimiType1, String filePath1,
//                       String controlName2, String mimiType2, String filePath2) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String uid = baseData.getUid();
//        String cid = baseData.getCid();
//        String baseURL = baseData.getBaseURL();
//        String qStr = JSON.toJSONString(object);
//        String url = baseURL + apiPath;
//        log.info("请求URL：" + url);
//        log.info("请求q参数：" + qStr);
//        String secKey = baseData.getSecKey();
//        //        加密q
//        String qAes = AesToolsUtils.encrypt(qStr, secKey);
////        生成 sign
//        String sign = SignUtils.getSignStr(uid, cid, qAes, secKey);
//        // Given
//        String path = System.getProperty("user.dir");
//        Response response = given()
//                .contentType("multipart/form-data")
//                .multiPart(controlName1, new File(path + "/src/test/resources" + filePath1), mimiType1)
//                .multiPart(controlName2, new File(path + "/src/test/resources" + filePath2), mimiType2)
//                .queryParam("cid", cid)
//                .queryParam("uid", uid)
//                .queryParam("sign", sign)
//                .queryParam("q", qAes)
//                .post(url);
//        log.info("请求状态码：" + response.getStatusCode());
//        String bodyAes = response.getBody().asString();
////        解密
//        String body = AesToolsUtils.decrypt(bodyAes, secKey);
//        log.info("API Post Response:" + body);
//        TestStep.step(url, qStr, body);
//        new JsonPath(body).prettyPrint();
//        return body;
//    }
//
//
//    /**
//     * admin配送系统post
//     *
//     * @param apiPath 请求路径
//     * @param params  请求参数
//     * @return response
//     */
//    public String adminPost(String apiPath, Map<String, Object> params) {
//        BaseData baseData = BaseDataUtils.getBaseData();
//        String baseURL = baseData.getBaseDispatchRouterUrl();
//        Map<String, String> loginCookies = baseData.getCookies();
//        String url = baseURL + apiPath;
//        Response response = given()
//                .contentType("application/x-www-form-urlencoded;charset=utf-8")
//                .cookies(loginCookies)
//                .params(params)
//                .post(url);
//        log.info("Request URL:" + url);
//        log.info("Request params: " + params);
//        String body = response.getBody().asString();
//        log.info("Admin Post Response：" + body);
////        response.jsonPath().prettyPrint();
//        TestStep.step(url, JSONObject.toJSONString(params), body);
//        return body;
//    }
//
//
//    /**
//     * Assert : api response 通用值校验
//     *
//     * @param response String
//     */
//    public void assertSuccess(String response) {
//        JsonPath jsonPath = new JsonPath(response);
//        assertSuccess(jsonPath);
//    }
//
//
//    /**
//     * API 通用校验
//     *
//     * @param jsonPath JsonPath
//     */
//    @Attachment("校验通用返回是否成功")
//    public void assertSuccess(JsonPath jsonPath) {
//        Assert.assertEquals(jsonPath.getString("status"), "SUCCESS", "验证接口调用成功");
//        Assert.assertEquals(jsonPath.getInt("code"), 1);
//        Assert.assertEquals(jsonPath.getString("msg"), "成功");
//    }
//
//
//}
