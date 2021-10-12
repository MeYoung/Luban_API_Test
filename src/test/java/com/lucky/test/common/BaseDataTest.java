package com.lucky.test.common;

import com.lucky.params.BaseData;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @Author shijin.huang
 * @Date 2021/10/12
 */
public class BaseDataTest {

    @Test
    public void baseDataTest() {
        BaseData baseData = BaseData.getBaseData();
        BaseData baseData2 = BaseData.getBaseData();
        Assert.assertSame(baseData, baseData2);
    }
}
