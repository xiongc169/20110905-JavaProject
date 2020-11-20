package org.practice.junior.book01.chap14.thread01.ch02control;

import org.practice.junior.book01.chap14.thread01.model.Person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Desc Java总结篇系列：Java多线程（二）
 * PS：Java多线程的阻塞状态与线程控制：阻塞、暂停、恢复、中断。
 * 三种阻塞状态：等待阻塞、同步阻塞、其他阻塞。
 * http://www.cnblogs.com/lwbqqyumidi/p/3817517.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppControl {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            controlTest(); //线程的暂停、恢复、中断
            interruptThread(); //线程的中断
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java多线程推荐使用的停止方法和暂停方法
     * PS：thread.suspend()、thread.resume()
     * http://www.cnblogs.com/lonecloud/p/5774246.html
     * 终止线程的三种方法
     * PS：退出标志位、thread.stop()、thread.interrupt()
     * https://blog.csdn.net/zhanjichun_2008/article/details/6612980
     */
    public static void controlTest() throws Exception {
        Integer sleepTime = 200;
        System.out.println(format.format(new Date()) + " controlTest Start...");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "Thread-1");
        thread.start();
        System.out.println(format.format(new Date()) + " thread.start...");
        TimeUnit.MILLISECONDS.sleep(sleepTime);

        //暂停线程
        System.out.println(format.format(new Date()) + " thread.suspend...");
        thread.suspend();
        TimeUnit.MILLISECONDS.sleep(sleepTime);

        //继续线程
        System.out.println(format.format(new Date()) + " thread.resume...");
        thread.resume();
        TimeUnit.MILLISECONDS.sleep(sleepTime);

        //中断线程(若线程处于sleep状态，中断会使其抛异常)
        System.out.println(format.format(new Date()) + " thread.interrupt...");
        myRunnable.exit = true;
        //thread.stop();
        //thread.interrupt();
    }

    /**
     * 多线程 interrupt()，isInterrupted()，interrupted()
     * PS：线程中断
     * https://www.cnblogs.com/lujiango/p/7641983.html
     */
    public static void interruptThread() throws InterruptedException {
        Person person = new Person("yoong", 25, 25);
        MyThread thread = new MyThread(person);
        thread.start();
        //中断线程1
        boolean interrupted = Thread.interrupted();//静态方法，查看Main线程的中断状态——未中断 false，注意：中断状态会被清除(即重置为false)
        System.out.println("Thread.interrupted(): " + interrupted);
        boolean isInterrupted = thread.isInterrupted();//非静态方法，查看子线程的中断状态——未中断 false
        System.out.println("thread.isInterrupted(): " + isInterrupted);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断线程2
        thread.interrupt();//中断子线程
        boolean interrupted2 = Thread.interrupted();//静态方法，查看Main线程的中断状态——未中断 false
        System.out.println("Thread.interrupted() 2: " + interrupted2);
        boolean isInterrupted2 = thread.isInterrupted();//非静态方法，查看子线程的中断状态——已中断 true
        System.out.println("thread.isInterrupted() 2: " + isInterrupted2);

        //中断线程3
        Thread.currentThread().interrupt();//中断当前线程，即Main线程
        boolean interrupted3 = Thread.interrupted();//静态方法，查看当前线程的中断状态——已中断 true
        System.out.println("Thread.interrupted() 3: " + interrupted3);
    }
}
