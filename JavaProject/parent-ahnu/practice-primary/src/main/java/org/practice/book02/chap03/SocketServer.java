package org.practice.book02.chap03;

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
            serverSocket();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void serverSocket() throws Exception {
        System.out.println("serverSocket start...");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.println("2019年8月14日10:39:56");
        System.out.println("serverSocket end");
    }
}
