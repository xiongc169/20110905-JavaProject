package org.practice.netty.book01.ch0204aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {

	private int port;

	CountDownLatch latch;

	AsynchronousServerSocketChannel asyncChannel;

	public AsyncTimeServerHandler(int port) {

		try {
			this.port = port;
			asyncChannel = AsynchronousServerSocketChannel.open();
			asyncChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server is start in port: " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		latch = new CountDownLatch(1);
		doAccept();

		try {
			latch.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doAccept() {
		asyncChannel.accept(this, new AcceptCompletionHandler());
	}

}
