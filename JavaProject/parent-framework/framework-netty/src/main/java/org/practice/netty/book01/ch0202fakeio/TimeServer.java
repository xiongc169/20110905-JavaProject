package org.practice.netty.book01.ch0202fakeio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.practice.netty.book01.ch0201bio.TimeServerHandler;

/**
 * 伪异步IO
 */
public class TimeServer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {
                String msg = e.getMessage();
            }
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            Socket socket = null;
            System.out.println("The time server is start in port :" + port);
            TimeServerHandlerExecutorPool executor = new TimeServerHandlerExecutorPool(10, 20);
            while (true) {
                socket = server.accept();
                executor.execute(new TimeServerHandler(socket));
            }

        } catch (Exception e) {
            String msg = e.getMessage();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }

    }

}
