package org.practice.spring.proxy.ch02dynamic.cglib01;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author yoong
 *
 * @desc CGlib动态代理原理及实现<br>
 *      PS：JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，需要CGLib实现动态代理；
 *          CGLib采用字节码技术，通过字节码技术为一个类创建一个子类，在子类中采用方法拦截技术拦截父类方法的调用，同时织入横切逻辑；
 *          JDK动态代理与CGLib动态代理均是实现Spring AOP的基础；
 *          CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却比JDK多得多，所以对于单例的对象，因为无需频繁创建对象，用CGLib合适；
 *          反之，使用JDK方式要更为合适一些。同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理。
 *      http://blog.csdn.net/yakoo5/article/details/9099133/
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 通过字节码技术，动态创建子类实例
     *
     * @param clazz
     * @return
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

        System.out.println("CglibProxy.intercept Start...");

        // 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(obj, arg2);

        System.out.println("CglibProxy.intercept End");
        return result;
    }

}
