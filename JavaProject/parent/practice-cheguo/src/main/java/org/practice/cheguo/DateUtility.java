package org.practice.cheguo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * https://www.cnblogs.com/endtel/p/6018429.html
 * 
 * @author 20180112002
 *
 */
public class DateUtility {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(new Date());
		System.out.println(now);
	}
}
