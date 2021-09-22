package com.lucky.common.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * datafile : 数据文件  csv 、 excel 、 txt
 * sheetname：excel数据文件的工作表名称，默认为第一张工作表
 * sqlquery：数据库查询，如果提供了数据文件，则不会使用。 必须需要其他数据库属性
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface OTPDataProvider {

    public static final String NAME = "OTP-Data-Provider";
    public static final String NAME_PARALLEL = "OTP-Data-Provider-Parallel";

    String dataFile() default "";

    String sheetName() default "";

    String sqlQuery() default "";

    String sqlConfigID() default "";

}
