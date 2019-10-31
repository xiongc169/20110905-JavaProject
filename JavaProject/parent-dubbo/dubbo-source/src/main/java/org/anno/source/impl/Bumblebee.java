package org.anno.source.impl;

import org.anno.source.api.Robot;

/**
 * @Desc OptimusPrime
 * @Author
 * @Date
 * @Version 1.0
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
