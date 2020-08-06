package org.practice.netty.book01.ch0203nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int port = 8080;
            MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
            new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 测试代码
     */
    public static void startServerSocket() {

        int port = 8080;
        ServerSocketChannel acceptorSvr = null;
        try {
            // 1、打开serverChannel
            acceptorSvr = ServerSocketChannel.open();
            acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), port));
            acceptorSvr.configureBlocking(false);
            // 3、创建reactor线程
            Selector selector = Selector.open();
            //new Thread(new ReactorTask()).start();
            //SelectionKey key = acceptorSvr.register(selector, SelectionKey.OP_ACCEPT, ioHandler);

            int num = selector.select();
            Set selectKeys = selector.selectedKeys();
            Iterator it = selectKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();

            }

            SocketChannel channel = acceptorSvr.accept();
            channel.configureBlocking(false);
            channel.socket().setReuseAddress(true);

            //SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            int readNumber = channel.read(byteBuffer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
