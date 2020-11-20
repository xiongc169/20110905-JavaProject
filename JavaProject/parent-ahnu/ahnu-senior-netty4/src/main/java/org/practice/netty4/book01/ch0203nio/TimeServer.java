package org.practice.netty4.book01.ch0203nio;

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

/**
 * @Desc 《Netty权威指南·Java高性能NIO通信首选框架》2.3、NIO编程
 * PS：同步非阻塞IO
 * https://www.jb51.net/books/414868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月1日
 * <p>
 * @Version 1.0
 */
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

    @Deprecated
    public static void startServerSocket() {
        int port = 8080;
        ServerSocketChannel acceptorSvr = null;
        try {
            // 1、打开serverChannel
            acceptorSvr = ServerSocketChannel.open();
            acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), port));
            acceptorSvr.configureBlocking(false);
            // 3、创建Reactor线程
            Selector selector = Selector.open();
            //new Thread(new ReactorTask()).start();
            //SelectionKey key = acceptorSvr.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
            SelectionKey key = acceptorSvr.register(selector, SelectionKey.OP_ACCEPT);

            int num = selector.select();
            Set selectKeys = selector.selectedKeys();
            Iterator it = selectKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key02 = (SelectionKey) it.next();
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key02.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                it.remove();
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
