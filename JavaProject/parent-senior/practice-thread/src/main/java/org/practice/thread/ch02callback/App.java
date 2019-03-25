package org.practice.thread.ch02callback;

/**
 * @author yoong
 * <br>
 * @desc 线程的创建
 * PS：取得线程执行的结果，回调方式
 * http://www.blogjava.net/junglesong/archive/2008/02/22/181356.html
 * <br>
 * @date 2019/1/11 10:19
 */
public class App {
    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            callBackTest();
            lambdaThread();
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

    /**
     * Lambda方式创建线程
     * http://www.threadworld.cn/archives/68.html
     */
    public static void lambdaThread() {
        System.out.println("lambdaThread: " + Thread.currentThread().getName());
        Runnable runnable = () -> {
            System.out.println("lambdaThread.runnable: " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
