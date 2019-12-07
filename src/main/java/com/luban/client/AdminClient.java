package com.luban.client;

import com.alibaba.fastjson.JSON;
import com.luban.common.utils.BaseDataUtils;
import com.luban.common.utils.EnvReaderUtils;
import com.luban.common.utils.RequestUtils;
import com.luban.common.utils.SQLExecuteUtils;
import com.luban.params.BaseData;
import com.luban.service.admin.LoginService;
import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author shijin.huang
 * @date 2019-09-09  所有admin项目都继承于此
 */
@Slf4j
public class AdminClient {


    @Parameters({"env", "userName", "password"})
    @BeforeSuite
    public void initializationData(String env, String userName, String password) {
        BaseData baseData = new BaseData();

        EnvReaderUtils envReaderUtils = new EnvReaderUtils(env + ".properties");
//        获取环境相关配置
        baseData.setEnv(env);
        System.out.println("=================================================================================================");
        log.info("连接数据库。。。。。。");
        System.out.println("=================================================================================================");
        dbConnetion(envReaderUtils, baseData);
        System.out.println("=================================================================================================");
        log.info("数据库连接完成！！！！！！");
        System.out.println("=================================================================================================");
        log.info("Admin 登录 。。。。。。");
        System.out.println("=================================================================================================");
        String adminloginBaseUrl = envReaderUtils.getValue("admin.url.base");
//        往baseData保存服务地址，便于全局使用
        baseData.setBaseURL(adminloginBaseUrl);
//        必须放于Clogin之前，因为cLogin获取验证码 需要用到cookies
        Map<String, String> cookies = adminlogin(adminloginBaseUrl, userName, password);
        log.info("Admin web cookies" + cookies);
//        basedata 写入所有cookies
        baseData.setCookies(cookies);
        System.out.println("=================================================================================================");
        log.info("Admin 登录完成！！！！！！");
        System.out.println("=================================================================================================");

//        放初始化数据最后，存放baseData 对象，并使用单例模式，使之并发下不会重新初始化baseData
        BaseDataUtils.setBaseData(baseData);
    }

    /**
     * 数据库连接
     *
     * @param envReaderUtils
     */
    private void dbConnetion(EnvReaderUtils envReaderUtils, BaseData baseData) {
        String dbOperation = envReaderUtils.getValue("db.operation");
        //  数据链接
        SqlSession sessionOperation = SQLExecuteUtils.run(dbOperation);
        //  创建一个MapperHelper 注意每个库都需要创建
        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.processConfiguration(sessionOperation.getConfiguration());
        //  设置 baseData
        baseData.setSessionOperation(sessionOperation);

    }


    @Attachment("关闭 数据库等 链接")
    @AfterSuite
    public void closed() {
        BaseData baseData = BaseDataUtils.getBaseData();
        if (baseData.getSessionOperation() != null) {
            baseData.getSessionOperation().close();
        }
        System.out.println("=================================================================================================");
        log.info("关闭资源完成！！！！！！");
        System.out.println("=================================================================================================");
    }


    /**
     * admin login
     *
     * @param adminloginBaseUrl baseUrl
     * @param adminUserName     登录账号
     * @param adminPassword     登录密码
     * @return 登录的cookies
     */
    public Map<String, String> adminlogin(String adminloginBaseUrl, String adminUserName, String adminPassword) {
        //      Admin 登录 获取cookies
        return LoginService.login(adminloginBaseUrl, adminUserName, adminPassword);
    }

//    以下我随便封装几个get post请求，根据自己业务特点做封装


    public String get(String apiPath, Map<String, Object> mapParams) {
        BaseData baseData = BaseDataUtils.getBaseData();
        //        从basedata 获取服务地址
        String baseURL = baseData.getBaseURL();
        Map<String, String> cookies = baseData.getCookies();
        String url = baseURL + apiPath;
        Response response = RequestUtils.get(url, null, cookies, null, mapParams);
        return response.getBody().asString();
    }

    /**
     * API Post 请求
     *
     * @param apiPath API路径
     * @param object  请求q字符串
     * @return reponse body
     */
    public String post(String apiPath, Object object) {
        BaseData baseData = BaseDataUtils.getBaseData();
//        从basedata 获取服务地址
        String baseURL = baseData.getBaseURL();
        Map<String, String> cookies = baseData.getCookies();
        String url = baseURL + apiPath;
        String params = JSON.toJSONString(object);
        Response response = RequestUtils.post(url, null, cookies, null, params);
        return response.getBody().asString();
    }


    /**
     * Assert : api response 通用值校验
     *
     * @param reponse String
     */
    public void assertSuccess(String reponse) {
        JsonPath jsonPath = new JsonPath(reponse);
        assertSuccess(jsonPath);
    }


    /**
     * API 通用校验
     *
     * @param jsonPath JsonPath
     */
    @Attachment("校验通用返回是否成功")
    public void assertSuccess(JsonPath jsonPath) {
        Assert.assertEquals(jsonPath.getString("status"), "SUCCESS");
        Assert.assertEquals(jsonPath.getInt("code"), 1);
        Assert.assertEquals(jsonPath.getString("msg"), "成功");
    }


}
