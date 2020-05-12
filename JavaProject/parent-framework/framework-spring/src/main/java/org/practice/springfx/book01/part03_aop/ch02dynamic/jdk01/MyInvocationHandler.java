package org.practice.springfx.book01.part03_aop.ch02dynamic.jdk01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Desc JDK动态代理
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月20日
 * <p>
 * @Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

    // 代理的真实对象
    private Object targetObject;

    // 构造方法，给我们要代理的真实对象赋初值
    public MyInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        // 在代理真实对象前我们可以添加一些自己的操作
        System.out.println("MyInvocationHandler.invoke Start...");

        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object result = method.invoke(this.targetObject, args);

        // 在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("MyInvocationHandler.invoke End");

        return result;
    }
}
