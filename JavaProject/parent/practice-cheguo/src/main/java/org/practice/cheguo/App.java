package org.practice.cheguo;

import org.practice.cheguo.utils.CommonUtils;

/**
 * 
 * @author yoong
 *
 */
public class App {
	public static void main(String[] args) {

		try {
			tuomin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * https://blog.csdn.net/sx729034738/article/details/69569055 <br>
	 * PS：java中的运算 ^, << , >>,&
	 */
	public static void left() {
		// 左移n位就相当于乘以2的n次方
		int a = 3 << 10;
		int b = 48 >> 2;
		System.out.println(a);
		System.out.println(b);
	}

	/**
	 * 脱敏
	 */
	public static void tuomin() {
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
