package org.practice.book02.chap03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》
 * 第三章、网络
 * @Author
 * @Date
 * @Version 1.0
 */
public class NetworkUtils {

    private static int port = 9999;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            socket();
            socket4Local();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void socket() throws Exception {
        Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13);
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void socket4Local() throws Exception {
        Socket socket = new Socket("127.0.0.1", port);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(100);

        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

}
