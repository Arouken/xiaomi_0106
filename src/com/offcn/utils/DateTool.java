package com.offcn.utils;
/**
 * ����ת��������
 * @author admin
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * �ַ���ת����
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
	 * ����ת�ַ���
	 */
	public static String dateToString(Date date) {
		String string = sdf.format(date);
		return string;
	}
}
