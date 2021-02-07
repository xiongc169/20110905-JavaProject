package com.yoong.springfx.book01.part02_ioc;

import com.alibaba.fastjson.JSON;
import com.yoong.springfx.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Desc 《Spring揭秘》第二部分、Spring的IoC容器
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public class IocContainerLite {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            startContainer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startContainer() {
        ClassPathXmlApplicationContext cpXmlContext = null;
        FileSystemXmlApplicationContext fsXmlContext = null;

        try {
            cpXmlContext = new ClassPathXmlApplicationContext("book01/ioc/spring0401-context.xml");
            User user = (User) cpXmlContext.getBean("user_01");
            System.out.println(user.getName() + user.getUserNo());

            fsXmlContext = new FileSystemXmlApplicationContext("classpath:book01/ioc/spring0401-context.xml");
            User user2 = (User) fsXmlContext.getBean("user_02");
            System.out.println(user2.getName() + user2.getUserNo());

            List<String> beanNames = Arrays.asList(cpXmlContext.getBeanDefinitionNames());
            System.out.println(JSON.toJSONString(beanNames));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cpXmlContext != null) {
                cpXmlContext.close();
            }
            if (fsXmlContext != null) {
                fsXmlContext.close();
            }
        }
    }
}
