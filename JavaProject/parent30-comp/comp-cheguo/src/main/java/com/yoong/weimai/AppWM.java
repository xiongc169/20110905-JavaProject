package com.yoong.weimai;

import com.yoong.weimai.form.followup.QRCodeUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Desc AppWM
 * <p>
 * @Author yoong
 * <p>
 * @Date 2021年4月26日
 * <p>
 * @Version 1.0
 */
public class AppWM {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            byteInt();
            bigDecimalTest();
            QRCodeUtils.QREncode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void byteInt() {
        byte a1 = 1;
        int b1 = 1;
        System.out.println(a1 == b1);//true

        Byte a2 = 1;
        System.out.println(a2.equals(1));//false
        System.out.println(a2.equals((byte) 1));//true
        System.out.println(a2 == 1);//true
    }

    /**
     * BigDecimal使用ROUND_HALF_UP进行四舍五入
     * PS：new BigDecimal(0.745)，使用参数为float、double创建BigDecimal对象会丢失精度。
     * 解决办法：使用 new BigDecimal("0.745")、BigDecimal.valueOf(0.745)。
     * https://blog.csdn.net/zongzhankui/article/details/79591294
     * 解释BigDecimal精度的坑
     * https://blog.csdn.net/gege87417376/article/details/79550749
     */
    public static void bigDecimalTest() {
        System.out.println(new BigDecimal(1.745)); // 1.74500000000000010658141036401502788066864013671875
        System.out.println(new BigDecimal(0.745)); // 0.74499999999999999555910790149937383830547332763671875
        System.out.println(new BigDecimal(1.745).setScale(2, RoundingMode.HALF_UP)); // 1.75
        System.out.println(new BigDecimal(0.745).setScale(2, RoundingMode.HALF_UP)); // 0.74

        System.out.println(BigDecimal.valueOf(1.745)); // 1.745
        System.out.println(BigDecimal.valueOf((0.745))); // 0.745
        System.out.println(BigDecimal.valueOf(1.745).setScale(2, RoundingMode.HALF_UP)); // 1.75
        System.out.println(BigDecimal.valueOf(0.745).setScale(2, RoundingMode.HALF_UP)); // 0.75

        System.out.println(new BigDecimal("1.745")); // 1.745
        System.out.println(new BigDecimal("0.745")); // 0.745
        System.out.println(new BigDecimal("1.745").setScale(2, RoundingMode.HALF_UP)); // 1.75
        System.out.println(new BigDecimal("0.745").setScale(2, RoundingMode.HALF_UP)); // 0.75
    }
}
