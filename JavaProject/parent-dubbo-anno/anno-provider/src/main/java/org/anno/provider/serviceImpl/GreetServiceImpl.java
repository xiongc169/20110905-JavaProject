package org.anno.provider.serviceImpl;

import org.anno.common.service.GreetService;

/**
 * @Desc GreetImpl
 * @Author
 * @Date
 * @Version 1.0
 */
public class GreetServiceImpl implements GreetService {

    @Override
    public String greet(String name) {
        String result = "Hello " + name;
        return result;
    }
}
