package org.practice.primary.network.socketdiy;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc Client
 * @Author
 * @Date 2019年2月28日16:54:21
 * @Version 1.0
 */
public class TCPClient {

    public static void main(String[] args) {
        try {
            startup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startup() throws Exception {
        Socket client = new Socket("127.0.0.1", 9090);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        try {
            for (int i = 0; i < 5; i++) {
                String msg = "Message " + i;
                System.out.println("Client Request: " + msg);
                os.write(msg.getBytes());
                byte[] resposne = new byte[1024];
                is.read(resposne);
                System.out.println("Client Response: " + new String(resposne));
                Thread.sleep(2000);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            is.close();
            os.close();
            client.close();
        }
    }
}
