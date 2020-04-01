package org.practice.thread.thread02.ch01primary;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Java并发编程：如何创建线程？
 * PS：创建线程：Thread\Runnable
 * 创建进程：Runtime.exec()、ProcessBuilder.start()
 * https://www.cnblogs.com/dolphin0520/p/3913517.html
 * Java并发编程——系列教程
 * https://www.cnblogs.com/dolphin0520/category/602384.html
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            processBuilder();
            runtime();
            callableTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ProcessBuilder创建进程
     *
     * @throws Exception
     */
    public static void processBuilder() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig/all");
        Process process = pb.start();
        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    /**
     * Runtime创建进程
     *
     * @throws Exception
     */
    public static void runtime() throws Exception {
        String cmd = "cmd " + "/c " + "ipconfig/all";
        Process process = Runtime.getRuntime().exec(cmd);
        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    /**
     * Java并发编程：Callable、Future和FutureTask
     * https://www.cnblogs.com/dolphin0520/p/3949310.html
     *
     * @throws Exception
     */
    public static void callableTest() throws Exception {
        CallableTask callableTask = new CallableTask();

        //第一种方式：Callable+Executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Object> future = executor.submit(callableTask);
        boolean isDone = future.isDone();
        System.out.println("callableTest isDone: " + isDone);
        Object result = future.get();//get()方法会阻塞直到任务返回结果
        System.out.println("callableTest result: " + result);

        //第二种方式：Callable+Thread
        FutureTask futureTask = new FutureTask(callableTask);
        boolean isDone2 = futureTask.isDone();
        System.out.println("callableTest isDone2: " + isDone2);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object result2 = futureTask.get();//get()方法会阻塞直到任务返回结果
        System.out.println("callableTest result2: " + result2);
    }
}
