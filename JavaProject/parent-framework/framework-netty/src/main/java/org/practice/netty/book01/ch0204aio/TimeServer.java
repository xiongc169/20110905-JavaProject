package org.practice.netty.book01.ch0204aio;

public class TimeServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int port = 8080;
            AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
            new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
