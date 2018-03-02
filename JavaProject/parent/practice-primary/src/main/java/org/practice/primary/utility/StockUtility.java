package org.practice.primary.utility;

/**
 * stock helper
 * 
 * @author chaoxiong
 * @since 2015-07-29 14:33:28
 *
 */
public class StockUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			double res = Calc(33.12, 5);
			System.out.println(res);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 計算漲停
	 * 
	 * @param 當前價
	 * @param 漲停次數
	 * @return
	 */
	public static double Calc(double price, int count) {
		if (count <= 0)
			return price;
		else {
			double addPrice = price * 0.1;
			count--;
			return Calc(addPrice + price, count);
		}
	}

	public static double Calc2(double price, int count) {
		for (int i = 0; i < count; i++) {
			double addPrice = price * 0.1;
			price = price + addPrice;
		}
		return price;
	}
}
