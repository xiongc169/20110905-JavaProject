package org.practice.primary.book01.chap14.book02.chap0604;

public class Event implements Comparable<Event> {

    /**
     * 存放Event的线程数
     */
    private int thread;

    /**
     * 存放Event的优先级
     */
    private int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    public int getThread() {
        return thread;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * 这里的实现与大多数compareTo()方法相反
     */
    public int compareTo(Event o) {

        if (this.priority > o.getPriority()) {
            return -1;
        } else if (this.priority < o.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    }
}
