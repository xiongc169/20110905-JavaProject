package com.yoong.thread.book02.chap0204;

public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
