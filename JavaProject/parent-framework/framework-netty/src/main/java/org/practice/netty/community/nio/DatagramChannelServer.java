package org.practice.netty.community.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * @Desc Java NIO 教程(十一) Java NIO DatagramChannel
 * https://www.jianshu.com/p/1b1e1849344c
 * <p>
 * @Author Yoong
 * <p>
 * @Date 2016年4月6日20:26:23
 * <p>
 * @Version 1.0
 */
public class DatagramChannelServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            startUDPServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startUDPServer() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.clear();
        channel.receive(byteBuffer);//阻塞
        //转换为String
        Charset charset = Charset.forName("utf-8");
        String result = charset.decode(byteBuffer).toString();
        System.out.println(result);
        channel.close();
    }
}
