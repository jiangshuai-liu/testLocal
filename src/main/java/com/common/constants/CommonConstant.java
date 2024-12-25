package com.common.constants;

/**
 * <p  color=yellow>
 * 常量
 * </p>
 *
 * @author jiangshuai
 * @since 20241218
 */
public class CommonConstant {
    //-------日期
    /**
     * <p  color=yellow>日期格式:yyyyMM</p>
     */
    public static final String DATE_FORMAT_YM ="yyyyMM";
    /**
     * <p  color=yellow>日期格式:yyyyMMdd</p>
     */
    public static final String DATE_FORMAT_YMD ="yyyyMMdd";
    /**
     * <p  color=yellow>日期格式:yyyy-MM</p>
     */
    public static final String DATE_FORMAT_HYPHEN_YM ="yyyy-MM";
    /**
     * <p  color=yellow>日期格式:yyyy-MM-dd</p>
     */
    public static final String DATE_FORMAT_HYPHEN_YMD ="yyyy-MM-dd";

    //-------数字
    /**
     * <p  color=yellow>身份证号码长度15</p>
     */
    public static final Integer ID_CARD_LENGTH15 =15;
    /**
     * <p  color=yellow>身份证号码长度18</p>
     */
    public static final Integer ID_CARD_LENGTH18=18;


    //-------特殊符号
    /**
     * <p  color=yellow>空字符串</p>
     */
    public static final String SPECIAL_EMPTY = "";
    /**
     * <p  color=yellow>空花括号</p>
     */
    public static final String SPECIAL_EMPTY_JSON = "{}";
    /**
     * <p  color=yellow>下划线</p>
     */
    public static final String SPECIAL_UNDERLINE = "_";
    /**
     * <p  color=yellow>反斜杠</p>
     */
    public static final String SPECIAL_BACKSLASH = "\\";
    /**
     * <p  color=yellow>char类型：下划线</p>
     */
    public static final char CHAR_UNDERLINE = '_';
    /**
     * <p  color=yellow>char类型：反斜杠</p>
     */
    public static final char CHAR_BACKSLASH = '\\';
    /**
     * <p  color=yellow>char类型：左花括号</p>
     */
    public static final char CHAR_DELIM_START = '{';
    /**
     * <p  color=yellow>char类型：右花括号</p>
     */
    public static final char CHAR_DELIM_END = '}';
    //------字符串
    /**
     * 随机码
     */
    public static final String STRING_RANDOM_CODE ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
}
