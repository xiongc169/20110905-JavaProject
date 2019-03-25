package org.practice.netty2.ch0302netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

	public void bind(int port) throws Exception {

		// 配置服务端的NIO线程组，即Reactor线程组，一个用于服务端接受客户端的连接、一个用于进行SocketChannel的读写
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		try {
			// 用于启动NIO服务端的辅助类
			ServerBootstrap server = new ServerBootstrap();
			server.group(boss, worker).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new ChildChannelHandler());
			// 绑定端口，同步等待成功
			ChannelFuture f = server.bind(port).sync();
			// 等待服务端监听端口关闭
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放线程池资源
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}

	/**
	 * 
	 * @author Administrator
	 *
	 */
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {

			ch.pipeline().addLast(new TimeServerHandler());
		}
	}

	/**
	 * 入口函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 8087;
		try {
			new TimeServer().bind(port);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
