package org.practice.primary.book02.chap03.demo0303;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc SocketChannelDemo
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class SocketChannelDemo {

    private static String serverIP = "127.0.0.1";

    private static int serverPort = 9999;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open(new InetSocketAddress(serverIP, serverPort));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
