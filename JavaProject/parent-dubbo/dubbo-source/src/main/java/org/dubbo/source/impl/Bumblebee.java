package org.dubbo.source.impl;

import org.dubbo.source.api.Robot;

public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
