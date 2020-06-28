package org.practice.primary.community.network.udp01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Desc Java网络编程
 * PS：13.1.3、网络通讯方式
 * TCP、UDP，传输控制协议、用户数据报协议；
 * 13.2.2、Java网络编程技术
 * http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年2月28日18:47:11
 * <p>
 * @Version 1.0
 */
public class DatagramSocketClient {

    private static String serverIP = "127.0.0.1";

    private static int serverPort = 10007;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            startDatagramSocketClient();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startDatagramSocketClient() throws Exception {
        InetAddress address = InetAddress.getByName(serverIP);

        DatagramSocket client = new DatagramSocket();
        byte[] requestData = "Message".getBytes();
        System.out.println("Client Request: " + new String(requestData));
        DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, address, serverPort);
        client.send(requestPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        client.receive(receivePacket);
        System.out.println("Client Receive: " + new String(receivePacket.getData()));

        client.close();
    }
}
