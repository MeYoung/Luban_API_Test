package otp.lucky.common.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @Author shijin.huang
 * @Date 2021/10/08
 * <p>
 * 多个以英文 , 隔开
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface OTP {

    //    caseID 多个用英文的 , 隔开
    String caseIDs() default "";

    //    优先级
    CasePriority priority();
}
