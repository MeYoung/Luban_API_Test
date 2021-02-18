package otp.runner;

import com.alibaba.fastjson.JSON;
import com.lucky.common.testng.RetryListener;
import com.lucky.common.testng.TestResultListener;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.*;

/**
 * @author shijin.huang
 * @date 2020/9/2
 */
@Slf4j
public class LuckyRunner {
    @Test
    @Parameters({"testPlanName", "env", "caseIds", "threadCount", "parallel", "packages", "otpParameters"})
    public void runner(String testPlanName, String env, String caseIds,
                       String threadCount, String parallel, String packages,
                       String otpParameters) {

//        新增<suite>标签，并设置并发方式和并发数
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("OTP_Automation_Runner");
        xmlSuite.setVerbose(3);

        final String method = "method";
//        设置并发方式
        if (method.equals(parallel)) {
            xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);
        } else {
            xmlSuite.setParallel(XmlSuite.ParallelMode.CLASSES);
        }
//        设置并发数
        xmlSuite.setThreadCount(Integer.parseInt(threadCount));

        int length = otpParameters.length();
//        设置suite parameter
        Map<String, String> mapParameters = new HashMap<>(length + 1);
        mapParameters.put("env", env);
//        动态解析 Parameters
        if (otpParameters.length() > 0) {
            HashMap map = JSON.parseObject(otpParameters, HashMap.class);
            mapParameters.putAll(map);
        }
        xmlSuite.setParameters(mapParameters);

        log.info("otpParameters:" + mapParameters.toString());

//        新增<Test>标签并设置
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName(testPlanName);

        String[] caseArrIDs = caseIds.split(",");
        log.info("caseIDs:" + caseIds);
        List<String> groups = Arrays.asList(caseArrIDs);

//        设置class or packages
        List<XmlPackage> packagesList = new ArrayList<>();

        String[] packagesArr = packages.split(",");
        for (int i = 0; i < packagesArr.length; i++) {
            packagesList.add(new XmlPackage(packagesArr[i]));
        }
        xmlTest.setPackages(packagesList);
        log.info("packagesList:" + packagesList.toString());

//        设置要执行的Groups 关键点
        xmlTest.setIncludedGroups(groups);

//        创建TestNG对象
        TestNG testNG = new TestNG();
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(xmlSuite);
        testNG.setXmlSuites(suites);
//        添加监听器
        List<Class<? extends ITestNGListener>> listenerClasses = new ArrayList<>();
        listenerClasses.add(RetryListener.class);
        listenerClasses.add(TestResultListener.class);
        testNG.setListenerClasses(listenerClasses);
//        run
        testNG.run();
    }
}
