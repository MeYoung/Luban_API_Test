package otp.lucky.common.report;

import otp.lucky.common.annotion.OTP;
import io.qameta.allure.Allure;
import io.qameta.allure.util.ResultsUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author shijin.huang
 * @Date 2021/10/09
 */
@Slf4j
public class OTPReport {

    /**
     * 报告中写入 caseIDs
     *
     * @param groups
     */
    public static void setCaseIDsInReport(String[] groups) {
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
            log.info("OTP CaseIDs:{}", caseIDs);
            Allure.parameter("OTP_CaseIDs", String.join(",", caseIDs));
        } else {
            log.warn("当前自动化脚本用例未与OTP用例关联，建议做关联！！！");
        }

    }

    /**
     * 报告中写入 OTP 超链接
     *
     * @param caseID
     */
    private static void setCasesLinkInReport(String caseID) {
        final String otpUrl = "http://otp.lkcoffee.com/default/CaseAdmin?";
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

    /**
     * 报告中写入 优先级
     *
     * @param trMethod
     */
    public static void setSeverity(IInvokedMethod trMethod) {
        //            设定Allure 报告中对应case 优先级
        Method method = trMethod.getTestMethod().getConstructorOrMethod().getMethod();
        if (method.isAnnotationPresent(OTP.class)) {
            OTP otp = method.getAnnotation(OTP.class);
            String severity = otp.priority().value();
            Allure.label(ResultsUtils.SEVERITY_LABEL_NAME, severity);
        }
    }
}
