package otp.lucky.params;


/**
 * @Author shijin.huang
 * @Date 2021/10/14
 * 脚本执行环境
 */
public enum Env {

    /**
     * 测试3
     */
    TEST03("test03"),
    /**
     * 测试4
     */
    TEST04("test04"),
    /**
     * 预生产
     */
    PRE("pre"),
    /**
     * 线上
     */
    PROD("prod");

    private final String value;

    Env(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }
}
