package org.dubbo.provider;

import java.util.Scanner;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Provider {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:provider.xml"});
            fsContext.start();
            System.out.println("启动成功！");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            System.out.println(input);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
