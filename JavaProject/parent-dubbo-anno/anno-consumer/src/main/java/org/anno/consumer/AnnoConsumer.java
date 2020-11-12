package org.anno.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.anno.common.facade.GreetService;
import org.anno.consumer.config.ConsumerConfig;
import org.anno.consumer.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Desc AnnoConsumer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年6月28日14:09:29
 * <p>
 * @Version 1.0
 */
public class AnnoConsumer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            xml();
            annotation();
            apiConfig();
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

    private static void apiConfig() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("ConsumerY");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig reference = new ReferenceConfig();
        reference.setInterface(GreetService.class);
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setTimeout(100000);
        GreetService greet = (GreetService) reference.get();
        String result = greet.greet("ASDFGHJKL");
        System.out.println(result);
    }
}
