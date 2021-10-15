package otp.lucky.test.common;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import otp.lucky.common.utils.ToolsUtil;
import otp.lucky.params.BaseData;

/**
 * @Author shijin.huang
 * @Date 2021/10/12
 */
@Slf4j
public class BaseDataTest {

    @Test(threadPoolSize = 5, invocationCount = 10)
    public void baseDataTest() {
        ToolsUtil.sleep(2);
        BaseData baseData = BaseData.getInstance();
        BaseData baseData2 = BaseData.getInstance();
        Assert.assertSame(baseData, baseData2);
    }

    @Test(threadPoolSize = 5, invocationCount = 10)
    public void baseDataTest2() {
        ToolsUtil.sleep(2);
        BaseData baseData = BaseData.getInstanceStaticClass();
        BaseData baseData2 = BaseData.getInstanceStaticClass();
        Assert.assertSame(baseData, baseData2);
    }

    @Test
    public void testGet(){
//        BaseData.getInstance().setEnv("123");
        BaseData.getInstance().setEnv("test03");
    }




}
