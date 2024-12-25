package com.common.util;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.common.constants.CommonConstant;
import com.common.string.Convert;
import com.google.common.base.Strings;
import org.springframework.util.AntPathMatcher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 字符串工具类
 * @author Administrator
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     *                * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || CommonConstant.SPECIAL_EMPTY.equals(str.trim());
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否是数组类型（Java基本型别的数组）
     *
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object) {
        return isNotNull(object) && object.getClass().isArray();
    }
    /**
     * 判断是否 JSONObject格式 字符串
     * @param str 字符串
     * @return boolean
     */
    public static boolean isJsonStr(String str){
        if(isEmpty(str)){
            return false;
        }
        try {
            JSON.parseObject(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否 JSONArray格式 字符串
     * @param str 字符串
     * @return boolean
     */
    public static boolean isJsonArrayStr(String str){
        if(isEmpty(str)){
            return false;
        }
        try {
            JSONArray.parseArray(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 补充字符串
     * @param mainStr   主字符串
     * @param addChar   需要补充的字符
     * @param maxLength 最大长度
     * @param pre       true前补充 false后补充
     * @return String
     */
    public static String addCharForStr(String mainStr, String addChar, int maxLength, boolean pre){
        if(isEmpty(mainStr)){
            return null;
        }
        int len = mainStr.length();

        if(maxLength > len){
            StringBuilder mainStrBuilder = new StringBuilder(mainStr);
            while(maxLength > mainStrBuilder.length()){
                if(pre) {
                    mainStrBuilder.insert(0, addChar);
                }else{
                    mainStrBuilder.append(addChar);
                }
            }
            mainStr = mainStrBuilder.toString();
        }

        return mainStr;
    }


    /**
     * 字符串去空格
     * @param str 字符串
     * @return String
     */
    public static String trim(String str) {
        return (str == null ? CommonConstant.SPECIAL_EMPTY : str.trim());
    }

    /**
     * 对象去空格
     * @param obj 类数据
     */
    public static void nto(Object obj) {
        if(obj==null || CommonConstant.SPECIAL_EMPTY.equals(obj)){
            return;
        }
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() != String.class) {
                    // 如果不是字符型
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, trim(String.valueOf(field.get(obj))));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象数组去空格
     * @param vbs 类数组
     */
    public static void ntoS(Object[] vbs) {
        if(vbs==null || vbs.length<1 || vbs[0]==null){
            return;
        }
        try {
            Field[] fields = vbs[0].getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() != String.class) {
                    // 如果不是字符型
                    continue;
                }
                field.setAccessible(true);
                for (Object vb : vbs) {
                    field.set(vb, trim(String.valueOf(field.get(vb))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return CommonConstant.SPECIAL_EMPTY;
        }
        if (start < 0) {
            start = str.length() + start;
        }
        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return CommonConstant.SPECIAL_EMPTY;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @param end   结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return CommonConstant.SPECIAL_EMPTY;
        }

        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return CommonConstant.SPECIAL_EMPTY;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 判断是否为空，并且不是空白字符
     *
     * @param str 要判断的value
     * @return 结果
     */
    public static boolean hasText(String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    /**
     * 格式化字符串<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param strPattern 字符串模板
     * @param argArray   参数列表
     * @return 结果
     */
    public static String format(final String strPattern, final Object... argArray) {
        boolean b=(strPattern == null || CommonConstant.SPECIAL_EMPTY.equals(strPattern.trim())) || (argArray == null || argArray.length == 0);
        if (b) {
            return strPattern;
        }
        final int strPatternLength = strPattern.length();

        // 初始化定义好的长度以获得更好的性能
        StringBuilder sb = new StringBuilder(strPatternLength + 50);

        int handledPosition = 0;
        int delimIndex;// 占位符所在位置
        for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
            delimIndex = strPattern.indexOf(CommonConstant.SPECIAL_EMPTY_JSON, handledPosition);
            if (delimIndex == -1) {
                if (handledPosition == 0) {
                    return strPattern;
                } else { // 字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
                    sb.append(strPattern, handledPosition, strPatternLength);
                    return sb.toString();
                }
            } else {
                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == CommonConstant.CHAR_BACKSLASH) {
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == CommonConstant.CHAR_BACKSLASH) {
                        // 转义符之前还有一个转义符，占位符依旧有效
                        sb.append(strPattern, handledPosition, delimIndex - 1);
                        sb.append(Convert.utf8Str(argArray[argIndex]));
                        handledPosition = delimIndex + 2;
                    } else {
                        // 占位符被转义
                        argIndex--;
                        sb.append(strPattern, handledPosition, delimIndex - 1);
                        sb.append(CommonConstant.CHAR_DELIM_START);
                        handledPosition = delimIndex + 1;
                    }
                } else {
                    // 正常占位符
                    sb.append(strPattern, handledPosition, delimIndex);
                    sb.append(Convert.utf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + 2;
                }
            }
        }
        // 加入最后一个占位符后所有的字符
        sb.append(strPattern, handledPosition, strPattern.length());

        return sb.toString();
    }
    /**
     * 是否为http(s)://开头
     *
     * @param link 链接
     * @return 结果
     */
    public static boolean isHttp(String link) {
        return StringUtils.startsWithAny(link, "http://", "https://");
    }

    /**
     * 驼峰转下划线命名
     */
    public static String toUnderScoreCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase;
        // 当前字符是否大写
        boolean currentCharIsUpperCase;
        // 下一字符是否大写
        boolean nextCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i > 0) {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            } else {
                preCharIsUpperCase = false;
            }

            currentCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1)) {
                nextCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && currentCharIsUpperCase && !nextCharIsUpperCase) {
                sb.append(CommonConstant.CHAR_UNDERLINE);
            } else{
                boolean b = (i != 0 && !preCharIsUpperCase) && currentCharIsUpperCase;
                if(b){
                    sb.append(CommonConstant.CHAR_UNDERLINE);
                }
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param stars 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... stars) {
        if (str != null && stars != null) {
            for (String s : stars) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return CommonConstant.SPECIAL_EMPTY;
        } else if (!name.contains(CommonConstant.SPECIAL_UNDERLINE)) {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split(CommonConstant.SPECIAL_UNDERLINE);
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 驼峰式命名法 例如：user_name->userName
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == CommonConstant.CHAR_UNDERLINE) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 查找指定字符串是否匹配指定字符串列表中的任意一个字符串
     *
     * @param str  指定字符串
     * @param stars 需要检查的字符串数组
     * @return 是否匹配
     */
    public static boolean matches(String str, List<String> stars) {
        if (isEmpty(str) || isEmpty(stars)) {
            return false;
        }
        for (String pattern : stars) {
            if (isMatch(pattern, str)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 获取objs的对应的字段的值
     * @param removal 是否去重，去重的同时，会把null给移除掉
     */
    public static List<String> getFieldValue(List<?> objs, String field, boolean removal) throws Exception {
        List<String> list = new ArrayList<>();
        if(objs!=null && objs.size()>0 && isNotEmpty(field)){
            Class<?> clazz = objs.get(0).getClass();
            String getName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
            Method getter = clazz.getMethod(getName, (Class<?>) null);
            for (Object obj : objs) {
                list.add((String) getter.invoke(obj));
            }
        }
        if(removal){
            Set<String> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
            set.clear();
            list.remove(null);
        }
        return list;
    }
    /**
     * 判断url是否与规则配置:
     * ? 表示单个字符;
     * * 表示一层路径内的任意字符串，不可跨层级;
     * ** 表示任意层路径;
     *
     * @param pattern 匹配规则
     * @param url     需要匹配的url
     * @return 是否匹配
     */
    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    /**
     * 数字左边补齐0，使之达到指定长度。注意，如果数字转换为字符串后，长度大于size，则只保留 最后size个字符。
     *
     * @param num  数字对象
     * @param size 字符串指定长度
     * @return 返回数字的字符串格式，该字符串为指定长度。
     */
    public static String pads(final Number num, final int size) {
        return pads(num.toString(), size, '0');
    }

    /**
     * 字符串左补齐。如果原始字符串s长度大于size，则只保留最后size个字符。
     *
     * @param s    原始字符串
     * @param size 字符串指定长度
     * @param c    用于补齐的字符
     * @return 返回指定长度的字符串，由原字符串左补齐或截取得到。
     */
    public static String pads(final String s, final int size, final char c) {
        final StringBuilder sb = new StringBuilder(size);
        if (s != null) {
            final int len = s.length();
            if (s.length() <= size) {
                for (int i = size - len; i > 0; i--) {
                    sb.append(c);
                }
                sb.append(s);
            } else {
                return s.substring(len - size, len);
            }
        } else {
            for (int i = size; i > 0; i--) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 字符串转换函数 （参照 Oracle decode 函数使用）
     * 示例1：参数（sourceStr） 返回 sourceStr
     * 示例2：参数（sourceStr,else_str） sourceStr为空，返回""，不为空，返回 else_str
     * 示例3：参数（sourceStr,Key_str1,value_str1） sourceStr为空，返回""，不为空，如果 sourceStr等于Key_str1 返回 value_str1 否则返回 sourceStr
     * 示例4：参数（sourceStr,Key_str1,value_str1,else_str） sourceStr为空，返回""，不为空，如果 sourceStr等于Key_str1 返回 value_str1 否则返回 else_str
     * @param sourceStr 源字符串
     * @param strings 转换对应关系
     * @return 返回值
     */
    public static String decodeStr(String sourceStr,String ...strings){
        int incremental =2;
        if((sourceStr == null) || (sourceStr.length() == 0) || (CommonConstant.SPECIAL_EMPTY.equals(sourceStr.trim()))) {
            return CommonConstant.SPECIAL_EMPTY;
        }
        int len = strings.length-1;
        for (int i = 0;i<len;i = i+incremental){
            if(sourceStr.equals(strings[i])){
                return strings[++i];
            }
        }
        return len%2==0?strings[len]:sourceStr;
    }

    /**
     * 返回文件名
     *
     * @param filePath 文件
     * @return 文件名
     */
    public static String getFileName(String filePath) {
        if (null == filePath) {
            return null;
        }
        int len = filePath.length();
        if (0 == len) {
            return filePath;
        }
        if (isFileSeparator(filePath.charAt(len - 1))) {
            // 以分隔符结尾的去掉结尾分隔符
            len--;
        }

        int begin = 0;
        char c;
        for (int i = len - 1; i > -1; i--) {
            c = filePath.charAt(i);
            if (isFileSeparator(c)) {
                // 查找最后一个路径分隔符（/或者\）
                begin = i + 1;
                break;
            }
        }

        return filePath.substring(begin, len);
    }

    public static boolean isFileSeparator(char c) {
        return '/' == c || '\\' == c;
    }

    /**
     * 描述：  <b color=yellow>姓名脱敏</b>
     *
     * @param fullName 需要脱敏的字段项
     * @author Asahi
     */
    public static String desensitizedName(String fullName) {
        if (!Strings.isNullOrEmpty(fullName)) {
            return StringUtils.rightPad(StringUtils.left(fullName, 1), StringUtils.length(fullName), "*");
        }
        return fullName;
    }

    /**
     * 描述：  <b color=yellow>手机号脱敏</b>
     *
     * @param phoneNumber 需要脱敏的字段项
     * @author Asahi
     */
    public static String desensitizedPhoneNumber(String phoneNumber) {
        if (!Strings.isNullOrEmpty(phoneNumber)) {
            return phoneNumber.replaceAll("(\\w{3})\\w*(\\w{4})", "$1****$2");
        }
        return phoneNumber;
    }

    /**
     * 描述：  <b color=yellow>身份证号脱敏</b>
     *
     * @param idNumber 需要脱敏的字段项
     * @author Asahi
     */
    public static String desensitizedIdNumber(String idNumber) {
        if (!Strings.isNullOrEmpty(idNumber)) {
            if (idNumber.length() ==CommonConstant.ID_CARD_LENGTH15) {
                idNumber = idNumber.replaceAll("(\\w{6})\\w*(\\w{3})", "$1******$2");
            }
            if (idNumber.length() == CommonConstant.ID_CARD_LENGTH18) {
                idNumber = idNumber.replaceAll("(\\w{6})\\w*(\\w{3})", "$1*********$2");
            }
        }
        return idNumber;
    }

    /**
     * 描述：  <b color=yellow>邮箱脱敏</b>
     *
     * @param email 需要脱敏的字段项
     * @author Asahi
     */
    public static String desensitizedEmail(String email) {
        if (!Strings.isNullOrEmpty(email)) {
            return email.replaceAll("(^\\w)[^@]*(@.*$)", "$1****$2");
        }
        return email;
    }

    /**
     * 描述：  <b color=yellow>生成maxLength位随机码</b>
     * @param maxLength 随机码位数
     * @return java.lang.String
     * @author jiangshuai
     */
    public static String makeRandomCode(int maxLength) {
        if(maxLength <=0){
            maxLength=1;
        }
        char[] chars = CommonConstant.STRING_RANDOM_CODE.toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < maxLength; ++x) {
            sb.append(chars[r.nextInt(chars.length)]);
        }
        return sb.toString();
    }
    /**
     * 判断是否是数字，通过 Integer.parseInt(str) 是否抛出错误与否来判定的，注意Integer上限 2147483647
     */
    public static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * 判断是否是数字，通过 Long.parseLong(str) 是否抛出错误与否来判定的
     */
    public static boolean isNumber2(String str){
        try {
            Long.parseLong(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * 描述：  <b color=yellow>删除文本的图片标签</b>
     * @return java.lang.String
     * @author jiangshuai
     */
    public static String removerTextPic(String content) {
        return content.replaceAll("<img[^>]*>", CommonConstant.SPECIAL_EMPTY);
    }
}
