package org.practice.netty.book01.ch0204aio;

/**
 * @Desc 《Netty权威指南·Java高性能NIO通信首选框架》2.4、AIO编程
 * PS：异步非阻塞IO
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
            AsyncTimeClientHandler timeClient = new AsyncTimeClientHandler("127.0.0.1", port);
            new Thread(timeClient, "AIO-AsyncTimeClientHandler-001").start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
