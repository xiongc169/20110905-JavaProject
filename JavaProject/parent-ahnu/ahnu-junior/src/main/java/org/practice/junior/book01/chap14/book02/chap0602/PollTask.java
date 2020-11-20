package org.practice.junior.book01.chap14.book02.chap0602;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}
