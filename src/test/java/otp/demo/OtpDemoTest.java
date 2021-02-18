package otp.demo;

import com.lucky.common.utils.AssertUtils;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@Slf4j
public class OtpDemoTest {


    @BeforeSuite(alwaysRun = true)
    @Parameters({"env", "capiUserName", "capiPWD"})
    public void beforeTest2(String env, String capiUserName, String capiPWD) {
        log.info(env);
        log.info("=======================");
        log.info(capiUserName);
        log.info(capiPWD);
        log.info("=======================");
        BaseData baseData = new BaseData();
        baseData.setEnv(env);
        BaseDataUtils.setBaseData(baseData);
        log.info("before test......");
    }


    @Test(description = "表格的测试用例1", groups = "1_205_766_c6bj1xjkhc00")
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        log.info("test1.....表格的测试用例1-1_441_21672_c7t89zf3xxk0");
    }

    @Test(description = "脑图的测试用例2", groups = {"2_83_29_6860729584200384544", "1_205_766_c6bj1xjkhq00"})
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        AssertUtils.assertEquals(1, 2);
        log.info("脑图的测试用例2-2_83_29_6860729584200384544");
    }

    @Test(description = "脑图的测试用例3-TEST", groups = {"1_205_766_c6bj1xjkg3c0"})
    public void test3() throws InterruptedException {
        Thread.sleep(3000);

        log.info("test3.....脑图的测试用例3-1_205_932_c7z38ufv5140");
    }

    @Test(description = "脑图的测试用例4-TEST", groups = "1_205_932_c7z38t4luao0")
    public void test4() throws InterruptedException {
        Thread.sleep(4000);
        log.info("test4.....脑图的测试用例4-1_205_932_c7z38t4luao0");
    }


    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"X", "pwd1"},
                {"n2", "p2"},
                {"n3", "p3"}
        };
    }

    @Test(dataProvider = "loginData", description = "脑图的测试用例5-TEST", groups = {"1_205_932_c7z38ra89i80"})
    public void tlogin(String userName, String pwd) {
        log.info("userName:" + userName + ",PassWord:" + pwd);
    }


    @AfterSuite(alwaysRun = true)
    public void afterTest2() {
        log.error("after test .......");
    }

}
