package org.practice.junior.book01.chap14.book02.chap0302;

public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        printQueue.printJob(Thread.currentThread());
    }
}
