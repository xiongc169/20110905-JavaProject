package com.yoong.netty4.book01.ch0201bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc 《Netty权威指南·Java高性能NIO通信首选框架》2.1、传统的BIO编程
 * PS：同步阻塞式IO
 * https://www.jb51.net/books/414868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月1日
 * <p>
 * @Version 1.0
 */
public class TimeServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {
                // 采用默认值
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);

            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            String msg = e.getMessage();
            System.out.println("Exception is " + msg);
        } finally {
            if (server != null)
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            server = null;
        }
    }
}
