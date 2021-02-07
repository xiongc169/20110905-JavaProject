package com.yoong.springfx.book01.part03_aop.ch080202dynamic.cglib01;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Desc CGlib动态代理
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年12月29日14:08:11
 * <p>
 * @Version 1.0
 */
public class MyMethodInterceptor implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 通过字节码技术，动态创建子类实例
     */
    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        Object obj = enhancer.create();
        return obj;
    }

    /**
     * 拦截目标类方法的调用
     *
     * @param obj         表示目标类的实例
     * @param arg1        为目标类方法的反射对象
     * @param arg2        为方法的动态入参
     * @param methodProxy 为代理类实例
     * @return
     */
    public Object intercept(Object obj, Method arg1, Object[] arg2, MethodProxy methodProxy) throws Throwable {

        System.out.println("MyMethodInterceptor.intercept Start...");

        // 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(obj, arg2);

        System.out.println("MyMethodInterceptor.intercept End");
        return result;
    }

}
