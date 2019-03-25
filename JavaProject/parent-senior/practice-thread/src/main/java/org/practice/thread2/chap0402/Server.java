package org.practice.thread2.chap0402;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    private ThreadPoolExecutor threadPool;

    public Server() {
        //创建ThreadPoolExecutor方法一：构造函数
        //threadPool = new ThreadPoolExecutor(1, 1, 1000l, TimeUnit.MILLISECONDS, null);
        //创建ThreadPoolExecutor方法二：Executors工厂类的静态方法
        threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //4.3、创建固定大小的线程执行器
        //threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        //threadPool = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
    }

    public void executeTask(Task task) {

        threadPool.execute(task);

        System.out.printf("Server: Pool Size %d\n", threadPool.getPoolSize());
        System.out.printf("Server: Active Size %d\n", threadPool.getActiveCount());
        System.out.printf("Server: Completed Size %d\n", threadPool.getCompletedTaskCount());

    }

    public void endServer() {
        //ThreadPoolExecutor需要显示的结束它
        threadPool.shutdown();
    }

}
