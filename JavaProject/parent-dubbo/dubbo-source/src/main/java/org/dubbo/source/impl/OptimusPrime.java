package org.dubbo.source.impl;

import org.dubbo.source.api.Robot;

/**
 * @Desc OptimusPrime
 * @Author
 * @Date
 * @Version 1.0
 */
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}
