package com.yoong.junior.community.utility;

/**
 * @Desc stock helper
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-07-29 14:33:28
 * <p>
 * @Version 1.0
 */
public class StockUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
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
     * @param price 當前價
     * @param count 漲停次數
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
