package org.practice.primary.community.network.udp01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Desc UdpServer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月1日11:16:18
 * <p>
 * @Version 1.0
 */
public class UdpServer {

    private static int serverPort = 10007;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            starUpUdpServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void starUpUdpServer() throws Exception {
        byte[] data = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        DatagramSocket server = new DatagramSocket(serverPort);
        server.receive(receivePacket);
        InetAddress client = receivePacket.getAddress();
        System.out.println("Server Receive: " + client.getHostAddress() + " " + receivePacket.getPort() + " " + new String(receivePacket.getData()));

        byte[] msg = "Server Response for Client".getBytes();
        DatagramPacket responsePacket = new DatagramPacket(msg, msg.length, receivePacket.getAddress(), receivePacket.getPort());
        server.send(responsePacket);

        server.close();
    }
}
