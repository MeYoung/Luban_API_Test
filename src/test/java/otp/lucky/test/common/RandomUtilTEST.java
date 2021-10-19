package otp.lucky.test.common;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import otp.lucky.common.utils.AssertUtil;
import otp.lucky.common.utils.IdCardUtil;
import otp.lucky.common.utils.RandomUtil;
import otp.lucky.common.utils.bank.BankCardTypeEnum;
import otp.lucky.common.utils.bank.BankNameEnum;

/**
 * @Author shijin.huang
 * @Date 2021/10/19
 */
@Slf4j
public class RandomUtilTEST {

    @Test(invocationCount = 100,threadPoolSize = 10)
    public void genIDCardRandomTest(){
       String id = IdCardUtil.getIDCard18Random();
       AssertUtil.assertIdCard(id);
    }


    @Test
    public void getBankCardIdRandom1(){
        log.info(RandomUtil.getBankCardIdRandom());
        log.info(RandomUtil.getBankCardIdRandom(BankNameEnum.CMBC,BankCardTypeEnum.DEBIT));
    }
}


