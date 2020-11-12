package org.practice.netty.book01.ch0201bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
public class TimeClient {

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

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {

            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("QUERY TIME ORDER yoong");
            System.out.println("Send Order to server succeed.");
            String resp = in.readLine();
            System.out.println("Now is :" + resp);

        } catch (Exception e) {
            String msg = e.getMessage();
        } finally {
            if (out != null) {
                out.close();
                out = null;
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
