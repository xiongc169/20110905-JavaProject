package org.dubbo.provider;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

/**
 * @Desc Provider
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-4-1
 * <p>
 * @Version 1.0
 */
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
