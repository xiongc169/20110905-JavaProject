package org.practice.primary.book02.chap01.community.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Desc Java NIO 教程(八) SocketChannel
 * PS：Java NIO中的SocketChannel是一个连接到TCP网络套接字的通道，通过以下2种方式创建SocketChannel：
 * 1、打开一个SocketChannel并连接到互联网上的某台服务器。
 * 2、一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。
 * https://www.jianshu.com/p/eeed1c7aec2d
 * <p>
 * @Author yoong
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
        socketChannel.read(byteBuffer);  //阻塞
        byteBuffer.flip();
        //转换为String
        Charset charset = Charset.forName("utf-8");
        String result = charset.decode(byteBuffer).toString();
        System.out.println(result);
        socketChannel.close();
    }
}
