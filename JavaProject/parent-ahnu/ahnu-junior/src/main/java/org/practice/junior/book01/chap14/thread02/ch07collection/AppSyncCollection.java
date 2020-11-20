package org.practice.junior.book01.chap14.thread02.ch07collection;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Desc Java并发编程：同步容器
 * http://www.cnblogs.com/dolphin0520/p/3933404.html
 * Java并发编程：并发容器之ConcurrentHashMap
 * http://www.cnblogs.com/dolphin0520/p/3932905.html
 * Java并发编程：并发容器之CopyOnWriteArrayList
 * http://www.cnblogs.com/dolphin0520/p/3938914.html
 * Java并发编程：阻塞队列
 * https://www.cnblogs.com/dolphin0520/p/3932906.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppSyncCollection {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                int size = 1;
                size <<= i;//二进制左移1位
                System.out.println(size);
            }

            collection();
            syncCollection_performance();
            syncCollection_safe();
            concurrentCollection();
            blockingQueue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java并发编程：同步容器
     * PS：普通容器，非线程安全
     * http://www.cnblogs.com/dolphin0520/p/3933404.html
     */
    public static void collection() {
        List arrayList = new ArrayList<String>();
        List linkedList = new LinkedList();
        Set hashSet = new HashSet<String>();
        Map hashMap = new HashMap();
    }

    /**
     * Java并发编程：同步容器
     * PS：同步容器，线程安全
     * http://www.cnblogs.com/dolphin0520/p/3933404.html
     */
    public static void syncCollection_performance() {
        List arrayList = new ArrayList<String>();
        Vector vector = new Vector();
        Stack stack = new Stack();
        Hashtable hTable = new Hashtable();

        List<String> synArrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> synLinkedList = Collections.synchronizedList(new LinkedList<>());

        //ArrayList、Vector性能测试
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时：" + (end - start) + "ms");//291ms

        start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时：" + (end - start) + "ms");//1960ms
    }

    public static void syncCollection_safe() {
        //Vector是否真的线程安全
        Vector vector2 = new Vector();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        vector2.add(j);
                    }
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("Thread.activeCount: " + Thread.activeCount());
        System.out.println("vector2.size: " + vector2.size());
    }

    /**
     * Java并发编程：并发容器之ConcurrentHashMap
     * http://www.cnblogs.com/dolphin0520/p/3932905.html
     * Java并发编程：并发容器之CopyOnWriteArrayList
     * PS：CopyOnWrite容器，写时复制容器。运用了读写分离的思想；
     * http://www.cnblogs.com/dolphin0520/p/3938914.html
     */
    public static void concurrentCollection() {
        ConcurrentHashMap conHashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
    }

    /**
     * Java并发编程：阻塞队列
     * PS：阻塞队列，线程安全
     * https://www.cnblogs.com/dolphin0520/p/3932906.html
     * Java并发：阻塞队列
     * http://www.cnblogs.com/studyLog-share/p/5390745.html
     */
    public static void blockingQueue() {
        // 常见阻塞队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        DelayQueue delayQueue = new DelayQueue();
        SynchronousQueue synchronousQueue = new SynchronousQueue();
    }
}
