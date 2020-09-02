package otp.runner;

import com.lucky.common.testng.RetryListener;
import com.lucky.common.testng.TestResultListener;
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
public class LuckyRunner {
    @Test
    @Parameters({"env","caseIds"})
    public void runner(String env, String caseIds) {

//        新增<suite>标签，并设置并发方式和并发数
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("OTP_DEMO");
        xmlSuite.setVerbose(3);
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(1);

//        设置suite parameter
        Map<String, String> mapParameters = new HashMap<>();
        mapParameters.put("env", env);
        xmlSuite.setParameters(mapParameters);

//        新增<Test>标签并设置
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("OTP自动化测试");

        String[] caseArrIDs = caseIds.split(",");
        System.out.println(caseIds);
        List<String> groups = Arrays.asList(caseArrIDs);

//        设置class or packages
        List<XmlPackage> packages = new ArrayList<>();
//        packages.add(new XmlPackage("otp.demo.*"));
        packages.add(new XmlPackage("otp.*"));
//        xmlTest.setParameters(mapParameters);
        xmlTest.setPackages(packages);
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
