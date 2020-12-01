package org.dubbo.provider.anno.serviceImpl;

import org.dubbo.common.anno.facade.GreetService;

public class GreetServiceImpl implements GreetService {

    @Override
    public String greet(String name) {
        String result = "Hello " + name;
        return result;
    }
}
