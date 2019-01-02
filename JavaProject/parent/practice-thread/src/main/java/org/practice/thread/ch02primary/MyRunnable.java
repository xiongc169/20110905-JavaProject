package org.practice.thread.ch02primary;

/**
 * @author chaoxiong
 * @since 2015-10-19 15:45:45
 */
public class MyRunnable implements Runnable {

    public void run() {
        // synchronized (this) {
        // for (int i = 0; i < 10; i++) {
        String output = String.format("MyRunnable %s  %d", Thread.currentThread().getName(), Thread.currentThread().getId());
        System.out.println(output);
        // }
        // }
    }

}
