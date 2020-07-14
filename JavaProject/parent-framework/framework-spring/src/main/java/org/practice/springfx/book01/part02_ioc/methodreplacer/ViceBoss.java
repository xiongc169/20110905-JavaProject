package org.practice.springfx.book01.part02_ioc.methodreplacer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ViceBoss implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println(obj);
        System.out.println(method);
        System.out.println(args);
        //不能调用原方法，否则陷入死循环
        //Object result = method.invoke(obj, args);
        String result = "I'm ViceBoss";
        System.out.println(result);
        return result;
    }
}
