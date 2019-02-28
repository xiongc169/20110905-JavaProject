package org.practice.primary.network.socket.multiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @desc MultiServerPoint.java
 * @author chaoxiong
 * @date 2016年4月4日 下午3:20:53
 */
public class MultiServerPoint {

	public static void main(String[] args) {
		multiServerPoint();
	}

	public static void multiServerPoint() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 10000;

		try {
			System.out.println("【服务端】服务端已启动！");
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			while (true) {
				new LogicServerThread(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
				System.out.println("【服务端】服务端已停止！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
