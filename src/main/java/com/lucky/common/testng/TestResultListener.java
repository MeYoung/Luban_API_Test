package com.lucky.common.testng;

import com.lucky.common.report.TestStep;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Arrays;

/**
 * @author shijin.huang
 * @date 2019-12-09
 * @content
 */
@Slf4j
public class TestResultListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        Allure.link("OTP_CaseId","https://www.google.com");
        Allure.parameter("OTP_CaseID",groups[0]);
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " fail");

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        Allure.parameter("OTP_CaseID",groups[0]);
        Allure.link("OTP_CaseId","CaseId","https://www.baidu.com");
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " skip");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        Allure.parameter("OTP_CaseID",groups[0]);
        // 写入报告
        TestStep.successStep(tr.getTestClass().getName(), tr.getName());
        log.info(tr.getName() + "success");
    }

    @Override
    public void onTestStart(ITestResult tr) {
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        Allure.parameter("OTP_CaseID",groups[0]);

        //  默认第一个作为用例ID
//        TestStep.setCaseID(groups[0]);
//        设置case名字，添加caseId
//        trMethod.setDescription(trMethod.getDescription()+" - "+groups[0]);
        String classPath = tr.getTestClass().getName() + "." + tr.getName();
        log.info("开始执行：" + classPath);
        super.onTestStart(tr);
    }

    @Override
    public void onConfigurationFailure(ITestResult tr) {
        super.onConfigurationFailure(tr);
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " fail");
    }

    @Override
    public void onConfigurationSkip(ITestResult tr) {
        super.onConfigurationSkip(tr);
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " skip");
    }

}
