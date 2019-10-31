package org.practice.thread.thread02.ch14forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author yoong
 *
 * @desc ComputeTask
 *
 * @date 2019/1/10 11:20
 */
public class ComputeTask extends RecursiveTask<Integer> {

    private Integer THREAD_HOLD = 2;
    private Integer start;
    private Integer end;

    public ComputeTask() {
    }

    public ComputeTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        synchronized (this) {
            int sum = 0;
            if (end - start <= THREAD_HOLD) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }
            Integer middle = (end + start) / 2;
            ComputeTask leftTask = new ComputeTask(start, middle);
            ComputeTask rightTask = new ComputeTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;
            return sum;
        }
    }
}
