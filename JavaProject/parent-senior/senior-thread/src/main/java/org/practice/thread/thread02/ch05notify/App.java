package org.practice.thread.thread02.ch05notify;

/**
 * @author yoong
 * <br>
 * @desc Java并发编程：线程间协作的两种方式：wait、notify、notifyAll和Condition
 * http://www.cnblogs.com/dolphin0520/p/3920385.html
 * <br>
 * @date 2018年8月30日
 */
public class App {

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
