package org.practice.thread2.chap0302;

public class App {

    public static void main(String[] args) {

        PrintQueue printQueue = new PrintQueue();
        for (int i = 0; i < 2; i++) {
            Job job = new Job(printQueue);
            Thread thread = new Thread(job);
            thread.start();
        }
    }
}
