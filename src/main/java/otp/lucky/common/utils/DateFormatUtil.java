package otp.lucky.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by shijin.huang on 2018/11/29
 */
public class DateFormatUtil {

    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";

    public static final String SHORT_DATE_FORMAT = "yy-MM-dd HH:mm";

    public static final String SMALL_DATE_FORMAT = "MM-dd";

    public static final String ABC_ORDER_DATE_FORMAT = "yyyy/MM/dd";

    public static final String ABC_ORDER_TIME_FORMAT = "HH:mm:ss";

    public static final String LOTTERY_PRINTING_TIME_FORMAT = "HH_mm_ss";

    public static final String CHECK_LOG_FORMAT = "yyyyMMdd";

    public static final String TEN_PAY_DATE_STRING_FORMAT = "yyMMdd";

    public static final String REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ZH_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

    /**
     * 引入SimpleDateFormat类处理时间
     */
    private static SimpleDateFormat simpleDateFormat;

    public static String format(String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        String s = simpleDateFormat.format(new Date());
        return s;
    }


    public static Date parse(String date, String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        Date s = null;
        try {
            s = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String format(Date date, String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String s = simpleDateFormat.format(date);
        return s;
    }

    public static String format(String date, String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String s = simpleDateFormat.format(date);
        return s;
    }

    /**
     * 把其他格式的时间，转成 xxxx-xx-xx 格式
     *
     * @param date
     * @return
     */
    public static Date format(Date date) {
        String date1 = DateFormatUtil.format(date, DateFormatUtil.COMMON_DATE_FORMAT);
        return DateFormatUtil.parse(date1, DateFormatUtil.COMMON_DATE_FORMAT);
    }

    /**
     * 把LocalDateTime 转成 type格式
     *
     * @param localDateTime
     * @param type 转化后格式
     * @return
     */
    public static String format(LocalDateTime localDateTime,String type) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return DateFormatUtil.format(date, type);
    }

    public static long time() {
        long t = System.currentTimeMillis();
        return t;
    }

    /**
     * 生成若干天后日期
     *
     * @param afterdays
     * @param type
     * @return
     */
    public static String afterDays(int afterdays, String type) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf2 = new SimpleDateFormat(type);
        calendar.add(Calendar.DATE, afterdays);
        String daysAfter = sdf2.format(calendar.getTime());
        return daysAfter;
    }

    /**
     * 创建时间为今日0点开始
     *
     * @return Date
     */
    public static Date dayStartTime() {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(new Date());
        calendarStart.set(Calendar.HOUR_OF_DAY, 0);
        calendarStart.set(Calendar.MINUTE, 0);
        calendarStart.set(Calendar.SECOND, 0);
        return calendarStart.getTime();
    }


    /**
     * 创建时间为一周前0点
     * @return 一周前0点
     */
    public static Date weekStartTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, -7);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 今日最后时间 23.59.999
     *
     * @return Date
     */
    public static Date dayEndTime() {
        Calendar calendarEnd = Calendar.getInstance();
        // HOUR_OF_DAY 24小时制
        calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
        calendarEnd.set(Calendar.MINUTE, 59);
        calendarEnd.set(Calendar.SECOND, 59);
        calendarEnd.set(Calendar.MILLISECOND, 999);
        return calendarEnd.getTime();
    }


}
