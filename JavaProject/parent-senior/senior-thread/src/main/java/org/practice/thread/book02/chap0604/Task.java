package org.practice.thread.book02.chap0604;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {

    private int id;

    private PriorityBlockingQueue<Event> priorityBlockingQueue;

    public Task() {
    }

    public Task(int id, PriorityBlockingQueue<Event> priorityBlockingQueue) {
        this.id = id;
        this.priorityBlockingQueue = priorityBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id, i);
            priorityBlockingQueue.add(event);
        }
    }
}
