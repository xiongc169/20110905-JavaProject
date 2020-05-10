package org.practice.springfx.book01.proxy.ch02dynamic.summary;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author yoong
 *
 * @desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC
 *      PS：Cglib动态代理类，实现方法拦截器接口<br>
 *      http://www.cnblogs.com/best/p/5679656.html
 *
 * @date 2016年8月20日
 */
public class CglibProxy implements MethodInterceptor {

    private Object target = null;

    public Object getProxy(Object target) {
        this.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        Object proxy = enhancer.create();

        return proxy;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("CglibProxy.intercept Start...");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("CglibProxy.intercept End");
        return result;
    }

}
