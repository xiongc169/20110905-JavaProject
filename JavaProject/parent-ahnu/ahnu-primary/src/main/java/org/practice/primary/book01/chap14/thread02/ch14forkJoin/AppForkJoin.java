package org.practice.primary.book01.chap14.thread02.ch14forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @Desc Fork/Join框架详解
 * https://www.cnblogs.com/senlinyang/p/7885964.html
 * https://www.cnblogs.com/dongguacai/p/6021859.html
 * https://www.cnblogs.com/jiyuqi/p/4547082.html
 * https://www.jianshu.com/p/f777abb7b251
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppForkJoin {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            forkJoinTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * forkJoin测试
     */
    private static void forkJoinTest() throws Exception {
        ComputeTask computeTask = new ComputeTask(1, 100);
        ForkJoinPool pool = new ForkJoinPool();

        Future<Integer> result = pool.submit(computeTask);
        System.out.println("result.get " + result.get());

        //ForkJoinTask result2 = pool.submit(computeTask);
        //System.out.println("result2.get() " + result2.get());
    }
}
