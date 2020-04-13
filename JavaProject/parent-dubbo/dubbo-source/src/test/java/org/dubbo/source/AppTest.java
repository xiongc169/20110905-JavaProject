package org.dubbo.source;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.dubbo.source.api.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @Desc App
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppTest {

    @Test
    public void javaSPI() {
        System.out.println("javaSPI Start");
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        serviceLoader.forEach(Robot::sayHello);
        System.out.println("javaSPI End");
    }

    @Test
    public void dubboSPI() {
        System.out.println("dubboSPI Start");
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
        System.out.println("dubboSPI End");
    }
}
