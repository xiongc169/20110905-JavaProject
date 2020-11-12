package org.practice.netty.book02.ch02;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Desc 《Netty实战》2.4、编写Echo客户端
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年11月12日
 * <p>
 * @Version 1.0
 */
public class EchoClient {

    private String host;
    private Integer port;

    public EchoClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            new EchoClient("127.0.0.1", 8888).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
