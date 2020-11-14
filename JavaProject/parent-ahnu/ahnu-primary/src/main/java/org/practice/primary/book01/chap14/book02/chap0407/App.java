package org.practice.primary.book01.chap14.book02.chap0407;

import java.util.concurrent.*;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：4.7、在执行器中延时执行任务
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //delayExecutor();
            //regularExecutor();
            cancelExecutor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 4.7、在执行器中延时执行任务
     */
    private static void delayExecutor() throws Exception {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task-" + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        //调用执行器的awaitTermination()方法，等待所有任务结束
        executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("Task Finished!");
    }

    /**
     * 4.8、在执行器中周期性执行任务
     */
    private static void regularExecutor() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        RunnableTask task = new RunnableTask("Task-" + 1);
        ScheduledFuture future = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        System.out.println("future.isDone(): " + future.isDone());

        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
        System.out.println("Task Finished!");
    }

    /**
     * 4.9、在执行器中取消任务
     */
    private static void cancelExecutor() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task = new Task("Task-" + 1);
        Future<String> future = executor.submit(task);
        TimeUnit.SECONDS.sleep(3);
        boolean isCanceled = future.cancel(true);
        System.out.println("isCanceled: " + isCanceled);
        executor.shutdown();
        System.out.println("Task Finished!");
    }

    /**
     * 4.10、在执行器中控制任务的完成
     */
    private static void done() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ResultTask[] resultTasks = new ResultTask[5];
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task-" + i);
            resultTasks[i] = new ResultTask(task);
            executor.submit(resultTasks[i]);
        }

        TimeUnit.SECONDS.sleep(3);

        for (int i = 0; i < 5; i++) {
            resultTasks[i].cancel(true);
        }
        System.out.println("Task Finished!");
    }
}
