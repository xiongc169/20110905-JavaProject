package org.practice.primary.book02.chap03.demo0302;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc SocketDemo
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class SocketDemo {

    private static String serverIP = "127.0.0.1";

    private static int serverPort = 9999;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            socket4Local();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void socket4Local() throws Exception {
        System.out.println("ClientSocket start...");
        Socket socket = new Socket(serverIP, serverPort);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        System.out.println("【客户端】请输入(1)：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        outputStream.write(line.getBytes());
        outputStream.flush();

//        System.out.println("【客户端】请输入(2)：");
//        Scanner scanner2 = new Scanner(System.in);
//        String line2 = scanner2.nextLine();
//        PrintWriter writer = new PrintWriter(outputStream);
//        writer.write(line2);
//        writer.flush();

        byte[] buffers = new byte[1024 * 1024 * 5];//不能用inputStream.available()，否则不会阻塞一
        int length = inputStream.read(buffers);//阻塞一，直到服务端 输入
        System.out.println("【客户端】收到：" + new String(buffers, 0, length));

        System.out.println("ClientSocket end");
        System.in.read();
    }
}
