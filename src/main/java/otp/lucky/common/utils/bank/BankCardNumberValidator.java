package otp.lucky.common.utils.bank;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import otp.lucky.params.FinalText;

/**
 * @Author shijin.huang
 * @Date 2021/10/19
 * <p>
 * 银行卡号校验类
 */
public class BankCardNumberValidator {

    /**
     * 校验银行卡号是否合法
     *
     * @param cardNo 银行卡号
     * @return 是否合法
     */
    public static boolean validate(String cardNo) {
        if (StringUtils.isEmpty(cardNo)) {
            return false;
        }

        if (!NumberUtils.isDigits(cardNo)) {
            return false;
        }

        if (cardNo.length() > FinalText.NUM_19 || cardNo.length() < FinalText.NUM_16) {
            return false;
        }

        int luhnSum = getLuhnSum(cardNo.substring(0, cardNo.length() - 1).trim().toCharArray());
        char checkCode = (luhnSum % 10 == 0) ? '0' : (char) ((10 - luhnSum % 10) + '0');
        return cardNo.substring(cardNo.length() - 1).charAt(0) == checkCode;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhn 校验算法获得校验位
     * 该校验的过程：
     * 1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
     * 2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去9），再求和。
     * 3、将奇数位总和加上偶数位总和，结果应该可以被10整除。
     */
    public static int getLuhnSum(char[] chs) {
        int luhnSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhnSum += k;
        }
        return luhnSum;
    }
}
