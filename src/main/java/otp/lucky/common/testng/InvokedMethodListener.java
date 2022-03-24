package otp.lucky.common.testng;

import com.alibaba.dubbo.registry.Registry;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import otp.lucky.common.report.OTPReport;
import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import otp.lucky.params.BaseData;

import java.util.List;

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

            ReferenceConfig config = BaseData.getInstance().getReferenceConfig();
            if (config != null) {
//                dubbo 资源释放
                config.destroy();
            }
        }


    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
