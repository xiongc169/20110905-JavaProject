package org.practice.primary.community.network.tcp02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc TcpServer-DIY
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class TcpServer {

    private static int serverPort = 9090;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            startup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startup() throws Exception {
        ServerSocket server = new ServerSocket(serverPort);
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            socket = server.accept();
            is = socket.getInputStream();
            os = socket.getOutputStream();
            do {
                byte[] data = new byte[1000];
                is.read(data);
                System.out.println("Server Receive: " + new String(data));
                String response = "Response for " + new String(data);
                System.out.println("Server Return: " + response);
                os.write(response.getBytes());
            } while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}
