package org.practice.primary.community.network.tcp02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc SocketPoint-DIY
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class SocketPoint {

    private static String serverIP = "127.0.0.1";

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
        Socket client = new Socket(serverIP, serverPort);
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
