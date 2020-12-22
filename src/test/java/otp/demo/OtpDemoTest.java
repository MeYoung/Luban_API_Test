package otp.demo;

import com.lucky.common.utils.AssertUtils;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import org.testng.annotations.*;

public class OtpDemoTest {


    @BeforeSuite(alwaysRun = true)
    @Parameters({"env"})
    public void beforeTest2(String env) {
        System.err.println("evn:" + env);
        BaseData baseData = new BaseData();
        baseData.setEnv(env);
        BaseDataUtils.setBaseData(baseData);
        System.err.println("before test......");
    }


    @Test(description = "表格的测试用例1", groups = "1_441_21672_c7t89zf3xxk0")
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("test1.....表格的测试用例1");
    }

    @Test(description = "脑图的测试用例2", groups = {"2_83_29_6860729584200384544", "fadsfasf"})
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        AssertUtils.assertEquals(1, 2);
        System.out.println("test2.....表格的测试用例2");
    }

    @Test(description = "脑图的测试用例3-TEST", groups = {"1_205_932_c7z38ufv5140"})
    public void test3() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("test3.....脑图的测试用例3");
    }

    @Test(description = "脑图的测试用例4-TEST", groups = "1_205_932_c7z38t4luao0")
    public void test4() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("test4.....脑图的测试用例4");
    }


    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"X", "pwd1"},
                {"n2", "p2"},
                {"n3", "p3"}
        };
    }

    @Test(dataProvider = "loginData", dependsOnGroups = "脑图的测试用例5-TEST", groups = {"1_205_932_c7z38ra89i80"})
    public void tlogin(String userName, String pwd) {
        System.out.println("userName:" + userName + ",PassWord:" + pwd);
    }


    @AfterSuite(alwaysRun = true)
    public void afterTest2() {
        System.err.println("after test .......");
    }

}
