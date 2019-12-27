package org.practice.primary.community.network.tcp01.multiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc MultiServerPoint
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class MultiServerPoint {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            multiServerPoint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void multiServerPoint() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int port = 10000;

        try {
            System.out.println("【服务端】服务端已启动！");
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            while (true) {
                new LogicServerThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                System.out.println("【服务端】服务端已停止！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
