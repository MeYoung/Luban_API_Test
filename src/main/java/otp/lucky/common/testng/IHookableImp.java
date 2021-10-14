package otp.lucky.common.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

@Slf4j
public class IHookableImp implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        log.info("start run...............");
        callBack.runTestMethod(testResult);
    }
}
