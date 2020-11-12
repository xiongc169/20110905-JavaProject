package org.practice.netty.community.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Desc Java NIO 教程(十一) Java NIO DatagramChannel
 * https://www.jianshu.com/p/1b1e1849344c
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月6日20:26:23
 * <p>
 * @Version 1.0
 */
public class DatagramChannelClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            startUDPClient();
            startUDPClient02();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startUDPClient() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        String msg = "Hello - 2020年6月28日15:29:04";
        byte[] bytes = msg.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        channel.send(byteBuffer, new InetSocketAddress(InetAddress.getLocalHost(), 9999));
        channel.close();
    }

    public static void startUDPClient02() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 9999));
        String msg = "Hello - 2020年6月28日15:29:04";
        byte[] bytes = msg.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        channel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 9999));
        channel.close();
    }
}
