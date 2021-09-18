package com.lucky.common.testng.dataprovider;

import com.lucky.common.annotion.OTPDataProvider;
import org.testng.ITestNGMethod;

import java.lang.reflect.Method;

public class DataProviderUtil {

    /**
     * 获取 OTPDataprovider 注解
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
}
