package com.yoong.junior.community.network.tcp01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc SocketTest
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class SocketTest {

    private static String serverIP = "127.0.0.1";

    private static int serverPort = 10007;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            clientTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clientTest() {
        Socket client = null;
        InputStream is = null;
        OutputStream os = null;
        String message = "this is lianzhuang Dept";
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("【客户端】客户端已启动！");

            client = new Socket(serverIP, serverPort);
            os = client.getOutputStream();
            is = client.getInputStream();
            byte[] feedback = new byte[1024];
            for (int i = 0; i < 10; i++) {
                System.out.println("【客户端】请输入信息内容：");
                message = sc.nextLine();
                os.write(message.getBytes());//发送数据
                int len = is.read(feedback);//接收数据
                System.out.println("【客户端】服务器的反馈信息" + new String(feedback, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                client.close();
                System.out.println("客户端已停止！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
