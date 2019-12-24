package org.practice.primary.book02.chap03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》第三章、网络
 * @Author
 * @Date
 * @Version 1.0
 */
public class SocketClient {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * IP地址132.163.4.103
     */
    public static String cesiumClockIP = "time-A.timefreq.bldrdoc.gov";
    public static Integer cesiumClockPort = 13;

    public static String horstmannIP = "horstmann.com";
    public static Integer horstmannPort = 80;

    private static int port = 9999;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //连接到铯原子钟
            connectServer0301();
            inetAddress0301();
            //socket4Local();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 3.1、连接到铯原子钟
     */
    public static void connectServer0301() throws Exception {
        System.out.println(format.format(new Date()));
        Socket socket = new Socket(cesiumClockIP, cesiumClockPort);
        //防止可读超时
        //socket.setSoTimeout(15000);
        //防止连接超时
        //socket.connect(new InetSocketAddress(horstmannIP, horstmannPort), 1000);
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        int lineNum = 1;
        while (scanner.hasNextLine()) {
            System.out.printf("Line-%d  %s\n", lineNum++, scanner.nextLine());
        }
        System.out.println(format.format(new Date()));
    }

    /**
     * 3.1.2、英特网地址
     */
    public static void inetAddress0301() throws Exception {
        InetAddress inetAddress = InetAddress.getByName(cesiumClockIP);
        System.out.println(inetAddress);
    }


    public static void socket4Local() throws Exception {
        Socket socket = new Socket("127.0.0.1", port);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(100);

        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
