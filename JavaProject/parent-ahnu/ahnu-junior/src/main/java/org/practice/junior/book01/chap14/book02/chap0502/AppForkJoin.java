package org.practice.junior.book01.chap14.book02.chap0502;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：5.2、创建Fork/Join线程池
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppForkJoin {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            forkJoin0502();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void forkJoin0502() {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> productList = generator.generate(10);
        Task task = new Task(productList, 0, productList.size(), 0.2);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(task);

        do {
            //do Something
        } while (task.isDone());
        forkJoinPool.shutdown();
    }
}
