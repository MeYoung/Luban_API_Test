package otp.demo;

import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import org.omg.CORBA.BAD_CONTEXT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OtpDemoTest {


    @BeforeTest(alwaysRun = true)
    @Parameters({"env"})
    public void beforeTest(String env) {
        BaseData baseData = BaseDataUtils.getBaseData();
        baseData.setEnv(env);
        System.err.println("before test......");
        System.err.println("evn:"+env);
    }


    @Test(description = "表格的测试用例1", groups = {"6864436153801113601"})
    public void test1() {
        System.out.println("test1.....表格的测试用例1");
    }

    @Test(description = "脑图的测试用例2", groups = {"c50monwc2ds0"})
    public void test2() {
        System.out.println("test2.....表格的测试用例2");
    }

    @Test(description = "脑图的测试用例3", groups = {"c50mnyfqsm80"})
    public void test3() {
        System.out.println("test3.....表格的测试用例3");
    }

    @Test(description = "脑图的测试用例4", groups = {"c50mnyfqkoo0"})
    public void test4() {
        System.out.println("test4.....脑图的测试用例4");
    }


    @AfterClass
    public void afterTest() {
        System.err.println("after test .......f");
    }

}
