package org.practice.netty2.ch0203nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {

	private Selector selector;

	private ServerSocketChannel serverChannel;

	private volatile boolean stop;

	/**
	 * 初始化多路复用器、绑定监听端口
	 * 
	 * @param port
	 */
	public MultiplexerTimeServer(int port) {
		try {
			// 1、打开Channel，绑定监听端口
			serverChannel = ServerSocketChannel.open();
			serverChannel.socket().bind(new InetSocketAddress(port), 1024);
			serverChannel.configureBlocking(false);
			// 2、创建reactor线程的多路复用器
			selector = Selector.open();
			// 3、将Channel注册到reactor线程的多路复用器Selector上，监听accept事件
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port:" + port);

		} catch (IOException e) {
			String msg = e.getMessage();
		}
	}

	/**
	 * 
	 */
	public void stop() {
		this.stop = true;
	}

	/**
	 * 线程体
	 */
	public void run() {

		while (!stop) {
			try {
				// 4、多路复用器轮询准备就绪的Key
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (IOException e) {
				String msg = e.getMessage();
			}
		}

		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param key
	 * @throws Exception
	 */
	private void handleInput(SelectionKey key) throws Exception {

		if (key.isValid()) {
			if (key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				// 调用read()方法读取请求码流，返回值大于0，表示读到了字节，对字节进行编解码
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order:" + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
							? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
					doWrite(sc, currentTime);

				} else if (readBytes < 0) {
					key.cancel();
					sc.close();
				} else {
				}
			}
		}
	}

	/**
	 * 
	 * @param channel
	 * @param response
	 * @throws IOException
	 */
	private void doWrite(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}

}
