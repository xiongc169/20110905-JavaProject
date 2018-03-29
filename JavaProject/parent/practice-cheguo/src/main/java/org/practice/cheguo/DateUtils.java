package org.practice.cheguo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author yoong
 *
 */
public class DateUtils {

	/**
	 * https://www.cnblogs.com/endtel/p/6018429.html
	 */
	public static void format() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(new Date());
		System.out.println(now);

		String serial = org.apache.commons.lang.StringUtils.leftPad(String.valueOf(1), 4, '0');
		System.out.println(serial);
	}

	public static List<String> getMonthList(String monthBegin, String monthEnd) throws ParseException {
		List<String> payDate = new ArrayList<String>();
		Date monthBeginDate = new SimpleDateFormat("yyyy-MM").parse(monthBegin);// 定义起始日期
		Date monthEndDate = new SimpleDateFormat("yyyy-MM").parse(monthEnd);// 定义结束日期

		Calendar dd = Calendar.getInstance();// 定义日期实例

		dd.setTime(monthBeginDate);// 设置日期起始时间

		while (dd.getTime().before(monthEndDate)) {// 判断是否到结束日期

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

			String str = sdf.format(dd.getTime());

			System.out.println(str);// 输出日期结果

			dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
			payDate.add(str);

		}
		return payDate;
	}

	/**
	 * https://www.cnblogs.com/zq-boke/p/5868254.html
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}

		return result;
	}
}
