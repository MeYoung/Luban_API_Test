package com.lucky.common.testng;

import com.lucky.common.annotion.OTP;
import io.qameta.allure.Allure;
import io.qameta.allure.util.ResultsUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
        log.error("fail -- {}", tr.getName());

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        setCaseIDsInReport(groups);
        log.info("{} -- skip", tr.getName());

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        setCaseIDsInReport(groups);
        log.info("{} -- success", tr.getName());
    }

    @Override
    public void onTestStart(ITestResult tr) {
        ITestNGMethod trMethod = tr.getMethod();
        String[] groups = trMethod.getGroups();
        setCaseIDsInReport(groups);
        String classPath = tr.getTestClass().getName() + "." + tr.getName();
        log.info("开始执行：--{}", classPath);

        //            设定Allure 报告中对应case 优先级
        OTP otp = trMethod.getConstructorOrMethod().getMethod().getAnnotation(OTP.class);
        Allure.label(ResultsUtils.SEVERITY_LABEL_NAME, otp.priority().value());

        super.onTestStart(tr);
    }

    @Override
    public void onConfigurationFailure(ITestResult tr) {
        super.onConfigurationFailure(tr);
        log.error("fail -- {}", tr.getName());
    }

    @Override
    public void onConfigurationSkip(ITestResult tr) {
        super.onConfigurationSkip(tr);
        log.error("skip -- {}", tr.getName());
    }

    private void setCaseIDsInReport(String[] groups) {
        List<String> caseIDs = new ArrayList<>(groups.length);
        for (String caseID : groups) {
            String pattern = "[1|2]_[0-9]\\d+_[0-9]\\d+_[a-zA-Z0-9]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(caseID);
            if (m.matches()) {
                caseIDs.add(caseID);
                setCasesLinkInReport(caseID);
            }
        }
        if (caseIDs.size() > 0) {
            log.info("caseIDs:{}", caseIDs);
            Allure.parameter("OTP_CaseIDs", String.join(",", caseIDs));
        } else {
            log.warn("当前自动化脚本用例未与OTP用例关联，建议做关联！！！");
        }

    }

    private void setCasesLinkInReport(String caseID) {
        final String otpUrl = "http://otp.luckincoffee.com/default/CaseAdmin?";
        String[] casesArr = caseID.split("_");
//       file 表示脑图， excel表示表格
        String type = "file";
        final String t = "2";
        if (t.equals(casesArr[0])) {
            type = "excel";
        }
        String projectId = casesArr[1];
        String caseId = casesArr[2];
        String nodeId = casesArr[3];
        String caseUrl = otpUrl + "?" + "projectId=" + projectId + "&caseId=" + caseId + "&type=" + type + "&nodeId=" + nodeId;
        Allure.link("OTP_CaseID:" + caseID, caseUrl);
    }

}
