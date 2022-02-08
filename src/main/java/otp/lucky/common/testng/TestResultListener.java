package otp.lucky.common.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
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
        log.error("fail -- {}", tr.getName());

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        log.error("skip -- {}", tr.getName());

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        log.info("success -- {}", tr.getName());
    }

    @Override
    public void onTestStart(ITestResult tr) {
        String classPath = tr.getTestClass().getName() + "." + tr.getName();
        log.info("开始执行：-- {}", classPath);
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

    @Override
    public void onFinish(ITestContext testContext) {

    }

}
