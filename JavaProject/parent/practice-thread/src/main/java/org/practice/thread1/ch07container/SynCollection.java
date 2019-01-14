package org.practice.thread1.ch07container;

import java.util.*;
import java.util.concurrent.*;

/**
 * Java并发编程：同步容器 <br>
 * http://www.cnblogs.com/dolphin0520/p/3933404.html
 * <p>
 * Java并发编程：并发容器之ConcurrentHashMap <br>
 * http://www.cnblogs.com/dolphin0520/p/3932905.html<br>
 * <p>
 * Java并发编程：并发容器之CopyOnWriteArrayList <br>
 * http://www.cnblogs.com/dolphin0520/p/3938914.html<br>
 * <p>
 * Java并发编程：阻塞队列
 * https://www.cnblogs.com/dolphin0520/p/3932906.html
 *
 * @author Administrator
 */
public class SynCollection {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                int size = 1;
                size <<= i;//二进制左移1位
                System.out.println(size);
            }

            container();
            syncContainer();
            parallelContainer();
            blockingQueue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java并发编程：同步容器 <br>
     * PS：普通容器，非线程安全
     * http://www.cnblogs.com/dolphin0520/p/3933404.html
     */
    public static void container() {
        List arrayList = new ArrayList<String>();
        List linkedList = new LinkedList();
        Set hashSet = new HashSet<String>();
        Map hashMap = new HashMap();
    }

    /**
     * Java并发编程：同步容器 <br>
     * PS：同步容器，线程安全
     * http://www.cnblogs.com/dolphin0520/p/3933404.html
     */
    public static void syncContainer() {

        Stack stack = new Stack();
        Vector vector = new Vector();
        Hashtable hTable = new Hashtable();

        List<String> synArrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> synLinkedList = Collections.synchronizedList(new LinkedList<>());
    }

    /**
     * Java并发编程：并发容器之ConcurrentHashMap <br>
     * http://www.cnblogs.com/dolphin0520/p/3932905.html<br>
     * <p>
     * Java并发编程：并发容器之CopyOnWriteArrayList <br>
     * PS：CopyOnWrite容器，写时复制容器。运用了读写分离的思想；<br>
     * http://www.cnblogs.com/dolphin0520/p/3938914.html<br>
     */
    public static void parallelContainer() {
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
