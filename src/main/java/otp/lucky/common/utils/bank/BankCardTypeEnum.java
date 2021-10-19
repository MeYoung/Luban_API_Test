package otp.lucky.common.utils.bank;

/**
 * @Author shijin.huang
 * @Date 2021/10/19
 * <p>
 * 银行卡类型
 */
public enum BankCardTypeEnum {
    /**
     * 借记卡/储蓄卡
     */
    DEBIT("借记卡/储蓄卡"),
    /**
     * 信用卡/贷记卡
     */
    CREDIT("信用卡/贷记卡");

    private final String name;

    BankCardTypeEnum(String name) {
        this.name = name;
    }
}
