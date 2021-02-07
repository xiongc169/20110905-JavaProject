package com.yoong.netty3.community.ch02.netty33;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

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
public class NettyClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        ClientBootstrap clientBootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new ClientHandler());
            }
        });
        ChannelFuture channelFuture = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8888));
        channelFuture.getChannel().getCloseFuture().awaitUninterruptibly();
        clientBootstrap.releaseExternalResources();
        System.out.println(channelFuture.isDone());
    }

    public static class ClientHandler extends SimpleChannelHandler {

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            if (e.getMessage() instanceof String) {
                System.out.println(e.getMessage());
                e.getChannel().write("NettyClient-2020年11月12日17:27:30");
            }
            super.messageReceived(ctx, e);
        }

        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("已经与Server建立连接....");
            super.channelConnected(ctx, e);
        }
    }
}
