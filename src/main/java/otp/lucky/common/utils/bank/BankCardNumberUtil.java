package otp.lucky.common.utils.bank;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import otp.lucky.common.utils.RandomUtil;

import java.util.Date;
import java.util.Random;

/**
 * @Author shijin.huang
 * @Date 2021/10/19
 * 生成随机银行卡号：
 * <p>
 * 参考：效验是否为银行卡，用于验证：
 * 现行 16 位银联卡现行卡号开头 6 位是 622126～622925 之间的，7 到 15 位是银行自定义的，
 * 可能是发卡分行，发卡网点，发卡序号，第 16 位是校验码。
 * 16 位卡号校验位采用 Luhm 校验方法计算：
 * 1，将未带校验位的 15 位卡号从右依次编号 1 到 15，位于奇数位号上的数字乘以 2
 * 2，将奇位乘积的个十位全部相加，再加上所有偶数位上的数字
 * 3，将加法和加上校验位能被 10 整除。
 */
@Slf4j
public class BankCardNumberUtil {
    private static BankCardNumberUtil instance = new BankCardNumberUtil();

    private BankCardNumberUtil() {
    }

    public static BankCardNumberUtil getInstance() {
        return instance;
    }

    public static String getBankCardId() {
//        生成卡号 622126 - 622925的卡号
        int prev = 622126 + RandomUtil.randomInt(0, 800);
        return BankCardNumberUtil.getInstance().generateByPrefix(prev);
    }


    /**
     * 根据给定前六位生成卡号
     *
     * @param prefix 银行卡前6位
     * @return 银行卡号
     */
    private String generateByPrefix(Integer prefix) {
        Random random = new Random(System.currentTimeMillis());
        String bardNo = prefix
                + StringUtils.leftPad(random.nextInt(999999999) + "", 9, "0");

        char[] chs = bardNo.trim().toCharArray();
        int luhnSum = BankCardNumberValidator.getLuhnSum(chs);
        char checkCode = luhnSum % 10 == 0 ? '0' : (char) (10 - luhnSum % 10 + '0');
        return bardNo + checkCode;
    }

    /**
     * 根据银行名称 及银行卡类型生成对应卡号
     *
     * @param bankName 银行名称
     * @param cardType 银行卡类型
     * @return 银行卡号
     */
    public static String getBankCardIdRandom(BankNameEnum bankName, BankCardTypeEnum cardType) {
        Integer[] candidatePrefixes = null;
        if (cardType == null) {
            candidatePrefixes = bankName.getAllCardPrefixes();
        } else {
            switch (cardType) {
                case DEBIT:
                    candidatePrefixes = bankName.getDebitCardPrefixes();
                    break;
                case CREDIT:
                    candidatePrefixes = bankName.getCreditCardPrefixes();
                    break;
                default:
            }
        }

        if (candidatePrefixes == null || candidatePrefixes.length == 0) {
            throw new RuntimeException("没有该银行的相关卡号信息");
        }

        Integer prefix = candidatePrefixes[new Random().nextInt(candidatePrefixes.length)];
        return BankCardNumberUtil.getInstance().generateByPrefix(prefix);
    }
}

