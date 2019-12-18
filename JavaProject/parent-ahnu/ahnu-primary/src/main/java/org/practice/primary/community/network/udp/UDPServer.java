package org.practice.primary.community.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Desc Java网络编程
 * http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 * @Author
 * @Date 2019年3月1日11:16:18
 * @Version 1.0
 */
public class UDPServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            starUpUDPServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void starUpUDPServer() throws Exception {
        byte[] data = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        DatagramSocket server = new DatagramSocket(10007);
        server.receive(receivePacket);
        InetAddress client = receivePacket.getAddress();
        System.out.println("Server Receive: " + client.getHostAddress() + " " + receivePacket.getPort() + " " + new String(receivePacket.getData()));

        byte[] msg = "Server Response for Client".getBytes();
        DatagramPacket responsePacket = new DatagramPacket(msg, msg.length, receivePacket.getAddress(), receivePacket.getPort());
        server.send(responsePacket);

        server.close();
    }
}
