package otp.lucky.common.utils;

import java.util.Random;

/**
 * @Author shijin.huang
 * @Date 2021/10/18
 * <p>
 * 随机数生成
 */
public class RandomUtil extends cn.hutool.core.util.RandomUtil {
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

}
