package com.common.helper;


import com.common.constants.CommonConstant;
import com.common.enumeration.SexEnum;
import com.common.util.DateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 身份证号码工具类
 * Date: 2021/7/27
 * Time: 11:41
 * Description: [  IDCardHelper工具类  ]
 * @author Administrator
 */
public  class IDCardHelper {

	/**
	* 功能描述：[  校验身份证是否合法  ]
	* @ Author：jiangshuai
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
			if (idNumber.length() == CommonConstant.ID_CARD_LENGTH18) {
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
					return idCardY[idCardMod].equalsIgnoreCase(String.valueOf(idCardLast));

				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}

		}
		return matches;
	}

	/**
	 * 根据身份证号码得到性别
	 * @param sfzhm
	 * @return
	 */
	public static String getSexCode(String sfzhm) {
		if (sfzhm != null && sfzhm.length() == 18) {
			return Integer.parseInt(sfzhm.substring(16, 17)) % 2 == 0 ? SexEnum.woman.getSexCode() : SexEnum.man.getSexCode();
		} else {
			return "";
		}
	}

	/**
	 * 根据身份证号码得到性别名称
	 * @param sfzhm
	 * @return
	 */
	public static String getSexName(String sfzhm) {
		String sexCode = getSexCode(sfzhm);
		if (sexCode != null && !"".equals(sexCode.trim())) {
			if ("1".equals(sexCode.trim())) {
				return "男";
			}
			if ("2".equals(sexCode.trim())) {
				return "女";
			}
		}
		return "";
	}

	/**
	 * 根据身份证号码得到出生年月
	 * @param IdCard
	 * @return
	 */
	public static String getBirthday(String IdCard) {
		return IdCard != null && IdCard.length() == CommonConstant.ID_CARD_LENGTH18 ?
				DateHelper.dateStrFormat(IdCard.substring(6, 12), CommonConstant.DATE_FORMAT_YM, CommonConstant.DATE_FORMAT_HYPHEN_YM) : "";
	}

	/**
	 * 根据身份证号码得到出生日期
	 * @param IdCard 需要计算的身份证号码
	 * @return 返回出生日期date对象
	 */
	public static Date getBirthdayDate(String IdCard) {
		if(IdCard == null || IdCard.length() != CommonConstant.ID_CARD_LENGTH18){
			return null;
		}
		String birthDayStr=IdCard.substring(6, 14);
		LocalDate localDate = LocalDate.parse(birthDayStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
		return DateUtils.transferLocalDateToDate(localDate);
	}

	/**
	 * 功能描述：[  根据身份证号码，计算当前年龄  ]
	 * @Author：jiangshuai
	 * @Datetime： 2021/6/28 10:50
	 */
	public static String evaluate(String IdCard) {
		if (IdCard == null || "".equals(IdCard)) {
			return "0";
		}
		if (IdCard.length() != CommonConstant.ID_CARD_LENGTH15 && IdCard.length() != CommonConstant.ID_CARD_LENGTH18) {
			return "0";
		}
		String age;
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayNow = cal.get(Calendar.DATE);

		int year = Integer.parseInt(IdCard.substring(6, 10));
		int month = Integer.parseInt(IdCard.substring(10, 12));
		int day = Integer.parseInt(IdCard.substring(12, 14));
		boolean flag=(month < monthNow) || (month == monthNow && day <= dayNow);
		if (flag) {
			age = String.valueOf(yearNow - year);
		} else {
			age = String.valueOf(yearNow - year - 1);
		}

		return age;
	}



}
