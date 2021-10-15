package otp.lucky.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author shijin.huang
 * @Date 2021/10/15
 * 枚举工具类
 */
@Slf4j
public class EnumUtil extends cn.hutool.core.util.EnumUtil {

    /**
     * 判断某个字符串是否属于 某个枚举类中
     * @param enumClass  枚举类
     * @param str 被判断的字符串
     * @return
     */
    public static boolean isInclude(Class enumClass, String str) {
        List enumList = EnumUtils.getEnumList(enumClass);
        for (int i = 0; i < enumList.size(); i++) {
            Object en = enumList.get(i);
            Class<?> enClass = en.getClass();
            try {
                // vaue 需要与枚举类方法对应
                Method method = enClass.getMethod("value");
                Object invoke = method.invoke(en, null);
                if (str.equals(invoke.toString())) {
                    return true;
                }
            } catch (Exception e) {
                log.error("枚举执行value()方法失败...");
            }
        }
        return false;
    }
}
