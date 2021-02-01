package com.yoong.thread;

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

    public static void interrupt1402() throws Exception {
        //获取中断状态，非静态方法，不会清除线程的中断状态
        Boolean isInterrupted = Thread.currentThread().isInterrupted();
        System.out.println(isInterrupted);//初始为：false
        //中断方法，将中断状态置为true
        Thread.currentThread().interrupt();
        Boolean isInterrupted02 = Thread.currentThread().isInterrupted();
        System.out.println(isInterrupted02);//被中断，变为：true

        //获取中断状态，静态方法，而且会清除线程的中断状态
        boolean interrupted = Thread.interrupted();
        System.out.println(interrupted);///被中断，变为：true，且重置中断状态
        Boolean isInterrupted03 = Thread.currentThread().isInterrupted();
        System.out.println(isInterrupted03);//中断状态被重置为：false

        //新建线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!Thread.currentThread().isInterrupted()) {
                        System.out.println("线程未被中断：" + Thread.currentThread().isInterrupted());
                    } else {
                        System.out.println("        线程被中断：" + Thread.currentThread().isInterrupted());
                        return;
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    public static void status1403() throws Throwable {
        Thread.State state = Thread.currentThread().getState();
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
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        int num = 100;
        for (int i = 0; i < num; i++) {
            //key 0、key 11会冲突，hashmap.table[12]处存储
            concurrentHashMap.put("key " + i, "value " + i);
        }
        for (Map.Entry<String, String> item : concurrentHashMap.entrySet()) {
            System.out.println(item.getKey() + "：" + item.getValue());
        }

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
