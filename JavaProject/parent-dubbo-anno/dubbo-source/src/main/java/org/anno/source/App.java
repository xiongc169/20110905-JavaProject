package org.anno.source;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.extension.SPI;
import org.anno.source.api.Robot;

import java.util.ServiceLoader;

/**
 * @Desc App
 * @Author
 * @Date
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            javaSPI();
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
