package org.practice.netty.community.nio01;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Desc SocketChannelDemo
 * <p>
 * @Author Yoong
 * <p>
 * @Date 2016年4月6日20:26:23
 * <p>
 * @Version 1.0
 */
public class SocketChannelDemo {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            socketChannelDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void socketChannelDemo() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        int length = 0;
        do {
            length = socketChannel.read(byteBuffer);
        } while (length > -1);

        socketChannel.close();
    }
}
