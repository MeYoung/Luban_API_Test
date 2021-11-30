package otp.lucky.common.utils;

import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.jsonunit.JsonAssert;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import otp.lucky.common.utils.bank.BankCardNumberUtil;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * Created by shijin.huang on 2018/5/9
 */
@Slf4j
public class AssertUtil extends Assert {

    /**
     * 校验是否为身份证ID
     *
     * @param idCard
     * @param message
     */
    public static void assertIdCard(String idCard, String message) {
        if (message != null) {
            log.info(message);
        }
        if (IdCardUtil.isValidCard(idCard)) {
            log.info("身份证:{}校验通过！",idCard);
        } else {
            log.error("身份证:{}校验失败！", idCard);
            Assert.fail();
        }
    }

    public static void assertIdCard(String idCard) {
        assertIdCard(idCard, null);
    }


    public static void assertBankIdCard(String idCard, String message){
        if (message != null) {
            log.info(message);
        }
        if (BankCardNumberUtil.isValidate(idCard)) {
            log.info("银行卡:{}校验通过！",idCard);
        } else {
            log.error("银行卡:{}校验失败！", idCard);
            Assert.fail();
        }
    }
    public static void assertBankIdCard(String idCard) {
        assertBankIdCard(idCard, null);
    }


    /**
     * 断言字符是否已某个字符串开头
     *
     * @param message 断言错误消息
     * @param content 待断言字符串
     * @param prefix  前缀表达式
     */
    public static void assertStartWith(String content, String prefix, String message) {
        if (message != null) {
            log.info(message);
        }

        if (content.startsWith(prefix)) {
            log.info("前缀匹配校验成功");
        } else {
            log.error("前缀匹配校验失败！\n待校验的字符窜为:" + content + "\n校验的前缀表达式为:" + prefix);
            AssertUtil.fail();
        }
    }

    /**
     * 断言字符是否已某个字符串开头
     *
     * @param content 待断言字符串
     * @param prefix  前缀表达式
     */
    public static void assertStartWith(String content, String prefix) {
        AssertUtil.assertStartWith(content, prefix, null);
    }


    /**
     * 断言字符是否已某个字符串结尾
     *
     * @param message 断言错误消息
     * @param content 待断言字符串
     * @param endfix  前缀表达式
     */
    public static void assertEndWith(String content, String endfix, String message) {
        if (message != null) {
            log.info(message);
        }

        if (content.endsWith(endfix)) {
            log.info("后缀匹配校验成功！");
        } else {
            log.error("后缀匹配校验失败！\n待校验的字符窜为:" + content + "\n校验的后缀表达式为:" + endfix);
            AssertUtil.fail();
        }
    }

    /**
     * 断言字符是否已某个字符串结尾
     *
     * @param content 待断言字符串
     * @param endfix  前缀表达式
     */
    public static void assertEndWith(String content, String endfix) {
        AssertUtil.assertEndWith(content, endfix, null);
    }


    /**
     * 根据正则表达式断言是否匹配
     *
     * @param message 断言错误信息
     * @param matcher 待校验的字符串
     * @param regex   校验的正则表达式
     */
    public static void assertMatch(String matcher, String regex, String message) {
        if (message != null) {
            log.info(message);
        }

        if (Pattern.matches(regex, matcher)) {
            log.info("匹配校验成功！");
        } else {
            log.error("匹配校验失败！\n待校验的字符串为:" + matcher + "\n校验的正则表达式为:" + regex);
            AssertUtil.fail();
        }
    }

    /**
     * 根据正则表达式断言是否匹配
     *
     * @param matcher 待校验的字符串
     * @param regex   校验的正则表达式
     */
    public static void assertMatch(String matcher, String regex) {
        AssertUtil.assertMatch(matcher, regex, null);
    }

    /**
     * 根据正则表达式断言是否匹配
     *
     * @param message 断言错误信息
     * @param matcher 待校验的字符串
     * @param regex   校验的正则表达式
     */
    public static void assertNoMatch(String matcher, String regex, String message) {
        if (message != null) {
            log.info(message);
        }

        if (!Pattern.matches(regex, matcher)) {
            log.info("匹配校验成功！");
        } else {
            log.error("匹配校验失败！\n待校验的字符串为:" + matcher + "\n校验的正则表达式为:" + regex);
            AssertUtil.fail();
        }
    }

