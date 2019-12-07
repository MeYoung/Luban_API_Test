package com.luban.demo.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * @author shijin.huang
 * @date 2019-07-26
 */
public class DataD2 {

    @DataProvider(name = "loginTest")
    public Object[][] loginUser(){
        User1 user1 = new User1();
        user1.setUserPass("pass1");
        user1.setEmpLoginId("user1");

        User1 user2 = new User1();
        user2.setUserPass("pass2");
        user2.setEmpLoginId("user2");

        User1 user3 = new User1();
        user3.setUserPass("pass3");
        user3.setEmpLoginId("user3");
        return new Object[][]{
                {user1},
                {user2},
                {user3}
        };
    }
}
