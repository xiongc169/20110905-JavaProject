package org.practice.netty.book01.ch0204aio;

public class TimeClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int port = 8080;
            AsyncTimeClientHandler timeClient = new AsyncTimeClientHandler("127.0.0.1", port);
            new Thread(timeClient, "AIO-AsyncTimeClientHandler-001").start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
