package com.lucky.common.testng;

import com.lucky.common.report.OTPReport;
import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @Author shijin.huang
 * @Date 2021/10/09
 */
@Slf4j
public class InvokedMethodListener implements IInvokedMethodListener2 {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
//        判断是否是测试用例
        boolean isTestMethod = method.isTestMethod();
        if (isTestMethod) {
            OTPReport.setSeverity(method);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        boolean isTestMethod = method.isTestMethod();
        if (isTestMethod) {
            String[] groups = method.getTestMethod().getGroups();
            OTPReport.setCaseIDsInReport(groups);
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
