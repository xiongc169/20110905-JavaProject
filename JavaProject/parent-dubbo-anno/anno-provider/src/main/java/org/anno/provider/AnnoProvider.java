package org.anno.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.anno.service.GreetService;
import org.anno.provider.config.ProviderConfig;
import org.anno.provider.serviceImpl.GreetServiceImpl;
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
            apiConfig();
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

    private static void apiConfig() throws Exception {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("ProviderY");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20882);

        GreetService greet = new GreetServiceImpl();
        ServiceConfig greetService = new ServiceConfig();
        greetService.setApplication(application);
        greetService.setRegistry(registry);
        greetService.setProtocol(protocol);
        greetService.setInterface(GreetService.class);
        greetService.setRef(greet);

        greetService.export();
        System.out.println("API配置-启动成功");
        System.in.read();
    }
}
