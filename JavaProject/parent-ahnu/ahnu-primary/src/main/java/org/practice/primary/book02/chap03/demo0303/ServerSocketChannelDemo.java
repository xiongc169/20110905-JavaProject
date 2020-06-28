package org.practice.primary.book02.chap03.demo0303;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc ServerSocketChannelDemo
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class ServerSocketChannelDemo {

    private static String serverIP = "127.0.0.1";

    private static int serverPort = 9999;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            startServerSocketChannel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startServerSocketChannel() throws Exception {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(serverIP, serverPort));
    }
}
