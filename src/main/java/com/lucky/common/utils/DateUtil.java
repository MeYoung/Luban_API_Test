package com.lucky.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 */
public class DateUtil {

    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String FULL_TIME_HOUR_MIN_SPLIT_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String HOUR_MIN_SPLIT_PATTERN = "yyMMddHHmmss";


    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_PATTERN);
    }

    public static String formatHourMinTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, HOUR_MIN_SPLIT_PATTERN);
    }


    public static String formatFullTimeSplitPattern(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_SPLIT_PATTERN);
    }


    public static String formatFullTimeHourMinSplitPattern(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_HOUR_MIN_SPLIT_PATTERN);
    }

    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    public static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    public static String formatCSTTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(date);
        return DateUtil.getDateFormat(d, format);
    }
}
