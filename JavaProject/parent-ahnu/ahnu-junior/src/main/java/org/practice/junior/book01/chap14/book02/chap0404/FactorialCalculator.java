package org.practice.junior.book01.chap14.book02.chap0404;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

    private Integer num;

    public FactorialCalculator(Integer number) {
        this.num = number;
    }

    public Integer call() throws Exception {
        int result = 1;
        if (num == 0 || num == 1)
            return 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("Thread: %s, Result: %d \n", Thread.currentThread().getName(), result);
        return result;
    }
}
