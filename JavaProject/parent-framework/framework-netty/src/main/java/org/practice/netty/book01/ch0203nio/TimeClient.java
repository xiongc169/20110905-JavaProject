package org.practice.netty.book01.ch0203nio;

public class TimeClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {

        int port = 8080;

        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
