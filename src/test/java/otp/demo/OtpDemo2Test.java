package otp.demo;

import com.lucky.common.utils.AssertUtils;
import com.lucky.common.utils.BaseDataUtils;
import com.lucky.params.BaseData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OtpDemo2Test {


    @BeforeSuite(alwaysRun = true)
    @Parameters({"env"})
    public void beforeTest2(String env) {
        System.err.println("evn:" + env);
        BaseData baseData = new BaseData();
        baseData.setEnv(env);
        BaseDataUtils.setBaseData(baseData);
        System.err.println("before test......");
    }


    @Test(description = "表格的测试用例1", groups = "2_83_29_6860729584200384543")
    public void test1() {
        System.out.println("test1.....表格的测试用例1");
    }

    @Test(description = "脑图的测试用例2", groups = "2_83_29_6860729584200384544")
    public void test2() {
        AssertUtils.assertEquals(1,2);
        System.out.println("test2.....表格的测试用例2");
    }

    @Test(description = "脑图的测试用例3", groups = "1_83_769_c4vmkbn4wyo0")
    public void test3() {
        System.out.println("test3.....脑图的测试用例3");
    }

    @Test(description = "脑图的测试用例4", groups = "1_83_769_c5ipdqgskbk0")
    public void test4() {
        System.out.println("test4.....脑图的测试用例4");
    }


    @AfterSuite(alwaysRun = true)
    public void afterTest2() {
        System.err.println("after test .......");
    }

}
