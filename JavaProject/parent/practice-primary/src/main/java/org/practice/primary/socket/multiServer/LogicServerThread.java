package org.practice.primary.socket.multiServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description LogicServerThread.java
 * @author chaoxiong
 * @date 2016年4月4日 下午3:21:53
 */
public class LogicServerThread extends Thread {

	Socket socket = null;

	InputStream is = null;

	OutputStream os = null;

	public LogicServerThread() {
	}

	public LogicServerThread(Socket socket) {
		this.socket = socket;
		start();
	}

	public void run() {

		byte[] msg = new byte[1024];
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();

			int len = is.read(msg);
			String inStr = new String(msg);
			System.out.println("【服务端】服务端接收到信息：" + inStr);
			
			String outStr = "feedback for " + inStr;
			os.write(outStr.getBytes());
		} catch (Exception ex) {
		} finally {
			try {
				os.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
