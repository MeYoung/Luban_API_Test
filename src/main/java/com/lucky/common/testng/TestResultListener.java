package com.lucky.common.testng;

import com.lucky.common.report.TestStep;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        setCaseIDsInReport(groups);
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " fail");

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        setCaseIDsInReport(groups);
        TestStep.failStep(tr.getTestClass().getName(), tr.getName());
        log.error(tr.getName() + " skip");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        setCaseIDsInReport(groups);
        TestStep.successStep(tr.getTestClass().getName(), tr.getName());
        log.info(tr.getName() + "success");
    }

    @Override
    public void onTestStart(ITestResult tr) {
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        setCaseIDsInReport(groups);
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

    private void setCaseIDsInReport(String [] groups) {
        String caseIds = "";
        for (int i = 0; i < groups.length; i++) {
            String str = groups[i];
            String pattern = "[1|2]_[0-9]\\d+_[0-9]\\d+_[a-zA-Z0-9]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            if (m.matches()) {
                Allure.link("OTP_CaseID"+i, "https://www.baidu.com");
            }else {
                ArrayUtils.remove(groups, i);
            }
        }
        StringUtils.join(groups,",");
        Allure.parameter("OTP_CaseIDs`", caseIds);
    }

}
