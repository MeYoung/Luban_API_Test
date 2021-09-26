package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author shijin.huang
 * @Date 2021/09/26
 */
@Slf4j
public class JsonDataProvicer {
    public Iterator<Object[]> getData(String path) {
        BufferedReader reader = null;
        String readJson = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                readJson += tempString;
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    log.info("读取到的Json文件:{}", readJson);
                    reader.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        List<Object[]> list = null;
        // 获取json
        try {
            JSONArray jsonArray = JSONObject.parseArray(readJson);
            list = Arrays.asList(DataProviderUtil.json2Map(jsonArray));
        } catch (JSONException e) {
            log.error(e.getMessage());
        }
        return list.iterator();

    }

    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> dataJson(Class testClass, Method testMethod) {
        OTPDataProvider otpDataProvider =testMethod.getAnnotation(OTPDataProvider.class);
        String dataFile = otpDataProvider.dataFile();
        JsonDataProvicer jsonDataProvicer = new JsonDataProvicer();
        return jsonDataProvicer.getData(dataFile);
    }


}

