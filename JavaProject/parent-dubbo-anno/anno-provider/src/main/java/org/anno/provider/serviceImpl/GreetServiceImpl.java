package org.anno.provider.serviceImpl;

import org.anno.common.facade.GreetService;

public class GreetServiceImpl implements GreetService {

    @Override
    public String greet(String name) {
        String result = "Hello " + name;
        return result;
    }
}
