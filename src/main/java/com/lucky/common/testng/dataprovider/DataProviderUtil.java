package com.lucky.common.testng.dataprovider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import org.testng.ITestNGMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtil {

    /**
     * 获取 OTPDataprovider 注解
     *
     * @param testClass
     * @param method
     * @return
     */
    public static OTPDataProvider getDataProvderAn(Class testClass, ITestNGMethod method) {
        String name = method.getMethodName();
        //        获取测试class的所有方法
        Method[] declaredMethods = testClass.getDeclaredMethods();
        OTPDataProvider otpDataProvider = null;
        for (Method method2 : declaredMethods) {
            boolean annotationDataProvider = method2.isAnnotationPresent(OTPDataProvider.class);
            if (annotationDataProvider && method2.getName().equals(name)) {
//                获取OTPDataProvider 注解
                otpDataProvider = method2.getAnnotation(OTPDataProvider.class);
                break;
            }
        }
        return otpDataProvider;
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
