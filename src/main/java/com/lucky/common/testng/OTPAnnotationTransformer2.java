package com.lucky.common.testng;

import com.lucky.common.annotion.OTPDataProvider;
import com.lucky.common.testng.dataprovider.JsonDataProvicer;
import com.lucky.common.testng.dataprovider.SqlDataProvider;
import com.lucky.common.testng.dataprovider.TxtDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.IAnnotationTransformer2;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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
                chooseData(annotation, method);
            }
        }
//        重跑
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }


    final String  JSON_TYPE = ".json";
    final String  TEXT_TYPE = ".txt";
    final String  EXCEL_TYPE = ".xls";
    final String  SUPER_EXCEL_TYPE = ".xlsx";

    /**
     * 选择不同的 数据驱动源
     * @param annotation
     * @param method
     */
    public void chooseData(ITestAnnotation annotation, Method method) {
        OTPDataProvider otpDataProvider = method.getAnnotation(OTPDataProvider.class);
        String file =  otpDataProvider.dataFile().toLowerCase();
        if (file.endsWith(JSON_TYPE)) {
            annotation.setDataProviderClass(JsonDataProvicer.class);
        } else if (!otpDataProvider.sqlQuery().equals("") ) {
            annotation.setDataProviderClass(SqlDataProvider.class);
        }else if (file.endsWith(TEXT_TYPE)){
            annotation.setDataProviderClass(TxtDataProvider.class);
        }else if(file.endsWith(SUPER_EXCEL_TYPE)||file.endsWith(EXCEL_TYPE)){
//            excel

        }

    }
}
