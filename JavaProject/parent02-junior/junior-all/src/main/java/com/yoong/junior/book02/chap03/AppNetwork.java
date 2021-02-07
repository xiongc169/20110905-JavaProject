package com.yoong.junior.book02.chap03;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》第三章、网络
 * https://www.jb51.net/books/328275.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class AppNetwork {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * IP地址: 132.163.4.103
     */
    public static String cesiumClockIP = "time-A.timefreq.bldrdoc.gov";
    public static Integer cesiumClockPort = 13;

    public static String horstmannIP = "horstmann.com";
    public static Integer horstmannPort = 80;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //连接到铯原子钟
            connectServer0301();
            inetAddress0301();
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

        //输出一
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer, 0, inputStream.available());
        String result = new String(buffer);
        System.out.println(result);
        //输出二
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
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");
        System.out.println(inetAddresses.length);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 1);
        System.out.println(inetSocketAddress);
    }
}
