package org.practice.thread2.chap0205;

public class Job implements Runnable {
    private PrintQueue queue;

    public Job() {
    }

    public Job(PrintQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.print();
    }
}
