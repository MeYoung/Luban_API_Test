package otp.lucky.test.common;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import otp.lucky.common.utils.AESCryptorUtil;

/**
 * @Author shijin.huang
 * @Date 2021/10/18
 */
@Slf4j
public class AESCryptorUtilTest {

    @Test
    public void encrypt() {
        String a = AESCryptorUtil.encrypt("测试一下", "b9MzdRGG7K17SBMZvnzf");
        log.info(a);
    }

    @Test
    public void decrypt() {
        String a = AESCryptorUtil.decrypt("sYB4t6VrWatfDyjmcsV_tw==", "b9MzdRGG7K17SBMZvnzf");
        log.info(a);
    }
}
