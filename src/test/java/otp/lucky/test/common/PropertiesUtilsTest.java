package otp.lucky.test.common;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import otp.lucky.common.utils.PropertiesUtil;

/**
 * @Author shijin.huang
 * @Date 2021/10/14
 */
@Slf4j
public class PropertiesUtilsTest {

    @Test
    public void getValue() {
        String value = PropertiesUtil.getValue("test03.zk.address");
        log.info(value);
    }
}
