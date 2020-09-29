package otp.demo;

import com.lucky.common.utils.AssertUtils;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OtpDemoTest3 {


    @BeforeSuite(alwaysRun = true)
    @Parameters({"env"})
    public void beforeTest(String env) {
        System.err.println("evn:" + env);
        BaseData baseData = new BaseData();
        baseData.setEnv(env);
        BaseDataUtils.setBaseData(baseData);
        System.err.println("before test......");
    }


    @Test(description = "表格的测试用例1", groups = {"tttttt","1_205_809_c5yu2wj23680","1_205_809_c5yu2zjwz9c0","123","456"})
    public void test1() throws InterruptedException {
        System.out.println("test1.....表格的测试用例1");
        Thread.sleep(2000);
    }

    @Test(description = "脑图的测试用例2", groups = "1_205_809_c5yu2v9rfbs0")
    public void test2() throws InterruptedException {
        AssertUtils.assertEquals(1,2);
        System.out.println("test2.....表格的测试用例2");
        Thread.sleep(2000);

    }

    @Test(description = "脑图的测试用例3", groups = {"2_205_37_6877441667023241218","ttt11123123ttt","1_205_804_c5to0mywwy00","1_205_804_c5to0ncdj140"})
    public void test3() throws InterruptedException {
        System.out.println("test3.....脑图的测试用例3");
        Thread.sleep(2000);

    }

    @Test(description = "脑图的测试用例4", groups = "2_205_37_6877441667023241217")
    public void test4() throws InterruptedException {
        System.out.println("test4.....脑图的测试用例4");
        Thread.sleep(2000);
    }


    @AfterSuite(alwaysRun = true)
    public void afterTest() {
        System.err.println("after test .......");
    }

}
