package org.practice.primary.book02.chap03;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》第三章、网络
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppNetwork {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            socket();
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
}
