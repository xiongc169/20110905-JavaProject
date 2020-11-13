package org.practice.netty3.community.netty.ch02.netty33;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * @Desc Netty
 * https://www.iteye.com/blog/lippeng-1907279
 * <p>
 * @Author yoong
 * <p>
 * @Date 2013年7月16日
 * <p>
 * @Version 1.0
 */
public class NettyServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new ServerHandler());
            }
        });
        Channel channel = serverBootstrap.bind(new InetSocketAddress(8888));
        System.out.println("Server已经启动，监听端口: " + channel.getLocalAddress() + "， 等待客户端注册...");
    }

    public static class ServerHandler extends SimpleChannelHandler {
        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            if (e.getMessage() instanceof String) {
                String message = (String) e.getMessage();
                System.out.println("Client发来:" + message);
                e.getChannel().write("Server已收到刚发送的:" + message);
            }
            super.messageReceived(ctx, e);
        }

        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("有一个客户端注册上来了...");
            System.out.println("Client:" + e.getChannel().getRemoteAddress());
            System.out.println("Server:" + e.getChannel().getLocalAddress());
            System.out.println("等待客户端输入...");
            super.channelConnected(ctx, e);
        }
    }
}
