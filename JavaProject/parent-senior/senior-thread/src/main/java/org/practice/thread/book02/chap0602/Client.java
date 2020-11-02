package org.practice.thread.book02.chap0602;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

public class Client implements Runnable {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private LinkedBlockingDeque<String> requestList;

    public Client() {
    }

    public Client(LinkedBlockingDeque<String> requestList) {
        this.requestList = requestList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    String input = i + "-" + j;
                    requestList.put(input);
                    System.out.println(format.format(new Date()) + "  Input:" + input + "  Size:" + requestList.size());
                }
                Thread.sleep(3000);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
