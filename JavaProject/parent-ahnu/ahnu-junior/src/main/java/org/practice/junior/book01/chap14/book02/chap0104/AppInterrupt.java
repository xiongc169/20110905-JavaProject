package org.practice.junior.book01.chap14.book02.chap0104;

import java.util.concurrent.TimeUnit;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：1.4、线程的中断
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppInterrupt {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        PrimeTask primeTask = new PrimeTask(1);
        Thread primeThread = new Thread(primeTask);
        primeThread.start();
        try {
            Thread.sleep(2000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        primeThread.interrupt();
        System.out.println("Main Ending");
    }
}
