package org.practice.junior.book01.chap14.thread02.ch11phaser;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc 并发工具Phaser、Exchanger使用
 * PS：Phaser，JDK1.7提供的一种同步工具，是可重用的同步屏障。
 * Exchanger，作用是交换两个线程的数据。
 * https://blog.csdn.net/Baisitao_/article/details/103841520
 * https://blog.csdn.net/tanhongwei1994/article/details/102564485
 * https://www.cnblogs.com/lujiango/p/7581039.html
 * https://www.cnblogs.com/jinggod/p/8494624.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppPhaser {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            phaserDemo();
            exchangeDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void phaserDemo() {
        int threadCount = 6;
        PartyPhaser partyPhaser = new PartyPhaser();
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        // 批量注册
        partyPhaser.bulkRegister(threadCount);
        for (int i = 0; i < threadCount; i++) {
            service.submit(new Person("p" + i, partyPhaser));
        }
        // 关闭线程池
        service.shutdown();
    }


    public static void exchangeDemo() {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String exchangerData = "thread-1 data";
            try {
                exchangerData = exchanger.exchange(exchangerData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + exchangerData);
        }, "thread-1").start();

        new Thread(() -> {
            String exchangerData = "thread-2 data";
            try {
                exchangerData = exchanger.exchange(exchangerData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + exchangerData);
        }, "thread-2").start();
    }
}
