package org.practice.primary.book02.chap03;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc SocketServer
 * @Author
 * @Date
 * @Version 1.0
 */
public class SocketServer {

    private static int port = 9999;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            serverSocket0302();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 3.2、实现服务器
     */
    public static void serverSocket0302() throws Exception {
        System.out.println("serverSocket start...");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.println("2019年8月14日10:39:56");
        System.out.println("serverSocket end");
    }
}
