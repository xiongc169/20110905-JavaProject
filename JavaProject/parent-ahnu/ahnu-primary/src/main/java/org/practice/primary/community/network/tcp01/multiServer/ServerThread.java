package org.practice.primary.community.network.tcp01.multiServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc ServerThread
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class ServerThread extends Thread {

    private Socket socket = null;

    private InputStream inputStream = null;

    private OutputStream outputStream = null;

    public ServerThread() {
    }

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        byte[] buffer = new byte[1024 * 1024 * 5];
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            int len = inputStream.read(buffer);
            String inStr = new String(buffer, 0, len);
            System.out.printf("【服务端】【%s】接收：%s \r\n", Thread.currentThread().getName(), inStr);

            String outStr = "feedback for " + inStr;
            System.out.printf("【服务端】【%s】返回：%s \r\n", Thread.currentThread().getName(), outStr);
            outputStream.write(outStr.getBytes());
            Thread.sleep(1000);
        } catch (Exception ex) {
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
