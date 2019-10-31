package org.practice.thread.book01.chap0404;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            getExecutorReturn();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 4.4、在执行器中执行任务并返回结果
     */
    private static void getExecutorReturn() throws Exception {
        Random random = new Random();
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(num);
            Future<Integer> result = executor.submit(calculator);
            //4.5、运行多个任务并处理第一个结果
            //invokeAny()方法，接收到一个任务列表，然后运行任务，并返回第一个完成任务且没有抛出异常的任务的执行结果；
            //executor.invokeAny(Arrays.asList(calculator));

            //4.6、运行多个任务并处理所有结果
            //invokeAll()方法
            executor.invokeAll(Arrays.asList(calculator));
            resultList.add(result);
        }

        do {
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Thread: %s, Status: %s \n", Thread.currentThread().getName(), result.isDone());
            }

        } while (executor.getCompletedTaskCount() < resultList.size());

        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            try {
                Integer number = result.get();
                System.out.printf("Thread: %s, result: %s \n", Thread.currentThread().getName(), number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

}
