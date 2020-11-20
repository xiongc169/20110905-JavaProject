package org.practice.netty4.book01.ch0202fakeio;

import org.practice.netty4.book01.ch0201bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc 《Netty权威指南·Java高性能NIO通信首选框架》2.2、伪异步IO编程
 * PS：伪异步IO
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
                String msg = e.getMessage();
            }
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            Socket socket = null;
            System.out.println("The time server is start in port :" + port);
            TimeServerHandlerExecutorPool executor = new TimeServerHandlerExecutorPool(10, 20);
            while (true) {
                socket = server.accept();
                executor.execute(new TimeServerHandler(socket));
            }

        } catch (Exception e) {
            String msg = e.getMessage();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }
    }
}
