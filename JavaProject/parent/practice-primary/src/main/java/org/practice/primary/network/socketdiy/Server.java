package org.practice.primary.network.socketdiy;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc Server
 * @Author
 * @Date
 * @Version 1.0
 */
public class Server {

    public static void main(String[] args) {
        try {
            startup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startup() throws Exception {
        ServerSocket server = new ServerSocket(9090);
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
                System.out.println("Server: " + new String(data));
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
