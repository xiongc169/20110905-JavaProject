package org.practice.junior.book02.chap03.ch0303;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
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
            startSocketChannel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startSocketChannel() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(serverIP, serverPort));
        ByteBuffer byteBuffer = ByteBuffer.allocate(8 * 1024 * 1024);
        byteBuffer.putInt(1000);
        int length = socketChannel.write(byteBuffer);
        System.out.println(length);
    }
}
