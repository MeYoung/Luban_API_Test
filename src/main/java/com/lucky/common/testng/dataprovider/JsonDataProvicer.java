package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class JsonDataProvicer implements DataProviderImpl {
    @Override
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
            list = Arrays.asList(json2Map(jsonArray));
        } catch (JSONException e) {
            log.error(e.getMessage());
        }
        return list.iterator();

    }

    @Override
    public void setData() {

    }

    public static Object[][] json2Map(JSONArray jsonArray) {
        Object[][] objects = new Object[jsonArray.size()][1];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            objects[i][0] = jsonObject;
        }
        return objects;
    }
}

