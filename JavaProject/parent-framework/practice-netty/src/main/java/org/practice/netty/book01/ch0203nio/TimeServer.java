package org.practice.netty.book01.ch0203nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class TimeServer {

	/**
	 * 入口函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int port = 8080;
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();

	}

	/**
	 * 测试代码
	 */
	public static void test() {

		int port = 8080;
		ServerSocketChannel acceptorSvr = null;
		try {
			// 1、打开serverChannel
			acceptorSvr = ServerSocketChannel.open();
			acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), port));
			acceptorSvr.configureBlocking(false);
			// 3、创建reactor线程
			Selector selector = Selector.open();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
