package org.practice.primary.community.network.tcp01.multiServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc MultiSocket
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class MultiSocket {

    private static String serverIP = "127.0.0.1";

    private static int serverPort = 10007;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                multiClientTest(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void multiClientTest(Integer index) {
        Socket client = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            System.out.printf("【客户端-%s】已启动！\r\n", index);
            client = new Socket(serverIP, serverPort);
            os = client.getOutputStream();
            is = client.getInputStream();
            byte[] feedback = new byte[1024];
            String message = "this is lianzhuang Dept " + index;
            System.out.printf("【客户端-%s】发送：%s\r\n", index, message);
            os.write(message.getBytes());

            int len = is.read(feedback);
            System.out.printf("【客户端-%s】接收：%s\r\n", index, new String(feedback, 0, len));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                client.close();
                System.out.printf("【客户端-%s】已停止！\r\n", index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
