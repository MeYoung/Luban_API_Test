package otp.lucky.common.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.List;
import java.util.Random;

/**
 * Created by shijin.huang on 2019/5/9
 */
public class ToolsUtil {

    /**
     * 对象间 copy
     *
     * @param orig
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T copy(Object orig, Class<T> clazz) {
        T dest;
        try {
            dest = clazz.newInstance();
//            BeanUtils.copyProperties(dest,orig);
            PropertyUtils.copyProperties(dest, orig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dest;
    }

    /**
     * list 任意两个元素对调
     *
     * @param list
     * @param oldPosition
     * @param newPosition
     * @param <T>
     */
    public static <T> void listSwap(List<T> list, int oldPosition, int newPosition) {
        if (null == list || list.size() == 0) {
            throw new IllegalStateException("List 为空！！！！！");
        }
        T tempElement = list.get(oldPosition);

        // 向前移动，前面的元素需要向后移动
        if (oldPosition < newPosition) {
            for (int i = oldPosition; i < newPosition; i++) {
                list.set(i, list.get(i + 1));
            }
            list.set(newPosition, tempElement);
        }
        // 向后移动，后面的元素需要向前移动
        if (oldPosition > newPosition) {
            for (int i = oldPosition; i > newPosition; i--) {
                list.set(i, list.get(i - 1));
            }
            list.set(newPosition, tempElement);
        }
    }

    /**
     * 生成随机数字,
     *
     * @param length 长度
     * @return 生成后的数字
     */
    public static long getNumRandom(int length) {
        long num = 0;
//            Math.random() 生成一个[0.0, 1.0)期间的随机数
//        Math.pow(double a ,double b) a的b次方
        num = (long) (Math.random() * Math.pow(10, length));
        return num;
    }

    /**
     * 生成 X 到 X 的随机数
     *
     * @param min 最小
     * @param max 最大
     * @return 随机数
     */
    public static int getNumRandom(int min, int max) {
        int num = 0;
        Random random = new Random();
//       nextInt(2) 生成一个 [0,2) 之间的随机数
        num = random.nextInt(max - min + 1) + min;
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
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
//            生成一个 [0,2) 之间的随机数
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            val += (char) (random.nextInt(26) + temp);
        }
        return val;
    }

    /**
     * 线程等待x秒
     *
     * @param count
     */
    public static void sleep(int count) {
        try {
            Thread.sleep(count * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
