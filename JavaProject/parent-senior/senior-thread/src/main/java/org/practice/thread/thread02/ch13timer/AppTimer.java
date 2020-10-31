package org.practice.thread.thread02.ch13timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Desc Java并发编程：Timer和TimerTask（转载）
 * http://www.cnblogs.com/dolphin0520/p/3938991.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppTimer {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            timerTest();
            multiThread();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Timer的调度方法比较
     * PS：timer.schedule(timeTask, 3000, 4000); schedule在计算下一次执行的时间的时候，是通过当前时间（在任务执行前得到） + 时间片；
     * timer.scheduleAtFixedRate(timeTask, 3000, 1000); scheduleAtFixedRate方法是通过当前需要执行的时间（也就是计算出现在应该执行的时间）+ 时间片；
     * 前者是运行的实际时间，而后者是理论时间点。前者可能由于CPU被征用，出现少调度一次或多次的情况，后者可以减少遗漏调度；
     */
    private static void timerTest() {
        System.out.println(format.format(new Date()) + " TimerApp.timerTest Start....");

        Timer timer = new Timer();
        MyTimeTask timeTask1 = new MyTimeTask();
        MyTimeTask timeTask2 = new MyTimeTask();
        MyTimeTask timeTask3 = new MyTimeTask();
        MyTimeTask timeTask4 = new MyTimeTask();
        MyTimeTask timeTask5 = new MyTimeTask();
        MyTimeTask timeTask6 = new MyTimeTask();

        //延时delay执行一次
        timer.schedule(timeTask1, 3000);
        //在指定时间点new Date()上执行一次
        timer.schedule(timeTask2, new Date());

        //延时delay执行，执行完成后等待period再执行
        timer.schedule(timeTask3, 3000, 4000);
        //在指定时间点new Date()上执行，执行完成后等待period再执行
        timer.schedule(timeTask4, new Date(), 4000);

        //调度一个task，在delay(ms)后开始调度，然后每经过period(ms)再次调度
        timer.scheduleAtFixedRate(timeTask5, 3000, 4000);
        //调度一个task，在指定时间点new Date()开始调度，然后每经过period(ms)再次调度
        timer.scheduleAtFixedRate(timeTask6, new Date(), 4000);

        System.out.println(format.format(new Date()) + " TimerApp.timerTest End!");

    }

    /**
     * Timer+TimeTask的多线程实现
     */
    private static void multiThread() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        ExecutorService executor2 = Executors.unconfigurableScheduledExecutorService(executor);
    }

}
