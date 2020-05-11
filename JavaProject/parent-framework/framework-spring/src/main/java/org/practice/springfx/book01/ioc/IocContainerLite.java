package org.practice.springfx.book01.ioc;

import com.alibaba.fastjson.JSON;
import org.practice.springfx.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class IocContainerLite {

    /**
     * IOC容器测试类
     */
    public static void main(String[] args) {
        try {
            //BeanFactoryPostProcessor
            //BeanPostProcessor
            startContainer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void startContainer() {
        ClassPathXmlApplicationContext cpXmlContext = null;
        FileSystemXmlApplicationContext fsXmlContext = null;

        try {
            cpXmlContext = new ClassPathXmlApplicationContext("ioc/spring-context.xml");
            User user = (User) cpXmlContext.getBean("user_01");
            System.out.println(user.getName() + user.getUserNo());

            fsXmlContext = new FileSystemXmlApplicationContext("classpath:ioc/spring-context.xml");
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
