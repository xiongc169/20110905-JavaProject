package org.practice.primary.book02.chap03.demo0303;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc SocketChannelClient
 * @Author
 * @Date
 * @Version 1.0
 */
public class SocketChannelClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
