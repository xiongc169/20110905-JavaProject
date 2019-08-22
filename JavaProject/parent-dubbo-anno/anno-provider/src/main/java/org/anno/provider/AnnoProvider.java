package org.anno.provider;

import org.anno.provider.config.ProviderConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 */
public class AnnoProvider {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            xml();
            annotation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void xml() throws Exception {
        FileSystemXmlApplicationContext fs = new FileSystemXmlApplicationContext(new String[]{"classpath:anno-provider.xml"});
        fs.start();
        System.out.println("启动成功");
        int input = System.in.read();
        System.out.println(input);
    }

    private static void annotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfig.class);
        context.start();
        System.out.println("启动成功(注解方式)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("启动结束：" + input);
    }
}
