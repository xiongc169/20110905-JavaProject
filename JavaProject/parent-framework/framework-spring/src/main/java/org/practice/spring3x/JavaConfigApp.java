package org.practice.spring3x;

import org.practice.spring3x.config.JmsConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc JavaConfigApp
 * @Author
 * @Date
 * @Version 1.0
 */
public class JavaConfigApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JmsConfig.class);
        context.getBean("student");
        System.out.println();
    }
}
