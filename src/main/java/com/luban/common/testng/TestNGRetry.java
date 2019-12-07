package com.luban.common.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by shijin.huang on 2019/5/7
 * <p>
 * 实现IRetryAnalyzer
 */
@Slf4j
public class TestNGRetry implements IRetryAnalyzer {
    private int retryCount = 1;
    private static int maxRetryCount;

    private static final String PATH = "/src/main/resources/testng.properties";

    /**
     * 读取配置文件的重跑次数
     */
    static {
        TestNgConfigReader config = TestNgConfigReader.getInstance(PATH);
        maxRetryCount = config.getRetryCount();
        log.info("retrycount=" + maxRetryCount);
        log.info("sourceCodeDir=" + config.getSourceCodeDir());
        log.info("sourceCodeEncoding=" + config.getSrouceCodeEncoding());
    }


    /**
     * 重跑机制 设置
     *
     * @param result
     * @return
     */
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            String message = "Retry for [" + result.getName() + "] on class [" + result.getTestClass().getName() + "] Retry "
                    + retryCount + " times";
            log.info(message);
            Reporter.setCurrentTestResult(result);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }


}
