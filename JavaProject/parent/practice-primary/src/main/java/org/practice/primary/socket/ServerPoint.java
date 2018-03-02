package org.practice.primary.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description ServerPoint.java
 * @author chaoxiong
 * @date 2016年4月4日 上午10:33:52
 * 
 * http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 */
public class ServerPoint {

	public static void main(String[] args) {
		// Byte decodes = Byte.decode("chaoxiong");
		// Byte parse = Byte.parseByte("chaoxiong");

		serverTest();
	}

	public static void serverTest() {
		ServerSocket server = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		int serverPort = 10000;

		try {
			System.out.println("【服务端】服务端已启动！");
			server = new ServerSocket(serverPort);
			socket = server.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			do {
				byte[] inBytes = new byte[1024];
				int len = is.read(inBytes);
				String inStr = new String(inBytes, 0, len);
				System.out.println("【服务端】服务端接收到信息：" + inStr);

				String outMsg = "feedback for " + inStr;
				os.write(outMsg.getBytes());
			} while (true);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
				socket.close();
				server.close();
				System.out.println("【服务端】服务端已停止！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
