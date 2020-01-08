package org.practice.netty.community.nio01;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc ServerSocketChannelDemo
 * <p>
 * @Author Yoong
 * <p>
 * @Date 2016年4月6日20:26:23
 * <p>
 * @Version 1.0
 */
public class ServerSocketChannelDemo {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            serverSocketChannelDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void serverSocketChannelDemo() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        int length = 0;
        do {
        } while (length > -1);

        serverSocketChannel.close();
    }
}
