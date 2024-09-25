package helper;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @Title StringHelper
 * @Author Administrator
 * @Description
 * @Date 2024/9/25 9:21
 * @Version 1.0
 **/
public class StringHelper {
    /**
     * 去对象空格，这个是不是也得修改一下啊？
     */
    public static void ntos(Object obj) {
        try {
            Class dataBeanClass = obj.getClass();
            Field[] dataBeanField = dataBeanClass.getDeclaredFields();
            // 参数名称
            String f_name;
            // 方法名称
            String m_name;
            // 方法
            Method gmethod;
            // 方法
            Method smethod;
            // 值
            String c_value;
            // 处理插入的结构列
            for (Field field : dataBeanField) {
                if (!(field.getType().equals("test".getClass()))) {
                    // 如果不是字符型
                    continue;
                }
                // 列名
                f_name = field.getName();
                // 得到该列的get方法
                m_name = "get" + Character.toUpperCase(f_name.charAt(0)) + f_name.substring(1);
                gmethod = obj.getClass().getMethod(m_name, (Class<?>) null);
                // 得到该列的get方法
                m_name = "set" + Character.toUpperCase(f_name.charAt(0)) + f_name.substring(1);
                smethod = obj.getClass().getMethod(m_name,
                        field.getType());
                // 取值
                c_value = (String) gmethod.invoke(obj, (Object) null);
                c_value = toTrim(c_value);
                // 符值
                smethod.invoke(obj, c_value);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void ntoN(Object[] vbs) {
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
                    field.set(vb, StringHelper.toTrim(String.valueOf(field.get(vb))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 去除字符串空格
     * @param str
     * @return String
     */
    public static String toTrim(String str) {
        if (str == null) {
            return "";
        } else {
            return "null".equalsIgnoreCase(str.trim()) ? "" : str.trim();
        }
    }

    /**
     * 计算给定时间多少个月之后的时间
     * @param date
     * @param month
     * @param pattern
     * @return String
     */
    public static String addMonth (String date,String pattern,int month){
        String nowDate = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date parse = format.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            calendar.add(Calendar.MONTH, month);
            nowDate = format.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nowDate;
    }


    /**
     * 功能描述：[  校验身份证是否合法  ]
     *
     * @ Author： Asahi~
     * @ Datetime： 2021/6/28 10:52
     */
    public static boolean isIdNumber(String idNumber) {
        if (idNumber == null || "".equals(idNumber)) {
            return false;
        }

        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）

        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾

        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = idNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {

            if (idNumber.length() == 18) {
                try {
                    char[] charArray = idNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    return idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase());

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }

        }
        return matches;
    }

    /**
     * 功能描述：[  根据身份证号码，计算当前年龄  ]
     *
     * @ Author： Asahi~
     * @ Datetime： 2021/6/28 10:50
     */
    public static String evaluate(String sfzjh) {

        if (sfzjh == null || "".equals(sfzjh)) {
            return "身份证件号有误,无法计算年龄";
        }

        if (sfzjh.length() != 15 && sfzjh.length() != 18) {
            return "身份证件号有误,无法计算年龄";
        }
        String age;
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DATE);

        int year = Integer.parseInt(sfzjh.substring(6, 10));
        int month = Integer.parseInt(sfzjh.substring(10, 12));
        int day = Integer.parseInt(sfzjh.substring(12, 14));
        boolean flag=(month < monthNow) || (month == monthNow && day <= dayNow);
        if (flag) {
            age = String.valueOf(yearNow - year);
        } else {
            age = String.valueOf(yearNow - year - 1);
        }

        return age;
    }

    /**
     * 功能描述：[  对比输入的月份和当前月份之间的查  ]
     *
     * @ Author： Asahi~
     * @ Datetime： 2021/6/24 13:34
     */
    public static String monthDifference(String maxMonth, String minMonth) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(maxMonth));
            aft.setTime(sdf.parse(minMonth));
            int results = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            return String.valueOf(Math.abs(month + results));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 功能描述：[  生成UUID主键  ]
     *
     * @ Author： Asahi~
     * @ Datetime： 2021/6/24 13:34
     */
    public static String getGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public static String generateCodeValue(String head) {
        DateFormat formater = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        StringBuilder sb = new StringBuilder(formater.format(new Date()));
        SecureRandom randow = new SecureRandom();
        StringBuilder strAm1 = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            strAm1.append(randow.nextInt(10));
        }
        return head + sb.append(strAm1).toString();
    }

    public static boolean isEmpty(String str) {
        return (str == null) || (str.length() == 0) || ("".equals(str.trim()));
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return "".equals(((String) obj).trim());
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
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
        if((sourceStr == null) || (sourceStr.length() == 0) || ("".equals(sourceStr.trim()))) {
            return "";
        }
        int len = strings.length-1;
        for (int i = 0;i<len;i = i+2){
            if(sourceStr.equals(strings[i])){
                return strings[++i];
            }
        }
        return len%2==0?strings[len]:sourceStr;
    }

    /**
     * 非空判断函数
     * @return 返回值
     */
    public static String ifNotNullHandler(String sourceStr, UnaryOperator<String> unaryOperator){
        if(isEmpty(sourceStr)){
            return sourceStr;
        }
        return unaryOperator.apply(sourceStr);
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
     * 获取objs的对应的字段的值
     * @param sfqc 是否去重，去重的同时，会把null给移除掉
     */
    public static List<String> getFieldValue(List<? extends Object> objs, String field, boolean sfqc) throws Exception {
        List<String> list = new ArrayList<String>();
        if(objs!=null && objs.size()>0 && StringHelper.isNotEmpty(field)){
            Class clazz = objs.get(0).getClass();
            String getName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
            Method getter = null;
            getter = clazz.getMethod(getName, (Class<?>) null);
            for (Object obj : objs) {
                list.add((String) getter.invoke(obj, (Object) null));
            }
        }
        if(sfqc){
            Set<String> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
            set.clear();
            list.remove(null);
        }
        return list;
    }

    /**
     * 判断是否 JSONObject格式 字符串
     * @param str
     * @return
     */
    public static boolean isJsonStr(String str){
        if(StringHelper.isEmpty(str)){
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
     * @param str
     * @return
     */
    public static boolean isJsonArrayStr(String str){
        if(StringHelper.isEmpty(str)){
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
     * @return
     */
    public static String addCharForStr(String mainStr, String addChar, int maxLength, boolean pre){
        if(StringHelper.isEmpty(mainStr)){
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
     * 返回长度为【strLength】的随机数，在前面补0
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }
}
