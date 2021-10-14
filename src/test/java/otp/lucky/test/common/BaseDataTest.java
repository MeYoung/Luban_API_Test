package otp.lucky.test.common;

import org.testng.Assert;
import otp.lucky.common.utils.ToolsUtils;
import otp.lucky.params.BaseData;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @Author shijin.huang
 * @Date 2021/10/12
 */
@Slf4j
public class BaseDataTest {

    @Test(threadPoolSize = 5, invocationCount = 10)
    public void baseDataTest() {
        ToolsUtils.sleep(2);
        BaseData baseData = BaseData.getInstance();
        BaseData baseData2 = BaseData.getInstance();
        Assert.assertSame(baseData, baseData2);
    }

    @Test(threadPoolSize = 5, invocationCount = 10)
    public void baseDataTest2() {
        ToolsUtils.sleep(2);
        BaseData baseData = BaseData.getInstanceStaticClass();
        BaseData baseData2 = BaseData.getInstanceStaticClass();
        Assert.assertSame(baseData, baseData2);
    }



}
