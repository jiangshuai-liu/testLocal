package helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.util.*;

/**
 * @Title DateHelper
 * @Author JiangShuai
 * @Description
 * @Date 2024/9/24 17:55
 * @Version 1.0
 **/
@Slf4j
public class DateHelper extends DateUtils{
    private static final String PARSE_PATTERNS_HYPHEN_YMD = "yyyy-MM-dd";
    private static final String PARSE_PATTERNS_HYPHEN_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    private static final String PARSE_PATTERNS_HYPHEN_YMDHM = "yyyy-MM-dd HH:mm";
    private static final String PARSE_PATTERNS_HYPHEN_YMDH = "yyyy-MM-dd HH";
    private static final String PARSE_PATTERNS_HYPHEN_YM = "yyyy-MM";
    private static final String PARSE_PATTERNS_VIRGULE_YMD = "yyyy/MM/dd";
    private static final String PARSE_PATTERNS_VIRGULE_YMDHMS = "yyyy/MM/dd HH:mm:ss";
    private static final String PARSE_PATTERNS_VIRGULE_YMDHM = "yyyy/MM/dd HH:mm";
    private static final String PARSE_PATTERNS_VIRGULE_YMDH = "yyyy/MM/dd HH";
    private static final String PARSE_PATTERNS_VIRGULE_YM = "yyyy/MM";
    private static final String PARSE_PATTERNS_POINT_YMD = "yyyy.MM.dd";
    private static final String PARSE_PATTERNS_POINT_YMDHMS = "yyyy.MM.dd HH:mm:ss";
    private static final String PARSE_PATTERNS_POINT_YMDHM = "yyyy.MM.dd HH:mm";
    private static final String PARSE_PATTERNS_POINT_YMDH = "yyyy.MM.dd HH";
    private static final String PARSE_PATTERNS_POINT_YM = "yyyy.MM";
    private static final String PARSE_PATTERNS_CHINESE_YMD = "yyyy年MM月dd日";
    private static final String PARSE_PATTERNS_CHINESE_YMDHMS = "yyyy年MM月dd日 HH时mm分ss秒";
    private static final String PARSE_PATTERNS_CHINESE_YMDHM = "yyyy年MM月dd日 HH时mm分";
    private static final String PARSE_PATTERNS_CHINESE_YMDH = "yyyy年MM月dd日 HH时";
    private static final String PARSE_PATTERNS_CHINESE_YM = "yyyy年MM月";
    private static final String PARSE_PATTERNS_Y = "yyyy";
    private static final String PARSE_PATTERNS_M = "MM";
    private static final String PARSE_PATTERNS_D = "dd";
    private static final String PARSE_PATTERNS_E = "E";
    private static final String PARSE_PATTERNS_YMDHMS = "yyyyMMddHHmmss";
    private static final String PARSE_PATTERNS_YMD = "yyyyMMdd";
    private static final String PARSE_PATTERNS_YM = "yyyyMM";
    private static final String PARSE_PATTERNS_YMD_START = "yyyyMMdd000000";
    private static final String PARSE_PATTERNS_YMD_END = "yyyyMMdd235959";
    private static final String PARSE_PATTERNS_COLON_HMS = "HH:mm:ss";


