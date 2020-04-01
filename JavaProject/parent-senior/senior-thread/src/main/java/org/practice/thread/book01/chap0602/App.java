package org.practice.thread.book01.chap0602;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class App {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            nonblockingList();
            blockingList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 6.2、使用非阻塞式线程安全列表 ConcurrentLinkedDeque
     */
    private static void nonblockingList() {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            AddTask add = new AddTask(list);
            threads[i] = new Thread(add);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("List Size:%d \n", list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask poll = new PollTask(list);
            threads[i] = new Thread(poll);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("List Size:%d \n", list.size());
    }

    /**
     * 6.3、使用阻塞式线程安全列表 LinkedBlockingDeque
     */
    private static void blockingList() throws Exception {
        LinkedBlockingDeque<String> requestList = new LinkedBlockingDeque<>();
        Client client = new Client(requestList);
        Thread thread = new Thread(client);
        thread.start();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                String result = requestList.take();
                System.out.println(format.format(new Date()) + "  Output:" + result + "  Size:" + requestList.size());
            }
            Thread.sleep(300);
        }
    }
}
