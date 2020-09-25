package com.lucky.common.testng;

import com.lucky.common.report.TestStep;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private void setCaseIDsInReport(String[] groups) {
        List<String> caseIDs = new ArrayList<>(groups.length);
        for (String caseID : groups) {
            String pattern = "[1|2]_[0-9]\\d+_[0-9]\\d+_[a-zA-Z0-9]+";
            Pattern r = Pattern.compile(pattern);
            System.out.println(caseID);
            Matcher m = r.matcher(caseID);
            if (m.matches()) {
                caseIDs.add(caseID);
                setCasesLinkInReport(caseID);
            }
        }
        Allure.parameter("OTP_CaseIDs`", String.join(",", caseIDs));
    }

    private void setCasesLinkInReport(String caseID) {
        final String otpBaseUrl = "http://otptest.luckincoffee.com/default/CaseAdmin?";
        String[] casesArr = caseID.split("_");
//       file 表示脑图， excel表示表格
        String type = "file";
        if (casesArr[0].equals("2")) {
            type = "excel";
        }
        String projectId = casesArr[1];
        String caseId = casesArr[2];
        String nodeId = casesArr[3];
        String caseUrl = otpBaseUrl + "?" + "projectId=" + projectId + "&caseId=" + caseId + "&type=" + type + "&nodeId=" + nodeId;
        Allure.link("OTP_CaseID:" + caseID, caseUrl);
    }

}
