package com.yoong.weimai;

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
            //生成二维码
            //QRCodeUtils.QREncode();

            byte aa = 1;
            int bb = 1;
            System.out.println(aa == bb);//true
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
