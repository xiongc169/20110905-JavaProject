package com.yoong.thread.thread01.ch02callback;

/**
 * @Desc 线程的创建
 * PS：取得线程执行的结果，回调方式
 * http://www.blogjava.net/junglesong/archive/2008/02/22/181356.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/11 10:19
 * <p>
 * @Version 1.0
 */
public class AppCallback {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            callBackTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 回调方式获取线程的执行结果
     */
    public static void callBackTest() {
        System.out.println("callBackTest Start...");
        Boss boss = new Boss("yoong");
        Secretary secretary = new Secretary(boss);
        Thread thread = new Thread(secretary);
        thread.start();
        System.out.println("callBackTest End!");
    }
}
