package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Slf4j
public class TxtDataProvider {


    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> dataText(Class testClass, ITestNGMethod method, ITestContext c) {
        OTPDataProvider otpDataProvider = DataProviderUtil.getDataProvderAn(testClass, method);
        String filePaht = otpDataProvider.dataFile();
        return getData(filePaht);
    }

    public Iterator<Object[]> getData(String path) {
        try {
            return new TxtIterator(new File(path));
        } catch (IOException e) {
            log.error("获取txt数据失败",e);
            return null;
        }
    }

    public static void main(String[] args) {
        TxtDataProvider txtDataProvider = new TxtDataProvider();
        Iterator<Object[]> object = txtDataProvider.getData("src/test/resources/txt/text.txt");
        Object o = JSONObject.toJSONString(object);
        log.info(o.toString());
    }


}
