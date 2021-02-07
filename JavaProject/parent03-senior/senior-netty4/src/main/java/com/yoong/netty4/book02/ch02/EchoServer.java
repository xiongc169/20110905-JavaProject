package com.yoong.netty4.book02.ch02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Desc 《Netty实战》2.3、编写Echo服务器
 * https://www.cnblogs.com/leesf456/p/6824345.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年11月12日
 * <p>
 * @Version 1.0
 */
public class EchoServer {

    private Integer port;

    public EchoServer(Integer port) {
        this.port = port;
    }

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            new EchoServer(8888).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() throws Exception {
        EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            //channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
            //    @Override
            //    public void operationComplete(Future<? super Void> future) throws Exception {
            //        String msg = "GenericFutureListener.operationComplete";
            //        System.out.println(msg);
            //    }
            //});
            System.out.println("After bind");
            channelFuture.channel().closeFuture().sync();
            System.out.println("After closeFuture");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
            System.out.println("After shutdownGracefully");
        }
    }
}
