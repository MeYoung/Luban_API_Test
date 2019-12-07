package com.luban.demo.casem;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

/**
 * Created by shijin.huang on 2019/6/17
 */
@Slf4j
public class TestNGDemo {


    @BeforeSuite
    public void beforeSuite() {
        log.info("this is beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        log.info("this is beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        log.info("this is beforeClass");
    }


    @BeforeMethod
    public void beforeMethod() {
        log.info("this is beforeMethod");
    }

    @Test
    public void test1() {
        log.info("this is test1");
    }


    @Test
    public void test2() {
        log.info("this is test2");
    }

    @AfterMethod
    public void afterMethod() {
        log.info("this is afterMethod");
    }

    @AfterClass
    public void afterClass() {
        log.info("this is AfterClass");
    }

    @AfterTest
    public void afterTest() {
        log.info("this is AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        log.info("this is AfterSuite");
    }
}
