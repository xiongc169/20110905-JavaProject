package org.practice.junior.community.network.tcp01.multiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc MultiServerSocket
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class MultiServerSocket {

    private static int serverPort = 10007;

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

        try {
            System.out.println("【服务端】已启动！");
            serverSocket = new ServerSocket(serverPort);
            while (true) {
                socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                System.out.println("【服务端】已停止！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
