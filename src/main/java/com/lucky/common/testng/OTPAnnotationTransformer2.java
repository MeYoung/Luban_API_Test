package com.lucky.common.testng;

import com.alibaba.fastjson.JSONObject;
import com.lucky.common.annotion.OTPDataProvider;
import com.lucky.common.testng.dataprovider.JsonDataProvicer;
import lombok.extern.slf4j.Slf4j;
import org.testng.IAnnotationTransformer2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * IAnnotationTransformer2 继承了 IAnnotationTransformer
 */
@Slf4j
public class OTPAnnotationTransformer2 implements IAnnotationTransformer2 {

    /**
     * 操作 @Configuration 注解，但是已经不再使用
     *
     * @param annotation
     * @param testClass
     * @param testConstructor
     * @param testMethod
     */
    @Override
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    }

    /**
     * 操作 @DataProvider
     *
     * @param annotation
     * @param method
     */
    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
        log.info("annotation.getName():{}", annotation.getName());
    }

    /**
     * 操作 @Factor
     *
     * @param annotation
     * @param method
     */
    @Override
    public void transform(IFactoryAnnotation annotation, Method method) {

    }

    /**
     * 从 IAnnotationTransformer 接口继承 操作 @Test
     *
     * @param annotation
     * @param testClass
     * @param testConstructor
     * @param testMethod
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        String name = testMethod.getName();
        Class<?> tCaseClass = testMethod.getDeclaringClass();
        Method[] declaredMethods = tCaseClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            boolean annotationDataProvider = method.isAnnotationPresent(OTPDataProvider.class);
            if (annotationDataProvider && method.getName().equals(name)) {
                annotation.setDataProvider(OTPDataProvider.NAME);
                annotation.setDataProviderClass(OTPAnnotationTransformer2.class);
            }
        }
//        重跑
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }


    @DataProvider(name = OTPDataProvider.NAME)
    public Iterator<Object[]> data(Class testClass, ITestNGMethod method, ITestContext c) {
        String name = method.getMethodName();
        //        获取测试class的所有方法
        Method[] declaredMethods = testClass.getDeclaredMethods();
        String dataFile = "";
        for (Method method2 : declaredMethods) {
            boolean annotationDataProvider = method2.isAnnotationPresent(OTPDataProvider.class);
            if (annotationDataProvider && method2.getName().equals(name)) {
                log.info("测试方法名:{}", method2.getName());
//                获取OTPDataProvider 注解
                OTPDataProvider otpDataProvider = method2.getAnnotation(OTPDataProvider.class);
                // 根据对象获取注解 dataFile 值
                dataFile = otpDataProvider.dataFile();
            }
        }
        JsonDataProvicer jsonDataProvicer = new JsonDataProvicer();
        return jsonDataProvicer.getData(dataFile);
    }


    /**
     * 设置@Test 的 dataprovider
     *
     * @param testAnnotation
     * @param method
     */
    public static void setOTPDataProvider(ITestAnnotation testAnnotation, Method method) {
        if ((null != method) && null != method.getParameterTypes() && (method.getParameterTypes().length > 0)) {
            String dataProvider = testAnnotation.getDataProvider();
            boolean hasDataProvider = isNotBlank(dataProvider);

            // 判断是否设定了dataprovider
            if (hasDataProvider && !dataProvider.startsWith(OTPDataProvider.NAME)) {
                //
                Map<String, String> desc = new HashMap<String, String>();
                desc.put("description", testAnnotation.getDescription());
                desc.put("dataProvider", testAnnotation.getDataProvider());
                Class<?> dpClass = testAnnotation.getDataProviderClass();
                if (null != dpClass) {
                    desc.put("dataProviderClass", dpClass.getName());
                }
                testAnnotation.setDescription(new JSONObject().get(desc).toString());
            }

          /*  boolean globalParallelSetting = getBundle().getBoolean("global.datadriven.parallel", false);
            boolean parallel = getBundle().getBoolean(method.getName() + ".parallel", globalParallelSetting);*/
//            dataProvider = parallel ? OTPDataProvider.NAME_PARALLEL : OTPDataProvider.NAME;
//            testAnnotation.setDataProvider(dataProvider);

            testAnnotation.setDataProvider(OTPDataProvider.NAME);
            testAnnotation.setDataProviderClass(OTPAnnotationTransformer2.class);
        }
    }


}
