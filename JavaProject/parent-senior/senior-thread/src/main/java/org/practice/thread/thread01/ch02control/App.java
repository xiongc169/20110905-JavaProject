package org.practice.thread.thread01.ch02control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yoong
 * <br>
 * @desc Java总结篇系列：Java多线程（二）
 *       PS：Java多线程的阻塞状态与线程控制
 *       http://www.cnblogs.com/lwbqqyumidi/p/3817517.html
 * <br>
 * @date 2019/1/11 10:19
 */
public class App {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            controlTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java多线程推荐使用的停止方法和暂停方法
     * http://www.cnblogs.com/lonecloud/p/5774246.html
     */
    public static void controlTest() throws Exception {
        System.out.println(format.format(new Date()) + " controlTest Start...");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "Thread-1");
        thread.start();
        System.out.println(format.format(new Date()) + " controlTest End!");

        //暂停线程
        TimeUnit.SECONDS.sleep(10);
        System.out.println(format.format(new Date()) + " thread.suspend...");
        thread.suspend();

        //继续线程
        TimeUnit.SECONDS.sleep(10);
        System.out.println(format.format(new Date()) + " thread.resume...");
        thread.resume();

        //中断线程(若线程处于sleep状态，中断会使其抛异常)
        TimeUnit.SECONDS.sleep(10);
        System.out.println(format.format(new Date()) + " thread.interrupt...");
    }
}
