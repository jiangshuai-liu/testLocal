package com.common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @author jiangshuai
 * @Classname DateUtils
 * @Description 日期工具类，以操作Date 类为主
 * @Date 2021/9/13 17:16
 */
public class DateUtils {
    /**
     * 年月日时分秒无分隔符的基础格式 yyyyMMddHHmmss
     */
    public static final String BASE_PATTERN_DATE_TIME="yyyyMMddHHmmss";

    /**
     * 年月日时分秒 的显示格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String PATTERN_DATE_TIME="yyyy-MM-dd HH:mm:ss";

    /**
     *  年月日无分隔符的基础格式 yyyyMMdd
     */
    public static final String BASE_PATTERN_DATE="yyyyMMdd";

    /**
     * 年月日的显示格式 yyyy-MM-dd
     */
    public static final String PATTERN_DATE="yyyy-MM-dd";

    /**
     * 得到当前时间
     * @return 返回当前时间date
     */
    public static Date now(){
        return transferLocalDateTimeToDate(LocalDateTime.now());
    }

    /**
     * 得到当前时间的字符串形式  yyyyMMddHHmmss 格式的
     * @return 返回当前时间字符串
     */
    public static String nowStr(){
        return transferLocalDateTimeToStr(LocalDateTime.now(),BASE_PATTERN_DATE_TIME);
    }
    /**
     * 得到当前时间的字符串形式
     * @param pattern 日期格式
     * @return 返回当前时间字符串
     */
    public static String nowStr(String pattern){
        return transferLocalDateTimeToStr(LocalDateTime.now(),pattern);
    }
    /**
     * 得到当前时间的字符串形式
     * @param pattern 日期格式
     * @return 返回当前时间字符串
     */
    /**
     * 将带有时间格式的
     * @param dateStr 日期字符串
     * @param source 转化前格式，源格式
     * @param target 转化后格式，目标格式
     */
    public static String transferDateTimePattern(String dateStr,String source,String target){
        LocalDateTime parse = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(source));
        return transferLocalDateTimeToStr(parse,target);
    }

    /**
     * 得到两个时间的时间差，以天为单位 精确到毫秒
     * @param start 开始时间
     * @param end 结束时间
     * @return 返回两个时间的的时间差
     */
    public static long getDateDiffByDay(Date start , Date end){
        return getDateDiff(start, end, ChronoUnit.DAYS);
    }

    /**
     * 得到两个时间的时间差，以月为单位 精确到毫秒
     * @param start 开始时间
     * @param end 结束时间
     * @return 返回两个时间的的时间差
     */
    public static long getDateDiffByMonth(Date start , Date end){
        return getDateDiff(start, end, ChronoUnit.MONTHS);
    }

    /**
     * 得到两个时间的时间差，以年为单位 精确到月 可计算年龄
     * @param start 开始时间
     * @param end 结束时间
     * @return 返回两个时间的的时间差
     */
    public static long getDateDiffAccurateMonthByYear(Date start , Date end){
        LocalDateTime startDate=transferDateToLocalDateTime(start);
        LocalDateTime endDate=transferDateToLocalDateTime(end);
        return ChronoUnit.YEARS.between(startDate.withDayOfMonth(1),endDate.withDayOfMonth(1));
    }

    /**
     * 得到两个时间的时间差，以年为单位 精确到毫秒
     * @param start 开始时间
     * @param end 结束时间
     * @return 返回两个时间的的时间差
     */
    public static long getDateDiffByYear(Date start , Date end){
        return getDateDiff(start, end, ChronoUnit.YEARS);
    }


    /**
     * 得到两个时间的时间差，可自由决定计算单位 精确到毫秒
     * @param start 开始时间
     * @param end 结束时间
     * @param unit 日期计算单位 可以已传入 ChronoUnit ,从年到纳秒的时间维度都有
     * @return 返回两个时间的的时间差
     */
    public static long getDateDiff(Date start , Date end, TemporalUnit unit){
        LocalDateTime startDate=transferDateToLocalDateTime(start);
        LocalDateTime endDate=transferDateToLocalDateTime(end);
        return unit.between(startDate, endDate);
    }

    /**
     * 将date对象转化为LocalDateTime对象
     * @param date 需要转化的date对象
     * @return 返回转化后的LocalDateTime对象
     */
    public static LocalDateTime transferDateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将LocalDateTime对象转化为Date对象
     * @param localDateTime 需要转化的localDateTime对象
     * @return 返回转化后的Date对象
     */
    public static Date transferLocalDateTimeToDate(LocalDateTime localDateTime){
        return Date.from( localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalDateTime对象转化为Date对象
     * @param localDateTime 需要转化的localDateTime对象
     * @return 返回转化后的Date对象
     */
    public static String  transferLocalDateTimeToStr(LocalDateTime localDateTime,String pattern){
        DateTimeFormatter df=DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(df);
    }

    /**
     * 将LocalDate对象转化为Date对象
     * @param localDate 需要转化的localDate对象
     * @return 返回转化后的Date对象
     */
    public static Date transferLocalDateToDate(LocalDate localDate){
        return Date.from( localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }



    /**
     * 将date对象转化为str对象
     * @param date 需要转化的date对象
     * @param pattern 需要转化的格式
     * @return 返回转化后的Date对象
     */
    public static String transferDateToStr(Date date,String pattern){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        return transferLocalDateTimeToStr(localDateTime, pattern);
    }

    /**
     * 将LocalDate对象转化为str对象
     * @param localDate 需要转化的localDate对象
     * @param pattern 需要转化的格式
     * @return 返回转化后的Date对象
     */
    public static String transferLocalDateToStr(LocalDate localDate,String pattern){
        DateTimeFormatter df=DateTimeFormatter.ofPattern(pattern);
        return localDate.format(df);
    }



    /**
     * 将Date对象转化为LocalDate对象
     * @param date 需要转化的Date对象
     * @return 返回转化后的Date对象
     */
    public static LocalDate transferDateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * 将LocalDate对象转化为str对象
     * @param dateStr  日期字符串
     * @param pattern 日期字符串的格式
     * @return 返回转化后的Date对象
     */
    public static LocalDateTime transferStrToDateTime(String dateStr,String pattern){
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将LocalDate对象转化为str对象
     * @param dateStr  日期字符串
     * @param pattern 日期字符串的格式
     * @return 返回转化后的Date对象
     */
    public static LocalDate transferStrToDate(String dateStr,String pattern){
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将LocalDate对象转化为str对象
     * @param dateStr  日期字符串
     * @param pattern 日期字符串的格式
     * @return 返回转化后的Date对象
     */
    public static Long transferStrToTimeStamp(String dateStr,String pattern){
        return transferLocalDateTimeToTimeStamp(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern)));
    }

    /**
     * 将LocalDate对象转化为str对象
     * @param localDateTime  日期
     * @return 返回转化后的Date对象
     */
    public static Long transferLocalDateTimeToTimeStamp(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 得到当前传入时间的 最后一秒
     * @param date 需要计算的日期
     * @return 返回传入日期对象当天最后一秒的日期
     */
    public static Date getEndTime(Date date){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        LocalDateTime zeroTime= LocalDateTime.of( localDateTime.toLocalDate(), LocalTime.MIN);
        LocalDateTime endTime=zeroTime.plus(1,ChronoUnit.DAYS).minus(1,ChronoUnit.SECONDS);
        return transferLocalDateTimeToDate(endTime);
    }


    /**
     * 得到当前传入时间的 0 点
     * @param date 需要计算的日期对象
     * @return 返回传入日期对象当天的0点日期
     */
    public static Date getZeroTime(Date date){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        return transferLocalDateTimeToDate(LocalDateTime.of( localDateTime.toLocalDate(), LocalTime.MIN));
    }

    /**
     * 日期添加一定量的时间  单位为年
     * @param date 需要改变的日期
     * @param num 需要添加的年份数
     * @return 返回改变后的时间
     */
    public static Date dateAddByYear(Date date,int num){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        return transferLocalDateTimeToDate(localDateTime.plus(num,ChronoUnit.YEARS));
    }

    /**
     * 日期添加一定量的时间  单位为月
     * @param date 需要改变的日期
     * @param num 需要添加的年份数
     * @return 返回改变后的时间
     */
    public static Date dateAddByMonth(Date date,int num){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        return transferLocalDateTimeToDate(localDateTime.plus(num,ChronoUnit.MONTHS));
    }

    /**
     * 日期添加一定量的时间  单位为天
     * @param date 需要改变的日期
     * @param num 需要添加的天数
     * @return 返回改变后的时间
     */
    public static Date dateAddByDay(Date date,int num){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        return transferLocalDateTimeToDate(localDateTime.plus(num,ChronoUnit.DAYS));
    }


    /**
     * 日期添加一定量的时间 时分秒年月日都行
     * @param date 需要改变的日期
     * @param num 改变的数量
     * @param unit 改变的单位 可传入  ChronoUnit枚举
     * @return 返回改变后的时间
     */
    public static Date dateAdd(Date date,int num, TemporalUnit unit){
        LocalDateTime localDateTime=transferDateToLocalDateTime(date);
        return transferLocalDateTimeToDate(localDateTime.plus(num,unit));
    }

}