    /**
     * 根据正则表达式断言是否匹配
     *
     * @param matcher 待校验的字符串
     * @param regex   校验的正则表达式
     */
    public static void assertNoMatch(String matcher, String regex) {
        AssertUtil.assertNoMatch(matcher, regex, null);
    }


    /**
     * 断言字符串中是否包含某些字符
     *
     * @param message  断言错误消息
     * @param content  断言的字符串为
     * @param included 包含的字符串
     */
    public static void assertInclude(String content, String included, String message) {
        if (message != null) {
            log.info(message);
        }
        if (content.contains(included)) {
            log.info("匹配校验成功！");
        } else {
            log.error("匹配校验失败！\n待校验的字符串为:" + content + "\n包含字符串为:" + included);
            AssertUtil.fail(message);
        }
    }

    /**
     * 断言字符串中是否包含某些字符
     *
     * @param content  断言的字符串为
     * @param included 包含的字符串
     */
    public static void assertInclude(String content, String included) {
        AssertUtil.assertInclude(content, included, null);
    }


    /**
     * 两个对象对比
     *
     * @param obj1
     * @param obj2
     * @param <T>
     */
    public static <T> void compare(T obj1, T obj2) {
//        Map<String, String> result = new HashMap<String, String>();
        Field[] fs = obj1.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            Object v1 = null;
            Object v2 = null;
            try {
                v1 = f.get(obj1);
                v2 = f.get(obj2);
            } catch (IllegalAccessException e) {
                AssertUtil.fail();
                e.printStackTrace();
            }
            if (!equals(v1, v2)) {
                log.error("\n" + f.getName() + "：\n" + "实际值：" + v1 + "\n" + "预期值：" + v2);
                AssertUtil.fail();
            } else {
                log.info(f.getName() + "：" + "实际值：" + v1 + "预期值：" + v2);
            }
        }
    }

    private static boolean equals(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return true;
        }
        return obj1.equals(obj2);
    }


    /**
     * 两个对象对比，对象属性值有null情况
     *
     * @param actual
     * @param expected
     * @param cls
     * @param <T>
     */
/*    public static <T> void compare(T actual, T expected, Class<T> cls) {
        try {
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                PropertyDescriptor pd = null;
                pd = new PropertyDescriptor(field.getName(), cls);
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(actual);
                Object o2 = getMethod.invoke(expected);
                //避免空指针异常
                String s1 = o1 == null ? "" : o1.toString();
                //避免空指针异常
                String s2 = o2 == null ? "" : o2.toString();
                if (!s1.equals(s2)) {
                    log.error("\n" + field.getName() + "：\n" + "实际值：" + s1 + "\n" + "预期值：" + s2);
                    AssertUtils.fail();
                } else {
                    log.info(field.getName() + "：" + "实际值：" + s1 + "预期值：" + s2);
                }
            }
        } catch (Exception e) {
            AssertUtils.fail();
            e.printStackTrace();
        }
    }*/
    public static void assertSuccess(String reponse) {
        JsonPath jsonPath = new JsonPath(reponse);
        Assert.assertTrue(jsonPath.getBoolean("success"));
        Assert.assertEquals(jsonPath.getString("statusInfo"), "SUCCESS");
        Assert.assertEquals(jsonPath.getInt("status"), 0);
    }

    /**
     * Assert : 校验值非 NULL 和为空
     *
     * @param obj
     */
    public static void assertNotEmpty(Object obj) {
        assertNotEmpty(obj, null);
    }

    /**
     * Assert : 校验值非 NULL 和为""
     *
     * @param obj
     * @param msg
     */
    public static void assertNotEmpty(Object obj, String msg) {
        Assert.assertTrue(StringUtils.isNotEmpty(obj.toString()), msg);
    }


    /**
     * 连个json对比是否相等
     *
     * @param expected
     * @param actual
     */
    public static void assertJsonEquals(Object expected, Object actual) {
        JsonAssert.assertJsonEquals(expected, actual);
    }


    /**
     * @param expected
     * @param actual
     * @param paths    不校验的路径
     */
    @Attachment("结果json校验")
    public static void assertJsonEquals(Object expected, Object actual, String... paths) {
        JsonAssert.assertJsonEquals(expected, actual, JsonAssert.whenIgnoringPaths(paths));
    }
}

