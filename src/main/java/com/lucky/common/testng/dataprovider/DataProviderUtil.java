package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class DataProviderUtil {


    final static String JSON_TYPE = ".json";
    final static String TEXT_TYPE = ".txt";
    final static String EXCEL_TYPE = ".xls";
    final static String SUPER_EXCEL_TYPE = ".xlsx";

    /**
     * 选择不同的 数据驱动源
     *
     * @param annotation
     * @param method
     */
    public static void chooseData(ITestAnnotation annotation, Method method) {
        OTPDataProvider otpDataProvider = method.getAnnotation(OTPDataProvider.class);
        String file = otpDataProvider.dataFile().toLowerCase();
        if (file.endsWith(JSON_TYPE)) {
            annotation.setDataProviderClass(JsonDataProvicer.class);
        } else if (!"".equals(otpDataProvider.sqlQuery())) {
            annotation.setDataProviderClass(SqlDataProvider.class);
        } else if (file.endsWith(TEXT_TYPE)) {
            annotation.setDataProviderClass(TxtDataProvider.class);
        } else if (file.endsWith(SUPER_EXCEL_TYPE) || file.endsWith(EXCEL_TYPE)) {
            annotation.setDataProviderClass(ExcelDataProvider.class);
        } else {
            log.error("OTPDataProvider 属性值有误 请认真检查！");
        }
    }

    /**
     * @param list
     * @return
     */
    public static List<Object[]> map2Obj(List<Map<String, Object>> list) {
        List<Object[]> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Object object = JSONObject.toJSON(map);
            Object[] objects = new Object[1];
            objects[0] = object;
            arrayList.add(objects);
        }
        return arrayList;

    }

    /**
     * @param jsonArray
     * @return
     */
    public static Object[][] json2Map(JSONArray jsonArray) {
        Object[][] objects = new Object[jsonArray.size()][1];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            objects[i][0] = jsonObject;
        }
        return objects;
    }
}
