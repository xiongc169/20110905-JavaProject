package org.practice.cheguo.launcher;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
            application.start();
            System.out.println("启动成功");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
