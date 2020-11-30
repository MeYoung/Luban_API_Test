package otp.runner;

import com.alibaba.fastjson.JSON;
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
    @Parameters({"testPlanName", "env", "caseIds", "threadCount", "parallel", "packages", "OTPParameters"})
    public void runner(String testPlanName, String env, String caseIds,
                       String threadCount, String parallel, String packages,
                       String OTPParameters) {

//        新增<suite>标签，并设置并发方式和并发数
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("OTP_Automation_Runner");
        xmlSuite.setVerbose(3);

//        设置并发方式
        if ("methods".equals(parallel)) {
            xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);
        } else {
            xmlSuite.setParallel(XmlSuite.ParallelMode.CLASSES);
        }
//        设置并发数
        xmlSuite.setThreadCount(Integer.parseInt(threadCount));

//        设置suite parameter
        Map<String, String> mapParameters = new HashMap<>();
        mapParameters.put("env", env);
//        动态解析 Parameters
        if (OTPParameters.length()>0){
            HashMap map =  JSON.parseObject(OTPParameters, HashMap.class);
            mapParameters.putAll(map);
        }
        xmlSuite.setParameters(mapParameters);

        System.out.println(mapParameters.toString());

//        新增<Test>标签并设置
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName(testPlanName);

        String[] caseArrIDs = caseIds.split(",");
        System.out.println(caseIds);
        List<String> groups = Arrays.asList(caseArrIDs);

//        设置class or packages
        List<XmlPackage> packagesList = new ArrayList<>();
//        packages.add(new XmlPackage("otp.demo.*"));
//        packagesList.add(new XmlPackage("otp.*"));

        String[] packagesArr  = packages.split(",");
        for (int i = 0; i < packagesArr.length; i++) {
            packagesList.add(new XmlPackage(packagesArr[i]));
        }
//        xmlTest.setParameters(mapParameters);
        xmlTest.setPackages(packagesList);

        System.out.println(packagesList.toString());

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
