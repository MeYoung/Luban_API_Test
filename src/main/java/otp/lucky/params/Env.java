package otp.lucky.params;


/**
 * @Author shijin.huang
 * @Date 2021/10/14
 */
public enum Env {
    TEST03("test03"),
    TEST04("test04"),
    PRE("pre"),
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
