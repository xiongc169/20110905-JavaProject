package org.practice.netty3.community.netty.ch01.netty33;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * @Desc Java NIO框架Netty教程（一） – Hello Netty
 * http://blog.csdn.net/kobejayandy/article/details/11493717
 * <p>
 * @Author yoong
 * <p>
 * @Date 2013年9月9日
 * <p>
 * @Version 1.0
 */
public class HelloServer {

    /**
     * 入口函数
     */
    public static void main(String args[]) {
        // Server服务启动器
        ServerBootstrap serverBootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        // 设置一个处理客户端消息和各种消息事件的类(Handler)
        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new HelloServerHandler());
            }
        });
        // 开放8000端口供客户端访问。
        serverBootstrap.bind(new InetSocketAddress(8000));
    }

    private static class HelloServerHandler extends SimpleChannelHandler {

        /**
         * 当有客户端绑定到服务端的时候触发，打印"Hello world, I'm server."
         */
        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
            System.out.println("Hello world, I'm server.");
        }
    }
}
