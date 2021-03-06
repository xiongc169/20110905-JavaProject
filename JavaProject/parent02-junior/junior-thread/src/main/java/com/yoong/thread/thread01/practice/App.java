package com.yoong.thread.thread01.practice;

import java.util.concurrent.*;

import com.yoong.thread.thread01.model.Person;

/**
 * @Desc 多线程练习
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //测试
            inputCallableTest();
            inputThreadTest();
            concurrentTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Callable测试
     */
    public static void inputCallableTest() {
        InputCallable myCallable = new InputCallable();
        FutureTask ft = new FutureTask(myCallable);
        Thread thread = new Thread(ft);
        thread.start();
        try {
            Person p = (Person) ft.get();
            System.out.println("inputCallableTest: " + p.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Thread测试
     */
    public static void inputThreadTest() throws Exception {
        InputThread input = new InputThread();
        input.start();
        input.join();
        Person person = input.person;
        if (person != null) {
            System.out.println("inputThreadTest: " + person.getName());
        } else {
            System.out.println("inputThreadTest is null! ");
        }
    }

    /**
     * Callable,Runnable比较及用法
     * http://blog.csdn.net/heyutao007/article/details/19072675
     */
    public static void concurrentTest() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        InputCallable task = new InputCallable();
        Future f1 = pool.submit(task);
        Person person;
        try {
            person = (Person) f1.get();// 会阻塞当前线程
            boolean isCancel = f1.cancel(false);
            if (person == null) {
                System.out.println("返回值为空");
            } else {
                System.out.println("返回值不为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
