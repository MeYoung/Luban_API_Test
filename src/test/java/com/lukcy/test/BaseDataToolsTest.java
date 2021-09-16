package com.lukcy.test;

import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import com.lucky.common.utils.BaseDataTools;
import com.lucky.params.BaseData;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
public class BaseDataToolsTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
    }


    @Test
    public void dataTest() {
        log.info("123123123123123123");
        Assert.assertTrue(false);
    }

    @OTPDataProvider(dataFile = "src/test/resources/json/loginArr.json")
    @Test
    public void dataTest2(JSONObject jsonObject) throws InterruptedException {
        Thread.sleep(3000);
        String password= jsonObject.getString("password");
        String Username= jsonObject.getString("Username");
        String isvalid= jsonObject.getString("isvalid");

        log.info("密码{},{},{}",password,Username,isvalid);
    }


    @OTPDataProvider(dataFile = "src/test/resources/json/login.json")
    @Test
    public void dataTest3333(JSONObject jsonObject) throws InterruptedException {
        Thread.sleep(2000);
        String password= jsonObject.getString("password");
        String Username= jsonObject.getString("Username");
        String isvalid= jsonObject.getString("isvalid");

        log.info("密码{},{},{}",password,Username,isvalid);
    }

    @Test(dataProvider = "data")
    public void ttt(int i, int j) {
        log.info("tttt.........{}+{}........", i, j);
    }


    @Test(threadPoolSize = 2, invocationCount = 5)
//    @Test
    public void test1() throws InterruptedException {
        BaseData baseData = new BaseData();
        baseData.setUid("123uid");
        baseData.setBaseURL(String.valueOf(Math.random()));
//        log.info("输出{}{}",i,j);
        BaseDataTools baseDataTools = BaseDataTools.getInstance();
        BaseDataTools baseDataTools2 = BaseDataTools.getInstance();
        Assert.assertTrue(baseDataTools == baseDataTools2);
        Thread.sleep(1000);

        BaseDataTools.getInstance().setBaseData(baseData);
        BaseData baseData1 = BaseDataTools.getInstance().getBaseData();
        log.info(baseData1.getUid());
        log.info(baseData1.getBaseURL());

//        BaseData baseData2 = new BaseData();
//        baseData2.setUid("");

//        log.info(baseData1.getUid());
//        log.info(baseData2.getUid());
    }
}
