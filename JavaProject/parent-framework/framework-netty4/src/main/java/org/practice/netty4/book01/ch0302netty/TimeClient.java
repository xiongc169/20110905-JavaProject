package org.practice.netty4.book01.ch0302netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Desc 《Netty权威指南·Java高性能NIO通信首选框架》3.3、Netty客户端开发
 * https://www.jb51.net/books/414868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月1日
 * <p>
 * @Version 1.0
 */
public class TimeClient {

	public void connect(int port, String host) throws Exception {

		EventLoopGroup client = new NioEventLoopGroup();
		try {

			Bootstrap b = new Bootstrap();
			b.group(client).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new TimeClientHandler());
						}
					});

			// 发起异步连接操作
			ChannelFuture f = b.connect(host, port).sync();
			// 等待客户端链路关闭
			f.channel().closeFuture().sync();
		} finally {
			client.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {

		new TimeClient().connect(8087, "127.0.0.1");
	}
}
