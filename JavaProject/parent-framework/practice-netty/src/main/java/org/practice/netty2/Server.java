package org.practice.netty2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		int port = 8099;

		ServerSocket server = null;

		try {
			server = new ServerSocket(port);

			while (true) {
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				byte[] result = new byte[1000];
				is.read(result);
				String str = result.toString();
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
