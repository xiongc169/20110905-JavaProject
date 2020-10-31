package org.practice.thread.thread02.ch05notify;

/**
 * @Desc Java并发编程：线程间协作的两种方式：wait、notify、notifyAll和Condition
 * http://www.cnblogs.com/dolphin0520/p/3920385.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppNotify {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Object obj = new Object();

            WaitTask wait = new WaitTask(obj);
            Thread waitThread = new Thread(wait);
            waitThread.start();

            Thread.sleep(3000);

            NotifyTask notify = new NotifyTask(obj);
            Thread notifyThread = new Thread(notify);
            notifyThread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
