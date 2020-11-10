package org.practice.netty.book01.ch0203nio;

import java.nio.channels.SocketChannel;

/**
 * @Desc 《Netty权威指南·Java高性能NIO通信首选框架》2.3、NIO编程
 * PS：非阻塞IO
 * https://www.jb51.net/books/414868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月1日
 * <p>
 * @Version 1.0
 */
public class TimeClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int port = 8080;
            new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Deprecated
    public static void startSocket() {
        int port = 8080;
        SocketChannel acceptorSvr = null;
        try {

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
