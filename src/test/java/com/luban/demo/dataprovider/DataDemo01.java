package com.luban.demo.dataprovider;

import lombok.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author shijin.huang
 * @date 2019-07-26
 */
public class DataDemo01 {

    final static String loginPath="resource/d/member/login";


    @DataProvider
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

    @Test(dataProvider = "loginUser")
    public void loginTest(User1 user){
        String userName=user.getEmpLoginId();
        String pass= user.getUserPass();
        String q="{\n" +
                "  \"empLoginId\": \""+userName+"\",\n" +
                "  \"userPass\": \""+pass+"\",\n" +
                "  \"deviceId\": \"android_86c488ae-499d-329d-a790-228d04c0da8b\",\n" +
                "}";
    }

}


@Data
class User1 {
    String empLoginId;
    String userPass;
    String origin;
    String deviceId;
}


