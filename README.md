旧框架需要修改的文件：

1. 新增一个xml，如项目中 runxml/otpdemo.xml，用于跟OTP关联
2. 编写一个Runner文件，如otp.demo.runner.LuckyRunner.java，用于动态生成要执行的Case的xml
3. 修改TestNG的监听器，如com.lucky.common.testng.TestResultListener.java ,用于给allure报告添加OTPcaseid等
4. 如果你的自动化测试项目是子父（多模块）项目在 main的resource中添加 allure.properties ，设定Allure报告生成位置


OTP 调度大体图
![](https://gitee.com/meyoung/picgo_image/raw/master/2021/20210304154658.png)