    public static String dateFmt(String dateString, String source, String target) {
        try {
            if (StringHelper.isEmpty(dateString)) {
                return "";
            }
            return formatDate(parseDate(dateString, source), target);
        } catch (Exception e) {
            log.error("DateHelper.dateFmt 异常 : {}", e.getMessage(), e);
            return "";
        }
    }
    /**
     * 得到日期字符串 ，转换格式（yyyy-MM-dd）
     */
    public static String formatDate(Date date) {
        return formatDate(date, PARSE_PATTERNS_HYPHEN_YMD);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(long dateTime, String pattern) {
        return formatDate(new Date(dateTime), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (date != null){
            if (StringUtils.isBlank(pattern)) {
                pattern = PARSE_PATTERNS_HYPHEN_YMD;
            }
            formatDate = FastDateFormat.getInstance(pattern).format(date);
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, PARSE_PATTERNS_HYPHEN_YMDHMS);
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate(PARSE_PATTERNS_HYPHEN_YMD);
    }

    /**
     * 得到当前日期字符串 格式（yyyyMMddHHmmss）
     * @return
     */
    public static String getNow(){
        return getDate(PARSE_PATTERNS_YMDHMS);
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return FastDateFormat.getInstance(pattern).format(new Date());
    }

    /**
     * 得到当前日期前后多少天，月，年的日期字符串
     * @param pattern 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     * @param amont 数量，前为负数，后为正数
     * @param type 类型，可参考Calendar的常量(如：Calendar.HOUR、Calendar.MINUTE、Calendar.SECOND)
     * @return
     */
    public static String getDate(String pattern, int amont, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(type, amont);
        return FastDateFormat.getInstance(pattern).format(calendar.getTime());
    }

    /**
     * 得到当前日期前后多少天，月，年的日期字符串
     * @param amont 数量，前为负数，后为正数
     * @param type 类型，可参考Calendar的常量(如：Calendar.HOUR、Calendar.MINUTE、Calendar.SECOND)
     * @return
     */
    public static Date getDate( int amont, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(type, amont);
        return calendar.getTime();
    }

    /**
     * 得到指定日期前后多少天，月，年的日期字符串
     * @param amont 数量，前为负数，后为正数
     * @param type 类型，可参考Calendar的常量(如：Calendar.HOUR、Calendar.MINUTE、Calendar.SECOND)
     * @param date 指定需要查询的日期
     * @return
     */
    public static Date getDate( int amont, int type, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, amont);
        return calendar.getTime();
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), PARSE_PATTERNS_COLON_HMS);
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), PARSE_PATTERNS_HYPHEN_YMDHMS);
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), PARSE_PATTERNS_Y);
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), PARSE_PATTERNS_M);
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), PARSE_PATTERNS_D);
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), PARSE_PATTERNS_E);
    }

    /**
     * 日期型字符串转化为日期 格式   see to DateUtils#parsePatterns
     */
    public static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return parseDate(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseDate(Object str, String parsePatterns) {
        if (str == null){
            return null;
        }
        try {
            return DateUtils.parseDate(str.toString(), parsePatterns);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(24*60*60*1000);
    }

    /**
     * 获取过去的小时
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(60*60*1000);
    }

    /**
     * 获取过去的分钟
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(60*1000);
    }

    /**
     * 获取过去的秒
     * @param date
     * @return
     */
    public static long pastSecnod(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(1000);
    }
    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取某月有几天
     * @param date 日期
     * @return 天数
     */
    public static int getMonthHasDays(Date date){
        String yyyyMM = FastDateFormat.getInstance(PARSE_PATTERNS_YM).format(date);
        String year = yyyyMM.substring(0, 4);
        String month = yyyyMM.substring(4, 6);
        String day31 = ",01,03,05,07,08,10,12,";
        String day30 = "04,06,09,11";
        int day = 0;
        if (day31.contains(month)) {
            day = 31;
        } else if (day30.contains(month)) {
            day = 30;
        } else {
            int y = Integer.parseInt(year);
            if ((y % 4 == 0 && (y % 100 != 0)) || y % 400 == 0) {
                day = 29;
            } else {
                day = 28;
            }
        }
        return day;
    }

    /**
     * 获取日期是当年的第几周
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取一天的开始时间（如：2015-11-3 00:00:00.000）
     * @param date 日期
     * @return
     */
    public static Date getOfDayFirst(Date date) {
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取一天的最后时间（如：2015-11-3 23:59:59.999）
     * @param date 日期
     * @return
     */
    public static Date getOfDayLast(Date date) {
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取服务器启动时间
     * @param
     * @return
     */
    public static Date getServerStartDate(){
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 格式化为日期范围字符串
     * @param beginDate 2018-01-01
     * @param endDate 2018-01-31
     * @return 2018-01-01 ~ 2018-01-31

     */
    public static String formatDateBetweenString(Date beginDate, Date endDate){
        String begin = formatDate(beginDate);
        String end = formatDate(endDate);
        if (StringUtils.isNoneBlank(begin, end)){
            return begin + " ~ " + end;
        }
        return null;
    }

    /**
     * 解析日期范围字符串为日期对象
     * @param dateString 2018-01-01 ~ 2018-01-31
     * @return new Date[]{2018-01-01, 2018-01-31}

     */
    public static Date[] parseDateBetweenString(String dateString){
        Date beginDate = null; Date endDate = null;
        if (StringUtils.isNotBlank(dateString)){
            String[] ss = StringUtils.split(dateString, "~");
            if (ss != null && ss.length == 2){
                String begin = StringUtils.trim(ss[0]);
                String end = StringUtils.trim(ss[1]);
                if (StringUtils.isNoneBlank(begin, end)){
                    beginDate = parseDate(begin);
                    endDate = parseDate(end);
                }
            }
        }
        return new Date[]{beginDate, endDate};
    }

    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }
    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    /**
     * 给时间加上几个分钟
     * @param date 时间
     * @param minut 需要加的时间
     * @return
     */
    public static String addDateMinut(Date date, int minut){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minut);// 24小时制
        date = cal.getTime();
        cal = null;
        return formatDate(date, PARSE_PATTERNS_HYPHEN_YMDHMS);
    }

    /**
     * 给时间加上几个小时
     * @param date 时间
     * @param hour 需要加的时间
     * @return DATE
     */
    public static Date addDate(Date date, int hour){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    /**
     * 日期比较
     * @param date1 日期参数1
     * @param date2 日期参数2
     * @return 1 date1>date2;-1 date1<date2;0 date1=date2
     */
    public static int compareDate(String date1, String date2) {
        try {
            Date dt1 = parseDate(date1, PARSE_PATTERNS_HYPHEN_YMDHMS);
            Date dt2 = parseDate(date2, PARSE_PATTERNS_HYPHEN_YMDHMS);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 得到两个日期的月份差
     * @param start 开始日期
     * @param end 结束日期
     * @return  返回月份差值
     */
    public static int getMonthDiff(Date start,Date end){
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);
        int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        if ((startCalendar.get(Calendar.DATE) == 1)&& (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }

    }

    /**
     * 转化日期字符串的格式
     * @param dateString 日期参数
     * @return 1 date1>date2;-1 date1<date2;0 date1=date2
     */
    public static String dateStrFormat(String dateString,String sourceFormat,String targetFormat) {
        if(StringHelper.isEmpty(dateString)){
            return dateString;
        }
        Date date= parseDate(dateString, sourceFormat);
        return FastDateFormat.getInstance(targetFormat).format(date);
    }

    /** ==================== 字符串类 日期操作 ==================== */
    /**
     * 得到当前的时间 格式为format
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return getDate(format);
    }

    /**
     * 得到当前的时间 格式为yyyyMMdd
     * @return
     */
    public static String getToday() {
        return getNow(PARSE_PATTERNS_YMD);
    }

    /**
     * 获得当前日期前一个月，格式为yyyy-MM-dd
     */
    public static String dateFmt_qyr() {
        return formatDate(addDate(new Date(), -24));
    }

    /**
     * 得到当前的时间 格式为yyyy-MM-dd
     * @return
     */
    public static String getTodayFmt() {
        return getNow(PARSE_PATTERNS_HYPHEN_YMD);
    }

    /**
     * 格式化日期字符串  输入
     * yyyy-MM-dd TO yyyyMMddHHmmss
     */
    public static String dateFmt_ymdhms(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YMD), PARSE_PATTERNS_YMDHMS);
    }

    /**
     * 格式化日期字符串  输入
     * yyyy-MM-dd TO yyyyMMdd
     */
    public static String dateFmt_ymd_8(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YMD), PARSE_PATTERNS_YMD);
    }
    /**
     * 格式化日期字符串  输出
     * yyyyMMdd TO yyyy-MM-dd
     */
    public static String dateFmt_8_ymd(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_YMD), PARSE_PATTERNS_HYPHEN_YMD);
    }

    /**
     * 格式化日期字符串  输入
     * yyyy-MM TO yyyyMM
     */
    public static String dateFmt_ym_6(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YM), PARSE_PATTERNS_YM);
    }
    /**
     * 格式化日期字符串  输出
     * yyyyMM TO yyyy-MM
     */
    public static String dateFmt_6_ym(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_YM), PARSE_PATTERNS_HYPHEN_YM);
    }

    /**
     * 格式化日期字符串  输入_查询结束时间
     * yyyy-MM-dd TO yyyyMMdd235959
     */
    public static String dateFmt_ymdhms_cx(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YMD), PARSE_PATTERNS_YMD_END);
    }

    /**
     * 格式化日期字符串  输入
     * yyyy-MM TO yyyyMMdd235959
     */
    public static String dateFmt_ymhms_end(String rq) {
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YM), PARSE_PATTERNS_YMD_END);
    }

    /**
     * 格式化日期字符串  输出
     * yyyyMMddHHmmss TO yyyy-MM-dd
     */
    public static String dateFmt_ymd(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_YMDHMS), PARSE_PATTERNS_HYPHEN_YMD);
    }

    /**
     * 格式化日期字符串  输出
     * yyyy-MM TO yyyyMMddHHmmss
     */
    public static String dateFmt_ymToymdhms(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YM), PARSE_PATTERNS_YMDHMS);
    }

    /**
     * 格式化日期字符串  输出
     * yyyyMMddHHmmss TO yyyy-MM
     */
    public static String dateFmt_ym(String rq) {
        return StringUtils.substring(rq, 0, 4) + "-" + StringUtils.substring(rq, 4, 6);
    }

    /**
     * 格式化日期字符串  输入
     * yyyy-MM-dd TO yyyyMMdd000000
     */
    public static String dateFmt_ymdhms_begin(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YMD), PARSE_PATTERNS_YMD_START);
    }

    /**
     * 格式化日期字符串  输入
     * yyyy-MM TO yyyyMMdd000000
     */
    public static String dateFmt_ymhms_begin(String rq) {
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YM), PARSE_PATTERNS_YMD_START);
    }

    /**
     * 给传入的时间加上几个分钟 字符串日期操作
     * @param date
     * @param paramPattern
     * @param minut
     * @param returnPattern
     * @return
     */
    public static String addDateMinutForStringWithTime(String date, String paramPattern, int minut, String returnPattern){
        if(StringUtils.isEmpty(date)){
            paramPattern = PARSE_PATTERNS_YMDHMS;
            date = formatDate(new Date(), paramPattern);
        }
        return formatDate(parseDate(addDateMinut(parseDate(date, paramPattern), minut), PARSE_PATTERNS_HYPHEN_YMDHMS), returnPattern);
    }

    /**
     * 给当前时间加上几个分钟 字符串日期操作
     * @param returnPattern
     * @return
     */
    public static String addDateMinutForString(int minut, String returnPattern){
        return addDateMinutForStringWithTime(null, null, minut, returnPattern);
    }

    /**
     * 给传入的时间加上几个小时 字符串日期操作
     * @param date
     * @param paramPattern
     * @param hour
     * @param returnPattern
     * @return
     */
    public static String addDateHourForStringWithTime(String date, String paramPattern, int hour, String returnPattern){
        if(StringUtils.isEmpty(date)){
            paramPattern = PARSE_PATTERNS_YMDHMS;
            date = formatDate(new Date(), paramPattern);
        }
        return formatDate(addDate(parseDate(date, paramPattern), hour), returnPattern);
    }

    /**
     * 给当前时间加上几个小时 字符串日期操作
     * @param hour
     * @param returnPattern
     * @return
     */
    public static String addDateHourForString(int hour, String returnPattern){
        return addDateHourForStringWithTime(null, null, hour, returnPattern);
    }

    /**
     * 得到日期字符串（yyyyMM），转换格式（yyyy-MM）
     */
    public static String dateFmt_Y_m(String rq) {
        return formatDate(parseDate(rq, PARSE_PATTERNS_YM), PARSE_PATTERNS_HYPHEN_YM);
    }
    /**
     * 得到日期字符串（yyyy-MM） ，转换格式（yyyyMM）
     */
    public static String dateFmt_Ym(String rq) {
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YM), PARSE_PATTERNS_YM);
    }

    /**
     *得到当前月的后几个月的第一天
     * @param amont 数量，前为负数，后为正数
     * @param ny 指定需要查询的日期 格式必须为：yyyy-MM
     *
     */
    public static String getNextMonthFirstDay(int amont,String ny){
        return formatDate(getDate(amont, Calendar.MONTH, parseDate(dateFmt_Ym(ny), PARSE_PATTERNS_YM)));
    }

    /**
     * 格式化日期字符串  输入_查询结束时间
     * yyyyMMdd TO yyyy-MM-dd
     */
    public static String dateFmtY_m_dToymd(String rq){
        return formatDate(parseDate(rq, PARSE_PATTERNS_HYPHEN_YMD), PARSE_PATTERNS_YMD);
    }

    /**
     * 得到当前月的最后一天
     * @return
     */
    public static String getLastDay() {
        return getLastDay(0);
    }

    /**
     * 得到前后 i月 的最后一天
     * @param i
     * @return
     */
    public static String getLastDay(int i){
        Calendar calast = Calendar.getInstance();
        calast.add(Calendar.MONTH, i);
        calast.set(Calendar.DAY_OF_MONTH, calast.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDay = formatDate(calast.getTime(), PARSE_PATTERNS_HYPHEN_YMD);
        return lastDay;
    }

    /**
     * 获取多少天之后的日期（不包含参数时间）
     * @param deftime  参数时间
     * @param oldfmt   原格式：yyyyMMdd
     * @param timediff 天数*24
     * @param newfmt   输出格式：yyyyMMdd
     * @return
     */
    public static String getBeforeTime(String deftime, String oldfmt, int timediff, String newfmt) {
        String rq = null;
        try {
            if ((deftime == null) || ("".equals(deftime))) {
                return null;
            }
            Calendar cal =  Calendar.getInstance();
            Date d = parseDate(deftime, oldfmt);
            cal.clear();
            cal.setTime(d);
            if (cal == null) {
                log.error("Error: Method: DateHelper.getBeforeTime :Incorrect Calendar");
                return rq;
            }
            cal.add(12, -timediff*60);
            rq = formatDate(cal.getTime(), newfmt);
        } catch (Exception e) {
            log.error("Fatal: Method: DateHelper.getBeforeTime :" + e.getMessage());
        }
        return rq;
    }

    /**
     * 获取当前年月的上i月
     * 例如 现在202109  i=1 得到202108
     * @return
     */
    public static String getSy(int i){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-i);
        Date date = cal.getTime();
        return formatDate(date, PARSE_PATTERNS_YM);
    }

    /**
     * 获取指定时间的下N月
     * @param rq 格式必须为yyyyMMddHHmmss
     * @return
     */
    public static String getNext_n_month(String rq,int month) throws ParseException {
        Date sourceDate = parseDate(rq, PARSE_PATTERNS_YMDHMS);
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        Date y = c.getTime();
        return formatDate(y, PARSE_PATTERNS_YMDHMS);
    }

    /**
     * 获取指定时间的下N年
     * @param rq 格式必须为yyyyMMddHHmmss
     * @return
     */
    public static String getXyy(String rq,int year){
        Calendar cld = Calendar.getInstance();
        Date date =null;
        try {
            date= parseDate(rq, PARSE_PATTERNS_YMDHMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cld.setTime(date);
        int yea1r=cld.get(Calendar.YEAR);
        cld.set(Calendar.YEAR, yea1r+year);
        String res = formatDate(cld.getTime(), PARSE_PATTERNS_YMDHMS);
        return res;
    }

    /**
     * 根据 l 获取格式为target的时间
     */
    public static String getDate_sourceL(long l, String target) {
        return formatDate(new Date(l), target);
    }

    /**
     * 根据fmt格式的时间，获取 Long，解析异常则返回 null
     */
    public static Long getDate_targetL(String fmt, String source) {
        try {
            return parseDate(fmt, source).getTime();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     *@Description:日期转换，将接口返回的20180524转为2018-05-24
     *@param str 传递的日期字符串
     */
    public static String dateConvertion(String str) {
        Date parse = null;
        String dateString = "";
        try {
            parse = parseDate(str, PARSE_PATTERNS_YMD);
            dateString = formatDate(parse, PARSE_PATTERNS_HYPHEN_YMD);
        } catch (Exception e) {
            dateString=null;
        }

        return dateString;
    }

    public static String dateConvertionY(String str) {
        Date parse = null;
        String dateString = "";
        try {
            parse = parseDate(str, PARSE_PATTERNS_HYPHEN_YMD);
            dateString = formatDate(parse, PARSE_PATTERNS_YMD);
        } catch (Exception e) {
            dateString=null;
        }
        return dateString;
    }

    /**
     * 获取自申请时间后第n个工作日，jrgzr = { jr, gzr }
     */
    public static String getGzrDnt(String[] jrgzr, String yyyyMMdd, int n) {
        String str = null;
        Calendar c = Calendar.getInstance();//获取日期类 实例
        try {
            c.setTime(parseDate(yyyyMMdd, PARSE_PATTERNS_YMD));//日期类解析剩余时间
        } catch(Exception e){
            return "";
        }
        List gzrs = new ArrayList();
        for(int i = 0; i < n; i++) {
            c.add(Calendar.DATE, 1);
            String rq = formatDate(c.getTime(), PARSE_PATTERNS_YMD);
            if(jrgzr[0].indexOf(rq) != -1) {
                i--;
                continue;
            } else if(jrgzr[1].indexOf(rq) != -1) {
                gzrs.add(rq);
            } else if(c.get(Calendar.DAY_OF_WEEK) == 1 || c.get(Calendar.DAY_OF_WEEK) == 7) {
                i--;
                continue;
            } else {
                gzrs.add(rq);
            }
        }
        str = (String) gzrs.get(n - 1);
        return str;
    }

    /**
     * 获取下一天
     * @param fmt
     * @param oldDateStr
     * @param addYear
     * @param addMonth
     * @param addDay
     * @return
     * @throws ParseException
     */
    public static String getNextDate(String fmt,String oldDateStr,int addYear , int addMonth , int addDay) throws ParseException {
        Date sourceDate = parseDate(oldDateStr, fmt);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sourceDate);
        cal.add(Calendar.YEAR,addYear);
        cal.add(Calendar.MONTH, addMonth);
        cal.add(Calendar.DATE, addDay);
        return formatDate(cal.getTime(), fmt);
    }

//    public static void main(String[] args) throws ParseException {
//        log.info("=======> {}", getDate("yyyy-MM-dd HH:mm:ss"));
//        log.info("=======> {}", getDate("yyyy-MM-dd HH:mm:ss", 1, Calendar.YEAR));
//        log.info("=======> {}", getDate("yyyy-MM-dd HH:mm:ss", 1, Calendar.MONTH));
//        log.info("=======> {}", getDate("yyyy-MM-dd HH:mm:ss", 1, Calendar.WEEK_OF_YEAR));
//        log.info("=======> {}", getDate("yyyy-MM-dd HH:mm:ss", 1, Calendar.DAY_OF_MONTH));
//        log.info("=======> {}", getDate("yyyy-MM-dd HH:mm:ss", 1, Calendar.HOUR));
//    }

    /**
     * 获取 承诺办结时间（或某时间戳后N小时时间）
     * 除去假日、非工作时间等
     * @param time   时间戳
     * @param hour   延后N小时
     * @param jrs    节假日 格式 20230124,20230125
     * @param gzrs   工作日 格式 20230121,20230128
     * @param workHoursStart   工作开始时间 格式：09:00:00
     * @param workHoursEnd     工作结束时间 格式：17:30:00
     * @param noonBreakStart   午休开始时间 格式：12:00:00
     * @param noonBreakEnd     午休结束时间 格式：13:00:00
     * @return  时间戳 报错返回 0
     */
    public static long getDaysAfterHourSetTime(long time, Integer hour, String jrs, String gzrs, String workHoursStart, String workHoursEnd, String noonBreakStart, String noonBreakEnd) {
        Date date = new Date(time);
        try {
            Date current = date;
            //指定时间  1小时  单位小时 ,自己根据需求修正
            int zdSec = hour * 60 * 60;

            String hm6 = formatDate(current, PARSE_PATTERNS_HYPHEN_YMD);
            while (true) {
                String startWork = hm6 + " " + workHoursStart;
                String lunchBreak = hm6 + " " + noonBreakStart;
                String workGoOn = hm6 + " " + noonBreakEnd;
                String offDuty = hm6 + " " + workHoursEnd;
                //今天是否为节假日
                if (checkHoliday(current, jrs, gzrs)) {
                    //是节假日
                    String sw = hm6 + " " + workHoursStart;
                    current = getTomorrow(parseDate(sw, PARSE_PATTERNS_HYPHEN_YMDHMS));
                } else {
                    if (zdSec <= 0) {
                        break;
                    }
                    //如果当前时间小于 早上上班时间  把时间初始化到九点半
                    if (current.getTime() < parseDate(startWork, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime()) {
                        current = parseDate(startWork, PARSE_PATTERNS_HYPHEN_YMDHMS);
                        continue;
                    }
                    //如果时间在上午上班内 就用当前时间 到上午下班时间减掉 是否大于有效时间
                    //如果不大于有效时间就直接九点半加上有效时间 如果大于有限时间 就减掉有效时间
                    //设置当前时间为下午上班时间
                    if (parseDate(startWork, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime() <= current.getTime() && current.getTime()
                            <= parseDate(lunchBreak, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime()) {
                        TimeDifference datePoor = getDatePoor(current, parseDate(lunchBreak, PARSE_PATTERNS_HYPHEN_YMDHMS));
                        if (datePoor.getTotalSec() >= zdSec) {
                            current = addHour(zdSec, current, 2);
                            break;
                        } else {
                            zdSec = zdSec - datePoor.getTotalSec().intValue();
                            current = parseDate(workGoOn, PARSE_PATTERNS_HYPHEN_YMDHMS);
                            continue;
                        }
                    }
                    if (parseDate(lunchBreak, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime() < current.getTime() && current.getTime()
                            < parseDate(workGoOn, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime()) {
                        //如果时间在午休时候  就让时间变成下午起始时间
                        current = parseDate(workGoOn, PARSE_PATTERNS_HYPHEN_YMDHMS);
                    }
                    //如果时间在下午上班时间 就用当前时间 到下午下班时间减掉有效时间
                    if (parseDate(workGoOn, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime() <= current.getTime() && current.getTime()
                            <= parseDate(offDuty, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime()) {
                        TimeDifference datePoor = getDatePoor(current, parseDate(offDuty, PARSE_PATTERNS_HYPHEN_YMDHMS));
                        if (datePoor.getTotalSec() >= zdSec) {
                            current = addHour(zdSec, current, 2);
                            break;
                        } else {
                            zdSec = zdSec - datePoor.getTotalSec().intValue();
                            current = getTomorrow(parseDate(startWork, PARSE_PATTERNS_HYPHEN_YMDHMS));
                            continue;
                        }
                    }
                    //如果时间在下午下班时候 就跳过再次进入循环
                    if (current.getTime() > parseDate(offDuty, PARSE_PATTERNS_HYPHEN_YMDHMS).getTime()) {
                        current = getTomorrow(parseDate(startWork, PARSE_PATTERNS_HYPHEN_YMDHMS));
                    }
                }
            }
            return current.getTime();
        }catch (Exception e){
            log.error("获取承诺办结时间方法异常：{}", e.getMessage(), e);
            return 0;
        }
    }

    /**
     * 计算两个时间相差天 时 分 秒 总秒数
     * @param endDate
     * @param nowDate
     * @return
     */
    public static TimeDifference getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = nowDate.getTime()-endDate.getTime() ;
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        Long longHour=hour*60*60+min*60+sec;
        return new TimeDifference(day, hour, min,sec,longHour);
    }

    public static Date addHour(int time, Date creatTime, int type) {
        //设置生效时间为一小时后
        Calendar cal = Calendar.getInstance();
        cal.setTime(creatTime);
        switch (type) {
            case 1: {
                // 24小时制
                cal.add(Calendar.HOUR, time);
            }
            case 3: {
                // 24小时制
                cal.add(Calendar.MINUTE, time);
            }
            case 2:{
                cal.add(Calendar.SECOND, time);
            }
            default:
        }
        return cal.getTime();
    }

    /**
     * 入参为空 和 不是假期返回 false, 是假期返回 true
     * @param tomorrow
     * @param jrs
     * @param gzrs
     * @return
     */
    private static boolean checkHoliday(Date tomorrow, String jrs, String gzrs) {
        boolean b = false;
        if(StringHelper.isEmpty(jrs) || StringHelper.isEmpty(gzrs)) {
            return false;
        }

        String week = formatDate(tomorrow, "E");
        if("星期六".equals(week) || "星期日".equals(week)){
            // 看是否为工作日
            if(!gzrs.contains(formatDate(tomorrow, PARSE_PATTERNS_YMD))){
                b = true;
            }
        }else{
            // 周一至周五 看是否为节假日
            if(jrs.contains(formatDate(tomorrow, PARSE_PATTERNS_YMD))){
                b = true;
            }
        }
        return b;
    }

    /**
     * 获取明天的日期
     *
     * @param date
     * @return
     */
    public static Date getTomorrow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取指定时间的下N月
     *
     * @param nowYM 格式yyyyMM
     * @return
     */
    public static String getNext_n_monthYM(String nowYM,int month) {
        Date sourceDate = parseDate(nowYM, PARSE_PATTERNS_YM);
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        Date y = c.getTime();
        return formatDate(y, PARSE_PATTERNS_YM);
    }
}
