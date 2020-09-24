package otp.demo;

import com.lucky.common.utils.AssertUtils;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import org.testng.annotations.*;

public class OtpDemoTest {


    @BeforeSuite(alwaysRun = true)
    @Parameters({"env"})
    public void beforeTest(String env) {
        System.err.println("evn:" + env);
        BaseData baseData = new BaseData();
        baseData.setEnv(env);
        BaseDataUtils.setBaseData(baseData);
        System.err.println("before test......");
    }


    @Test(description = "表格的测试用例1", groups = {"1_205_766_c4674mxvp6g0","1_205_766_c4674ncx5gw0"})
    public void test1() {
        System.out.println("test1.....表格的测试用例1");
    }

    @Test(description = "脑图的测试用例2", groups = "2_205_25_6875256808567668737")
    public void test2() {
        AssertUtils.assertEquals(1,2);
        System.out.println("test2.....表格的测试用例2");
    }

    @Test(description = "脑图的测试用例3", groups = {"1_205_804_c5to0mlnqbs0","1_205_804_c5to0mywwy00","1_205_804_c5to0ncdj140"})
    public void test3() {
        System.out.println("test3.....脑图的测试用例3");
    }

    @Test(description = "脑图的测试用例4", groups = "1_205_804_c5to0r9ql6w0")
    public void test4() {
        System.out.println("test4.....脑图的测试用例4");
    }


    @AfterSuite(alwaysRun = true)
    public void afterTest() {
        System.err.println("after test .......");
    }

}
