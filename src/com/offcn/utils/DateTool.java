package com.offcn.utils;
/**
 * 日期转换工具类
 * @author admin
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 字符串转日期
	 */
	public static Date  stringToDate(String string) {
		try {
			Date date = sdf.parse(string);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 日期转字符串
	 */
	public static String dateToString(Date date) {
		String string = sdf.format(date);
		return string;
	}
}
