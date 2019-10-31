package org.practice.primary.community.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Desc Java网络编程
 * http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 * @Author
 * @Date 2019年2月28日18:47:11
 * @Version 1.0
 */
public class UDPClient {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            starUpUDPClient();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void starUpUDPClient() throws Exception {
        String ip = "127.0.0.1";
        int port = 10007;
        InetAddress address = InetAddress.getByName(ip);

        DatagramSocket client = new DatagramSocket();
        byte[] requestData = "Message".getBytes();
        System.out.println("Client Request: " + new String(requestData));
        DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, address, port);
        client.send(requestPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        client.receive(receivePacket);
        System.out.println("Client Receive: " + new String(receivePacket.getData()));

        client.close();
    }
}
