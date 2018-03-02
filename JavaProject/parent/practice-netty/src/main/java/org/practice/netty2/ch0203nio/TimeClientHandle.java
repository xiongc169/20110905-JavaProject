package org.practice.netty2.ch0203nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {

	private String host;

	private int port;

	private Selector selector;

	private SocketChannel socketChannel;

	private volatile boolean stop;

	public TimeClientHandle(String host, int port) {
		this.host = host != null ? host : "127.0.0.1";
		this.port = port;

		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			String msg = e.getMessage();
			System.exit(1);
		}
	}

	public void run() {
		// 用于发送连接请求
		try {
			doConnect();
		} catch (IOException e) {
			String msg = e.getMessage();
			System.exit(1);
		}

		// 轮询多路复用器
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	private void handleInput(SelectionKey key) throws Exception {
		if (key.isValid()) {
			SocketChannel sc = (SocketChannel) key.channel();
			if (key.isConnectable()) {
				// finishConnect()方法返回true，表示连接成功
				if (sc.finishConnect()) {
					sc.register(selector, SelectionKey.OP_READ);
					// 发送请求消息给服务端
					doWrite(sc);
				} else {
					System.exit(1);// 连接失败，进程退出
				}
				// 若客户端接收了服务端的应答消息，则SocketChannel是可读的
				if (key.isReadable()) {
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					int readBytes = sc.read(readBuffer);
					if (readBytes > 0) {
						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);
						String body = new String(bytes, "UTF-8");
						System.out.println("Now is : " + body);
						this.stop = true;
					} else if (readBytes < 0) {
						// 对端链路关闭
						key.cancel();
						sc.close();
					} else {
						// 读到0字节，忽略
					}
				}
			}
		}
	}

	private void doConnect() throws IOException {
		if (socketChannel.connect(new InetSocketAddress(host, port))) {
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		} else {
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		}
	}

	private void doWrite(SocketChannel sc) throws IOException {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		sc.write(writeBuffer);
		if (!writeBuffer.hasRemaining()) {
			System.out.println("Send Order to server Succeed");
		}
	}

}
