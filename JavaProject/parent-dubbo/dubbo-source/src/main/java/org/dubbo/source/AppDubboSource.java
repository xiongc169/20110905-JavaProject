package org.dubbo.source;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.extension.SPI;
import org.dubbo.source.api.Robot;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Desc Dubbo SPI
 * https://dubbo.apache.org/zh/docs/v2.7/dev/source/dubbo-spi
 * https://www.jianshu.com/p/3a3edbcd8f24
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-7-4
 * <p>
 * @Version 1.0
 */
public class AppDubboSource {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            javaSPI();
            sunSPI();
            dubboSPI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void javaSPI() {
        System.out.println("javaSPI Start");
        ServiceLoader<Robot> loader = ServiceLoader.load(Robot.class);
        loader.forEach(Robot::sayHello);
        System.out.println("javaSPI End");
    }

    public static void sunSPI() {
        System.out.println("sunSPI Start");
        Iterator<Robot> providers = Service.providers(Robot.class);
        while (providers.hasNext()) {
            Robot ser = providers.next();
            ser.sayHello();
        }
        System.out.println("sunSPI End");
    }

    public static void dubboSPI() {
        System.out.println("dubboSPI Start");
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        Robot optimusPrime2 = extensionLoader.getExtension("optimusPrime");
        optimusPrime2.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
        System.out.println("dubboSPI End");
    }

    public static void reflect() {
        Class robotClz = Robot.class;
        boolean isPresent = robotClz.isAnnotationPresent(SPI.class);
        System.out.println(isPresent);
    }
}
