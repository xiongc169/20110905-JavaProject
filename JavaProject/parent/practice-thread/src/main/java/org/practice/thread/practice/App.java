package org.practice.thread.practice;

import java.util.concurrent.*;

import org.practice.model.Person;

public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        //测试
        inputCallableTest();
        concurrentTest();
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Callable,Runnable比较及用法 <br>
     * http://blog.csdn.net/heyutao007/article/details/19072675
     */
    public static void concurrentTest() {
        // InputThread input=new InputThread();
        // input.start();
        // Person person = input.person;
        // if(person==null){}

        ExecutorService pool = Executors.newFixedThreadPool(2);
        InputCallable task = new InputCallable();
        Future f1 = pool.submit(task);
        Person person;
        try {
            person = (Person) f1.get();// 会阻塞当前线程
            f1.cancel(false);
            if (person == null) {
                System.out.println("返回值为空");
            } else {
                System.out.println("返回值不为空");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
