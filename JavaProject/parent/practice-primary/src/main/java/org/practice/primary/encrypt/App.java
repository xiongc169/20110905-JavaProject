package org.practice.primary.encrypt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class App {

	public static void main(String[] args) {

		descTest();
		getTimestamp();

	}

	public static void descTest() {
		try {

			// 20171019：i=事件Id、n=事件编号、c=客户编号、k=加密串、u=时间
			String strKey = "a1508727422299cd";// 长度要求16位
			String eventId = "201711022053495460671765";
			String eventNo = "SJ201711020092";
			String customerId = "201605201416001000002467";
			byte[] strKeyBytes = DesUtil.hex2byte(strKey);
			String i = DesUtil.encrypt(eventId, strKeyBytes);
			String n = DesUtil.encrypt(eventNo, strKeyBytes);
			String c = DesUtil.encrypt(customerId, strKeyBytes);
			System.out.println(i);
			System.out.println(n);
			System.out.println(c);

			String eventIdCipher = "2D7491D4115FE4748707366F8428768BC10FC834C53B0DB9E8199D8FC5C53FC0";
			String eventNoCipher = "AFAC14427B05107D65584F74818C9153";
			String customerIdCipher = "F3B25A15C2171FA47815B67242C18C6C1B09F645C1E9B20FE8199D8FC5C53FC0";
			System.out.println("eventId: " + DesUtil.decrypt(eventIdCipher, strKeyBytes));
			System.out.println("eventNo: " + DesUtil.decrypt(eventNoCipher, strKeyBytes));
			System.out.println("customerId: " + DesUtil.decrypt(customerIdCipher, strKeyBytes));

		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
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
