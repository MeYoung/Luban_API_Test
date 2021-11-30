package otp.lucky.common.utils;

//import org.apache.commons.beanutils.PropertyUtils;

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
//            PropertyUtils.copyProperties(dest, orig);
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
