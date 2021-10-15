package otp.lucky.test.common;



import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import otp.lucky.common.utils.EnumUtil;
import otp.lucky.params.Env;


/**
 * @Author shijin.huang
 * @Date 2021/10/15
 */
@Slf4j
public class EnumUtilTest {

    @Test
    public void enTest(){
       if( EnumUtil.isInclude(Env.class,"test03")){
          Env env = EnumUtil.fromString(Env.class,"test03");
          log.info(env.value());
       }else {
           Assert.fail();
       }
    }
}
