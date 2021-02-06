package org.practice.java8.book01.ch11;

import java.util.concurrent.*;

/**
 * @Desc 《Java 8实战.pdf》
 * 第十一章、CompletableFuture 组合式异步编程
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppCompletable {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            future1101();
            completableFuture1102();
            completableFutureDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void future1101() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() {
                Double result = 0.0;
                try {
                    Thread.sleep(2000);
                    result = 1.0;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("thread finished");
                return result;
            }
        });
        try {
            Double result = future.get(5, TimeUnit.SECONDS);
            System.out.println("main finished");
            System.out.println(result);
        } catch (ExecutionException ee) {
            // 计算抛出一个异常
            ee.printStackTrace();
        } catch (InterruptedException ie) {
            // 当前线程在等待过程中被中断
            ie.printStackTrace();
        } catch (TimeoutException te) {
            // 在Future对象完成之前超过已过期
            te.printStackTrace();
        }
    }

    public static void completableFuture1102() throws Exception {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("thread finished");
            completableFuture.complete(200);
        });
        System.out.println("main finished");
    }

    /**
     * 使用CompletableFuture
     * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
     */
    public static void completableFutureDemo() {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(AppCompletable::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
