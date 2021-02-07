package com.yoong.netty4.book01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/**
	 * 入口函数
	 */
	public static void main(String[] args) {
		int port = 8099;
		Socket client = null;

		try {
			client = new Socket("127.0.0.1", port);
			PrintWriter out = new PrintWriter(client.getOutputStream());
			out.println("Hello");
			out.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
