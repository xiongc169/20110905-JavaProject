package org.practice.springfx.book01.part03_aop.ch02dynamic.summary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC
 * PS：Jdk动态代理 <br>
 * http://www.cnblogs.com/best/p/5679656.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月20日
 * <p>
 * @Version 1.0
 */
public class JdkProxy implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object object = null;

    public JdkProxy(Object target) {
        this.object = target;
    }

    /**
     * 获取代理对象
     *
     * @param target 被代理的对象
     * @return 代理对象
     */
    public Object getProxyObject(Object target) {
        this.object = target;
        // loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来生成代理对象进行加载
        // interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
        // h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上，间接通过invoke来执行
        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return obj;
    }

    /**
     * 调用方法 ch08proxy: 指代我们所代理的那个真实对象 method: 指代的是我们所要调用真实对象的某个方法的Method对象 args:
     * 指代的是调用真实对象某个方法时接受的参数
     *
     * @param proxy  代理对象
     * @param method 将要被执行的方法信息（反射）
     * @param args   执行方法时需要的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("JdkProxy.invoke Start...");
        Object result = method.invoke(object, args);
        // System.out.println("Proxy:" + ch08proxy);
        System.out.println("Method:" + method);
        System.out.println("JdkProxy.invoke End");
        return result;
    }

}
