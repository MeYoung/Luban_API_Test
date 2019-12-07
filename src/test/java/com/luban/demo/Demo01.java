package com.luban.demo;

import com.luban.common.utils.AssertUtils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shijin.huang on 2019/5/30
 */
@Slf4j
public class Demo01 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("我是一个BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("我是一个 beforeTest");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("我是一个 BeforeGroups");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("我是一个 beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("我是一个 beforeMethod");
    }

    @Test(description = "用例场景说明")
//    用例级别
    @Severity(SeverityLevel.BLOCKER)
    public void test1() {
        System.out.println("我是一个测试用例");
    }

    @Test(description = "用例场景说明2")
    @Severity(SeverityLevel.TRIVIAL)
    public void test2() {
        System.out.println("我是一个测试用例2");
    }

    @Test(timeOut = 1000)
    public void timeOut() throws InterruptedException {
        System.out.println("这个用例执行会失败");
        Thread.sleep(2000);
        log.info("fasdfasfaf");
        log.error("errr");
        log.debug("debug");
        log.warn("warn");
    }

    /**
     * 两个map对比
     */
    @Test
    public void mapT1(){
        Map<String,Object> map1 =new HashMap<>(10);;
        map1.put("a","b");
        map1.put("b2",2);
        map1.put("c",true);

        Map<String,Object> map2 =new HashMap<>(10);;
        map2.put("a","b");
        map2.put("c",true);
        map2.put("b2",2);

        AssertUtils.assertEquals(map1,map2);
    }

    /**
     * 两个list对比
     */
    @Test
    public void listT(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        List<String> list2 = new ArrayList<>();

        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        AssertUtils.assertEquals(list1,list2);
    }

    /**
     * 两个对象对比
     */
    @Test
    public void objectT(){
        A1 a1=new A1();
        a1.setAge(10).setName("baby").setT("tttt");

        A1 a11=new A1();
        a11.setName("baby").setAge(10).setT("tttt");

        AssertUtils.assertEquals(a1,a11);
    }

    /**
     * 两个数组对比
     */
    @Test
    public void arrayT(){
        String[] arr1={"1","2","3"};
        String[] arr2={"1","2","3"};
        AssertUtils.assertEquals(arr1,arr2);
    }
}

@Data
@Accessors(chain = true)
class A1{
    private String name;
    private int age;
    private String t;
}
