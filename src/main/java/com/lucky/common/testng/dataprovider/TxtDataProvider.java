package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @Author shijin.huang
 * @Date 2021/09/26
 */
@Slf4j
public class TxtDataProvider {


    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> dataText(Class testClass, Method testMethod, ITestContext c) {
        OTPDataProvider otpDataProvider =testMethod.getAnnotation(OTPDataProvider.class);
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
