package com.yoong.springfx.book01.part03_aop.ch080202dynamic.summary;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC
 * PS：Cglib动态代理类，实现方法拦截器接口
 * http://www.cnblogs.com/best/p/5679656.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月20日
 * <p>
 * @Version 1.0
 */
public class CglibProxy implements MethodInterceptor {

    private Object targetObject = null;

    public Object getProxy(Object targetObject) {
        this.targetObject = targetObject;

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(targetObject.getClass());
        Object proxy = enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxy.intercept Start...");
        Object result = methodProxy.invoke(targetObject, objects);
        System.out.println("CglibProxy.intercept End");
        return result;
    }

}
