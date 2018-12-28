package org.practice.spring.proxy.ch02dynamic.cglib01;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @desc CGlib动态代理原理及实现<br>
 *       采用字节码技术，通过字节码技术为一个类创建一个子类，在子类中采用方法拦截技术拦截父类方法的调用，同时织入横切逻辑；<br>
 *       http://blog.csdn.net/yakoo5/article/details/9099133/
 *
 * @author yoong
 *
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public CglibProxy() {
    }

    /**
     * 通过字节码技术，动态创建子类实例
     *
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
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

        System.out.println("CglibProxy.intercept start");

        // 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(obj, arg2);

        System.out.println("CglibProxy.intercept end");
        return result;
    }

}
