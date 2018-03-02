package org.practice.primary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.practice.primary.domain.Dictionary;
import org.practice.primary.encrypt.DesUtil;

public class App {

	public static void main(String[] args) {

		test();
	}

	public static void test() {
		int a = 0;

		Dictionary dict = new Dictionary();
		int hashCode = dict.hashCode();
		System.out.println("hashCode " + hashCode);

		Dictionary dict2 = new Dictionary("12", "12");
		int hashCode2 = dict2.hashCode();
		System.out.println("hashCode2 " + hashCode2);

		// CollectionUtility.setDistinct();
		System.out.println(a);
	}

	/**
	 * Java获取时间戳：http://tangmingjie2009.iteye.com/blog/1543166 <br>
	 * Java时间戳、时间转换：http://www.cnblogs.com/mstk/p/5511057.html <br>
	 * java生成时间戳，13位<br>
	 * .net生成时间戳，10位
	 */
	public static void getTimestamp() {

		// 获取时间戳
		long timestamp = System.currentTimeMillis();
		long timestamp2 = Calendar.getInstance().getTimeInMillis();
		long timestamp3 = new Date().getTime();
		System.out.println(timestamp);
		System.out.println(timestamp2);
		System.out.println(timestamp3);

		// 时间戳转换为时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timestamp4 = 1509004771699L;
		Date date = new Date(timestamp4);
		String dateStr = simpleDateFormat.format(date);
		System.out.println(dateStr);

	}

}
