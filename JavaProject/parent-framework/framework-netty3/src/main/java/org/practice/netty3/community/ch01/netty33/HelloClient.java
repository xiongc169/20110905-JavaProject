package org.practice.netty3.community.ch01.netty33;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

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
public class HelloClient extends SimpleChannelHandler {

    /**
     * 入口函数
     */
    public static void main(String args[]) {
        // Client服务启动器
        ClientBootstrap clientBootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        // 设置一个处理服务端消息和各种消息事件的类(Handler)
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new HelloClientHandler());
            }
        });
        // 连接到本地的8000端口的服务端
        clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8000));
    }

    private static class HelloClientHandler extends SimpleChannelHandler {

        /**
         * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
         */
        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
            System.out.println("Hello world, I'm client.");
        }
    }
}
