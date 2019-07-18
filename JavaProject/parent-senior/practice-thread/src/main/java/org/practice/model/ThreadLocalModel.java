package org.practice.model;

/**
 * @author yoong
 * <br>
 * @desc ThreadLocalModel
 * <br>
 * @date 2019/1/14 10:12
 */
public class ThreadLocalModel {

    private ThreadLocal<Long> threadId = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    private ThreadLocal<String> threadName = new ThreadLocal<String>() {
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public ThreadLocal<Long> getThreadId() {
        return threadId;
    }

    public void setThreadId(ThreadLocal<Long> threadId) {
        this.threadId = threadId;
    }

    public ThreadLocal<String> getThreadName() {
        return threadName;
    }

    public void setThreadName(ThreadLocal<String> threadName) {
        this.threadName = threadName;
    }
}