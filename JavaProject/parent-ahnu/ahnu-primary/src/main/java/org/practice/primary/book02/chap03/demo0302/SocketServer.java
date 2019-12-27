package org.practice.primary.book02.chap03.demo0302;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc 3.2、实现服务器
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

    public static void serverSocket0302() throws Exception {
        System.out.println("serverSocket start...");

        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.println("2019年8月14日10:39:56");
        printWriter.flush();

        System.out.println("serverSocket end");
    }
}
