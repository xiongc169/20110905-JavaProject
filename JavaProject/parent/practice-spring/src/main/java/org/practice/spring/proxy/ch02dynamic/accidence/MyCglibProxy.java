package org.practice.spring.proxy.ch02dynamic.accidence;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * by myself - 2018年12月29日14:08:11
 */
public class MyCglibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object getCglibProxy(Object object) {
        this.targetObject = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        Object cglibProxy = enhancer.create();
        return cglibProxy;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("MyCglibProxy Start...");
        Object result = methodProxy.invoke(targetObject, objects);//正常
        //Object result = methodProxy.invokeSuper(targetObject, objects);//异常
        //Object result = methodProxy.invoke(obj, objects);//正常
        //Object result = methodProxy.invokeSuper(obj, objects);//正常
        //Object result = method.invoke(obj, objects);//异常
        System.out.println("MyCglibProxy End");
        return result;
    }
}
