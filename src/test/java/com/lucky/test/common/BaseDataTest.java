package com.lucky.test.common;

import com.lucky.common.utils.ToolsUtils;
import com.lucky.params.BaseData;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @Author shijin.huang
 * @Date 2021/10/12
 */
public class BaseDataTest {

    @Test(threadPoolSize = 5,invocationCount = 10)
    public void baseDataTest() {
        ToolsUtils.sleep(2);
        BaseData baseData = BaseData.getBaseData();
        BaseData baseData2 = BaseData.getBaseData();
        Assert.assertSame(baseData, baseData2);
    }

    @Test(threadPoolSize = 5,invocationCount = 10)
    public void baseDataTest2() {
        ToolsUtils.sleep(2);
        BaseData baseData = BaseData.getBaseDataStaticClass();
        BaseData baseData2 = BaseData.getBaseDataStaticClass();
        Assert.assertSame(baseData, baseData2);
    }
}
