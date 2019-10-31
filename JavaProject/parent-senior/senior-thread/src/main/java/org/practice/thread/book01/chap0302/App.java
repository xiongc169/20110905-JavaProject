package org.practice.thread.book01.chap0302;

public class App {

    public static void main(String[] args) {

        PrintQueue printQueue = new PrintQueue();
        for (int i = 0; i < 10; i++) {
            Job job = new Job(printQueue);
            Thread thread = new Thread(job);
            thread.start();
        }
    }
}
