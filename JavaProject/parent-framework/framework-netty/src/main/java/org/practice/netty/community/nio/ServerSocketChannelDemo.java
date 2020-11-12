package org.practice.netty.community.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc Java NIO 教程(九) ServerSocketChannel
 * PS：Java NIO中的 ServerSocketChannel 可以监听新进来的TCP连接的通道，就像标准IO中的ServerSocket一样。
 * https://www.jianshu.com/p/2b658824ed76
 * <p>
 * @Author yoong
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
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        SocketChannel socketChannel = serverSocketChannel.accept();  //阻塞
        String msg = "Hello - 2020年6月28日15:29:04";
        byte[] bytes = msg.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        serverSocketChannel.close();
    }
}
