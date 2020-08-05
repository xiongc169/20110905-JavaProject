package org.practice.primary.book02.chap03.ch0303;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
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
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(serverPort));

        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8 * 1024 * 1024);
        socketChannel.read(byteBuffer);
        byteBuffer.flip();
        String result = byteBuffer.toString();
        System.out.println(result);
    }
}
