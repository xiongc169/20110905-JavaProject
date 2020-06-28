package org.practice.primary.book02.chap03.demo0302;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc 3.2、实现服务器
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class ServerSocketDemo {

    private static int serverPort = 9999;

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
        System.out.println("ServerSocket start...");
        ServerSocket serverSocket = new ServerSocket(serverPort);
        Socket socket = serverSocket.accept();//阻塞一，直到客户端 new Socket(serverIP, port)

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] buffers = new byte[1024 * 1024 * 5];//不能用inputStream.available()，否则不会阻塞二
        int length = inputStream.read(buffers);//阻塞二，直到客户端 输入
        System.out.println("【服务端】收到：" + new String(buffers, 0, length));

        System.out.println("【服务端】请输入(1)：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        outputStream.write(line.getBytes());
        outputStream.flush();

//        System.out.println("【服务端】请输入(2)：");
//        Scanner scanner2 = new Scanner(System.in);
//        String line2 = scanner2.nextLine();
//        PrintWriter printWriter = new PrintWriter(outputStream, true);
//        printWriter.println(line2);
//        printWriter.flush();

        System.out.println("ServerSocket end");
        System.in.read();
    }
}
