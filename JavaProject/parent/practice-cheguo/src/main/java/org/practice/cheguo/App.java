package org.practice.cheguo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try {

			// Date now = new Date();
			// System.out.println(now);
			//
			// getYearMonthDay();
			// List<String> payDate = getMonthBetween("2017-01", "2018-02");
			// List<String> payDate2 = getMonthList("2017-01", "2018-02");
			// int a = 100 * 100;

			tuomin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getYearMonthDay() {
		JSONObject contractObj = new JSONObject();
		contractObj.put("7", Calendar.getInstance().get(Calendar.YEAR));
		contractObj.put("8", Calendar.getInstance().get(Calendar.MONTH) + 1);
		contractObj.put("9", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		System.out.println(contractObj.toJSONString());
		return contractObj.toJSONString();
	}

	private static void tuomin() {
		String phone = "18668161992";
		String idCard = "342501199111122014";
		String bankCardNo1 = "6226621702371731";
		String bankCardNo = "6228481990677155518";

		String resultPhone = CommonUtils.encode(phone, 1);
		String resultId = CommonUtils.encode(idCard, 2);
		String resultBankCard = CommonUtils.encode(bankCardNo1, 3);

		System.out.println(resultPhone);
		System.out.println(resultId);
		System.out.println(resultBankCard);
	}

}
