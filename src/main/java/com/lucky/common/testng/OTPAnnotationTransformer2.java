package com.lucky.common.testng;

import cn.hutool.core.util.ArrayUtil;
import com.lucky.common.annotion.CasePriority;
import com.lucky.common.annotion.OTP;
import com.lucky.common.annotion.OTPDataProvider;
import com.lucky.common.testng.dataprovider.*;
import io.qameta.allure.Allure;
import io.qameta.allure.util.ResultsUtils;
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
 * @Author shijin.huang
 * @Date 2021/09/26
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
//       caseIDs转testNG认识的Groups
        boolean otpB = testMethod.isAnnotationPresent(OTP.class);
        if (otpB) {
            String[] groups = annotation.getGroups();
            OTP otp = testMethod.getAnnotation(OTP.class);
            String[] caseIDs = otp.caseIDs().split(",");
            String[] newGroups = ArrayUtil.addAll(groups, caseIDs);
            annotation.setGroups(newGroups);
        }

//        数据驱动
        boolean annotationDataProvider = testMethod.isAnnotationPresent(OTPDataProvider.class);
        if (annotationDataProvider) {
            annotation.setDataProvider(OTPDataProvider.NAME);
            DataProviderUtil.chooseData(annotation, testMethod);
        }

//        重跑
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }


}
