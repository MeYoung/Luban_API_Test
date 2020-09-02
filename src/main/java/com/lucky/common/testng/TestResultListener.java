package com.lucky.common.testng;

import com.lucky.common.report.TestStep;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

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
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " fail");

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " skipped");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        // 写入报告
        TestStep.successStep(tr.getTestClass().getName(), tr.getName());
        log.info(tr.getName() + "success");
    }

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);
        String classPath = tr.getTestClass().getName() + "." + tr.getName();
        log.info("开始执行：" + classPath);
    }

    @Override
    public void onConfigurationFailure(ITestResult tr) {
        super.onConfigurationFailure(tr);
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " skipped");
    }

    @Override
    public void onConfigurationSkip(ITestResult tr) {
        super.onConfigurationSkip(tr);
        // 写入报告
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " skipped");
    }


}