package otp.lucky.common.utils;

import lombok.extern.slf4j.Slf4j;
import otp.lucky.common.utils.bank.BankCardNumberUtil;
import otp.lucky.common.utils.bank.BankCardTypeEnum;
import otp.lucky.common.utils.bank.BankNameEnum;

import java.util.Random;

/**
 * @Author shijin.huang
 * @Date 2021/10/18
 * <p>
 * 随机数生成
 */
@Slf4j
public class RandomUtil extends cn.hutool.core.util.RandomUtil {

    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 生成随机数字,
     *
     * @param length 长度
     * @return 生成后的数字
     */
    public static long getNumRandom(int length) {
        long num = (long) (Math.random() * Math.pow(10, length));
        return num;
    }

    /**
     * 生成 X 到 X 的随机数
     *
     * @param min 最小
     * @param max 最大
     * @return 随机数
     */
    public static long getNumRandom(int min, int max) {
        Random random = new Random();
        long num = random.nextInt(max - min + 1) + min;
        return num;
    }

    /**
     * 生成随机数字和字母,
     *
     * @param length 长度
     * @return 生成后的字符串
     */
    public static String getStringNumRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
//            生成一个 [0,2) 之间的随机数
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equals(charOrNum)) {
                //输出是大写字母还是小写字母 根据ASCII值 A:65 a:97
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equals(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    /**
     * 生成随机数字和字母,
     *
     * @param length 长度
     * @return 生成后的字符串
     */
    public static String getStringRandom(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
//            生成一个 [0,2) 之间的随机数
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            val.append((char) (random.nextInt(26) + temp));
        }
        return val.toString();
    }

    /**
     * 生成18位身份证号
     *
     * @return
     */
    public static String getIDCard18Random() {
        return IdCardUtil.getIDCard18Random();
    }

    /**
     * 通过区域名称生成对应的 身份证
     *
     * @param areaName
     * @return
     */
    public static String getIdCard18ByAreaName(String areaName) {
        return IdCardUtil.getIdCard18ByAreaName(areaName);
    }

    private static final String[] EAMIL_SUFFIX = ("@luckincoffee.com,@gmail.com,@yahoo.com,@msn.com,@hotmail.com," +
            "@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net," +
            "@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn")
            .split(",");


    /**
     * 随机生成email
     *
     * @param leng        长度
     * @param emailSuffix 邮箱后缀
     * @return
     */
    public static String getEmailRandom(int leng, String emailSuffix) {
        StringBuffer sb = new StringBuffer();
        sb.append(getStringNumRandom(leng));
        sb.append(emailSuffix);
        return sb.toString();
    }

    /**
     * 随机生成email
     *
     * @return
     */
    public static String getEmailRandom() {
        StringBuffer sb = new StringBuffer();
        sb.append(getStringNumRandom(Math.toIntExact(getNumRandom(3, 7))));
        sb.append(EAMIL_SUFFIX[(int) (Math.random() * EAMIL_SUFFIX.length)]);
        return sb.toString();
    }

    private static final String[] MOBILE_PREFIX = ("133,153,177,180,181,189,134,135,136,137,138,139,150,151,152,157,158," +
            "159,178,182,183,184,187,188,130,131,132,155,156,176,185,186,145,147,170 ").split(",");

    /**
     * 随机生成手机号码
     *
     * @return 返回手机号码
     */
    public static String getPhoneRandom() {
        int i = Math.toIntExact(getNumRandom(0, MOBILE_PREFIX.length - 1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MOBILE_PREFIX[i]);
        stringBuilder.append(getNumRandom(10));
        return stringBuilder.toString();
    }

    /**
     * 根据预期前缀返回11未电话随机号码
     *
     * @param prefix 手机号码前缀
     * @return 返回手机号码
     */
    public static String getPhoneRandom(String prefix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);
        stringBuilder.append(getNumRandom(8));
        return stringBuilder.toString();
    }

    /**
     * 随机获取银行卡号
     *
     * @return 返回银行卡号
     */
    public static String getBankCardIdRandom() {
        return BankCardNumberUtil.getInstance().getBankCardId();
    }

    /**
     * 随机生成某银行某类型卡号
     *
     * @param bankName 银行名字
     * @param cardType 银行卡类型
     * @return 返回对应银行卡号
     */
    public static String getBankCardIdRandom(BankNameEnum bankName, BankCardTypeEnum cardType) {
        return BankCardNumberUtil.getBankCardIdRandom(bankName, cardType);
    }

    /**
     * 随机生成中文名
     *
     * @return 中文名
     */
    public static String getChineseNameRandom() {
        return ChineseNameUtil.getInstance().getChineseNameRandom();
    }

}
