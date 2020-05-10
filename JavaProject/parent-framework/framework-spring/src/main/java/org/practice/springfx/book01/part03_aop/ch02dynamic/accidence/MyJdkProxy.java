package org.practice.springfx.book01.part03_aop.ch02dynamic.accidence;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc MyJdkProxy
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年12月29日14:08:11
 * <p>
 * @Version 1.0
 */
public class MyJdkProxy implements InvocationHandler {

    private Object targetObject;

    public Object getJdkProxy(Object object) {
        this.targetObject = object;
        Object jdkProxy = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        return jdkProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyJdkProxy Start...");
        Object result = method.invoke(targetObject, args);//正常
        //Object result = method.invoke(ch08proxy, args);//异常
        System.out.println("MyJdkProxy End");
        return result;
    }
}
