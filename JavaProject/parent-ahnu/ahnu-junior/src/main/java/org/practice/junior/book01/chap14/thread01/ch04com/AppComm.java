package org.practice.junior.book01.chap14.thread01.ch04com;

import org.practice.junior.book01.chap14.thread01.ch04com.block03.ConsumerBlock;
import org.practice.junior.book01.chap14.thread01.ch04com.block03.ProducerBlock;
import org.practice.junior.book01.chap14.thread01.ch04com.lock02.ConsumerLock;
import org.practice.junior.book01.chap14.thread01.ch04com.lock02.ProducerLock;
import org.practice.junior.book01.chap14.thread01.ch04com.sync01.ConsumerSyn;
import org.practice.junior.book01.chap14.thread01.ch04com.sync01.ProducerSyn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc 生产者-消费者模式的三种实现方式
 * PS：方式一：synchronized、wait和notify
 * 方式二：lock和condition的await、signalAll
 * 方式三：BlockingQueue
 * https://www.cnblogs.com/xiaowenboke/p/10469125.html
 * https://segmentfault.com/a/1190000020473883
 * https://www.jianshu.com/p/e29632593057
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppComm {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            synchronizedPool();
            lockPool();
            blockPool();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void synchronizedPool() throws Exception {
        Object obj = new Object();
        List pool = new ArrayList();
        Thread consumer = new Thread(new ConsumerSyn(obj, pool));
        Thread producer = new Thread(new ProducerSyn(obj, pool));
        consumer.start();
        producer.start();
    }

    private static void lockPool() throws Exception {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        List pool = new ArrayList();
        Thread consumer = new Thread(new ConsumerLock(lock, condition, pool));
        Thread producer = new Thread(new ProducerLock(lock, condition, pool));
        consumer.start();
        producer.start();
    }

    private static void blockPool() throws Exception {
        BlockingQueue queue = new LinkedBlockingQueue(5);
        Thread consumer = new Thread(new ConsumerBlock(queue));
        Thread producer = new Thread(new ProducerBlock(queue));
        consumer.start();
        producer.start();
    }
}
