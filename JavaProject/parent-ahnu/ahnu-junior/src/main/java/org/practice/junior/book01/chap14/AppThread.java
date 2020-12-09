package org.practice.junior.book01.chap14;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Desc 《Java核心技术·卷1》第十四章、多线程
 * PS：线程如何返回值； 线程结束如何回调； 线程间如何通信； 线程间共享变量； 线程安全；
 * https://www.jb51.net/books/227644.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppThread {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            interrupt1402();
            status1403();
            property1404();
            blockingQueue1406();
            concurrentCollection1407();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (Error error) {
            error.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void interrupt1402() {
        //中断方法
        Thread.currentThread().interrupt();
        //获取中断状态，静态方法，而且会清除线程的中断状态
        boolean interrupted = Thread.interrupted();
        //获取中断状态，非静态方法，不会清除线程的中断状态
        Thread thread = new Thread();
        boolean isInterrupted = thread.isInterrupted();
        //新建线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static void status1403() throws Throwable {
        //New 新建状态
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
                //throw new FileNotFoundException(); //线程体不能抛出任何被检测的异常
                throw new NullPointerException(); //但不被检测的异常会导致线程终止；
            }
        });
        //Runnable 可运行状态
        thread.start();
        //Blocked 被阻塞状态；执行操作时被阻塞，等待操作完成即可
        //Waiting 等待状态；等待被其他线程唤醒
        thread.wait();
    }

    public static void property1404() {
    }

    /**
     * 14.6、阻塞队列 (P665)
     */
    public static void blockingQueue1406() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        DelayQueue delayQueue = new DelayQueue();
        TransferQueue transferQueue = new LinkedTransferQueue();
    }

    /**
     * 14.7、线程安全的集合 (P672)
     */
    public static void concurrentCollection1407() {
        // 14.7.1、高效的映射表、集合、队列
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentHashMap.put(1, "eva huang");

        // 14.7.2、写数组的拷贝
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        // 14.7.3、较早的线程安全集合
        Vector vector = new Vector();
        Hashtable hashtable = new Hashtable();
        List<Integer> syncArrayList = Collections.synchronizedList(new ArrayList<>());
        Map<Integer, String> syncHashMap = Collections.synchronizedMap(new HashMap<>());
    }
}