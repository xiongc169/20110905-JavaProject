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
    public static void blockingQueue1406() throws Exception {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();

        //DelayQueue，包含实现Delayed接口的对象。getDelay()方法返回对象的残留延迟。负值表示延迟已经结束。元素只有在延迟用完时，才能从DelayQueue移除。
        //还必须实现compareTo方法，DelayQueue 使用该方法对元素进行排序。
        DelayQueue delayQueue = new DelayQueue();
        Delayed delayed = new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 1;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        };
        delayQueue.add(delayed);
        Object delayResult01 = delayQueue.poll();
        Object delayResult02 = delayQueue.poll(6000, TimeUnit.MILLISECONDS);

        //TransferQueue接口，Java7新增的接口，允许生产者线程等待，直到消费者准备就绪可以接受一个元素。LinkedTransferQueue类实现了这个接口。
        Object transfer = new Object();
        TransferQueue transferQueue = new LinkedTransferQueue();
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000);
                Object transferResult01 = transferQueue.poll(6000, TimeUnit.MILLISECONDS);
                System.out.println(transferResult01);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.start();
        transferQueue.transfer(transfer);
        Object transferResult02 = transferQueue.poll();
        System.out.println(transferResult02);

        //SynchronousQueue是一种无界、无缓冲的阻塞队列，可以认为是缓存值为1的阻塞队列。SynchronousQueue的吞吐量高于LinkedBlockingQueue 和 ArrayBlockingQueue
        //SynchronousQueue阻塞队列的一个使用场景是在线程池里，Executors.newCachedThreadPool()就使用了SynchronousQueue
        SynchronousQueue synchronousQueue = new SynchronousQueue();
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
