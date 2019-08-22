package org.anno.consumer;

import org.anno.consumer.config.ConsumerConfig;
import org.anno.consumer.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

/**
 * AnnoConsumer
 */
public class AnnoConsumer {

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

    private static void xml() {
        FileSystemXmlApplicationContext fs = new FileSystemXmlApplicationContext(new String[]{"classpath:anno-consumer.xml"});
        fs.start();
        UserController userCtr = (UserController) fs.getBean("userController");
        double result = userCtr.calculator.add(100, 200);
        double result2 = userCtr.calculator.sub(100, 200);
        double result3 = userCtr.calculator.mul(100, 200);
        double result4 = userCtr.calculator.div(100, 200);
        System.out.println(result + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n");

        String userName = userCtr.userDao.getUserName();
        System.out.println(userName);
    }

    private static void annotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        context.start();
        UserController userCtr = (UserController) context.getBean("userController");
        double result = userCtr.calculator.add(100, 200);
        double result2 = userCtr.calculator.sub(100, 200);
        double result3 = userCtr.calculator.mul(100, 200);
        double result4 = userCtr.calculator.div(100, 200);
        System.out.println(result + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n");

        String userName = userCtr.userDao.getUserName();
        System.out.println(userName);
    }
}
