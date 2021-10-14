package otp.demo;

import com.alibaba.fastjson.JSONObject;
import otp.lucky.common.annotion.CasePriority;
import otp.lucky.common.annotion.OTP;
import otp.lucky.common.annotion.OTPDataProvider;
import otp.lucky.common.utils.BaseDataTools;
import otp.lucky.params.BaseData;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
public class BaseDataToolsTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
    }

    @OTP(caseIDs = "1_441_5313_c4wkibg6olc0,1_441_5327_c5vbkj43qeo0",priority = CasePriority.P1)
    @Test
    public void dataTest() {
        log.info("----------");
        Allure.label("adfafd","fafdadf");
        log.info("----------");
        log.info("dataTest =============");
    }


    @Test
    public void dataTest3() {
        log.info("dataTest3");
    }

    @OTP(caseIDs = "1_441_5313_c4wkyy16t1c0",priority = CasePriority.P3)
    @OTPDataProvider(dataFile = "src/test/resources/json/loginArr.json")
    @Test
    public void dataTest2(JSONObject jsonObject) throws InterruptedException {
        Thread.sleep(3000);
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("Username");
        String isvalid = jsonObject.getString("isvalid");

        log.info("密码{},{},{}", password, username, isvalid);
    }

    @OTP(caseIDs = "1_441_5313_c4wkzx3ij1c0",priority = CasePriority.P2)
    @OTPDataProvider(dataFile = "src/test/resources/json/login.json")
    @Test
    public void dataTest3333(JSONObject jsonObject) throws InterruptedException {
        Thread.sleep(2000);
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("Username");
        String isvalid = jsonObject.getString("isvalid");

        log.info("密码{},{},{}", password, username, isvalid);
    }

    @Test(dataProvider = "data")
    public void ttt(int i, int j) {
        log.info("----------");
        Allure.label("adfafd","fafdadf");
        log.info("----------");

        log.info("tttt.........{}+{}........", i, j);
    }


    @Test(threadPoolSize = 2, invocationCount = 5)
    public void test1() throws InterruptedException {
        BaseData baseData = BaseData.getInstance();
        baseData.setData("uid","uid");
        baseData.setData("baseURL",String.valueOf(Math.random()));

        BaseDataTools baseDataTools = BaseDataTools.getInstance();
        BaseDataTools baseDataTools2 = BaseDataTools.getInstance();
        Assert.assertTrue(baseDataTools == baseDataTools2);
        Thread.sleep(1000);

        BaseDataTools.getInstance().setBaseData(baseData);
        log.info("{}",baseData.getData("uid"));
        log.info("{}",baseData.getData("baseURL"));
    }

    final String sql = "select * from t_adjust_time limit 10";
    final String sqlConfigName = "db.operation";

    @OTP(caseIDs = "1_441_5320_c4vs9w3l7uw0",priority = CasePriority.P1)
    @OTPDataProvider(sqlQuery = sql, sqlConfigID = sqlConfigName)
    @Test
    public void sqlTest(JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
    }


    final String sql2 = "select * from t_adjust_time limit 2";

    @OTPDataProvider(sqlQuery = sql2, sqlConfigID = sqlConfigName)
    @Test
    public void sqlTest2(JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
    }

    @OTPDataProvider(dataFile = "src/test/resources/txt/text.txt")
    @Test
    public void textTest(String a, String b, String c, String d, String e) {
        log.info("a:{},b：{},c：{},d：{},e：{}」", a, b, c, d, e);
    }

    @OTP(caseIDs = "1_441_5320_c4vs9w3l7uw0",priority = CasePriority.P0)
    @OTPDataProvider(dataFile = "src/test/resources/excel/demo1.xlsx",sheetName = "sheet1")
    @Test
    public void excelData(JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
    }
    @OTPDataProvider(dataFile = "src/test/resources/excel/demo1.xlsx")
    @Test
    public void excelData2(JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
    }

    @BeforeSuite
    public void ttt() {
        log.info("before suite");
        BaseData baseData = BaseData.getInstance();
        baseData.setData("env","test");
    }


    @Test
    public void  tt(){
        log.info("=======ttttt====");
    }
}


