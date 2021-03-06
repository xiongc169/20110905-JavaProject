package com.yoong.thread.thread02.ch01primary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Desc Java并发编程：如何创建线程？
 * PS：创建线程：Thread\Runnable
 * 创建进程：Runtime.exec()、ProcessBuilder.start()
 * https://www.cnblogs.com/dolphin0520/p/3913517.html
 * Java并发编程——系列教程
 * https://www.cnblogs.com/dolphin0520/category/1426288.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppProcess {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

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
     */
    public static void callableTest() throws Exception {
        CallableTask callableTask = new CallableTask();

        //第一种方式：Callable + Executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Object> future = executor.submit(callableTask);
        boolean isDone = future.isDone();
        System.out.println(format.format(new Date()) + " callableTest isDone: " + isDone);
        Object result = future.get();//get()方法会阻塞直到任务返回结果
        System.out.println(format.format(new Date()) + " callableTest result: " + result);

        //第二种方式：FutureTask + Executor
        FutureTask futureTask2 = new FutureTask(callableTask);
        executor.submit(futureTask2);
        boolean isDone2 = futureTask2.isDone();
        System.out.println(format.format(new Date()) + " callableTest isDone2: " + isDone2);
        Object result2 = futureTask2.get();
        System.out.println(format.format(new Date()) + " callableTest result2: " + result2);

        //第三种方式：FutureTask + Thread
        FutureTask futureTask3 = new FutureTask(callableTask);
        Thread thread = new Thread(futureTask3);
        thread.start();
        boolean isDone3 = futureTask3.isDone();
        System.out.println(format.format(new Date()) + " callableTest isDone3: " + isDone3);
        Object result3 = futureTask3.get();//get()方法会阻塞直到任务返回结果
        System.out.println(format.format(new Date()) + " callableTest result3: " + result3);
    }
}
