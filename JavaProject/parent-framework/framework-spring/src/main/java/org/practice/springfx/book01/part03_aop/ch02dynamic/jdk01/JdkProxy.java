package org.practice.springfx.book01.part03_aop.ch02dynamic.jdk01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.practice.springfx.book01.part03_aop.ch01static.proxy.SubjectImpl;
import org.practice.springfx.api.ISubject;

/**
 * @Desc java的动态代理机制详解
 * PS：jdk动态代理机制中，两个重要类或接口(InvocationHandler + Proxy)
 * InvocationHandler.invoke()方法：Object invoke(Object proxy, Method method, Object[] args) throws Throwable
 * Proxy.newProxyInstance()方法：public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler h)  throws IllegalArgumentException
 * 每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。
 * http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
 * <p>
 * 代理模式及JDK动态代理(InvocationHandler)的简单实现与分析
 * PS：实现方式：静态代理、jdk动态代理；
 * jdk动态代理涉及2个类：InvocationHandler + Proxy；
 * https://blog.csdn.net/hello2mao/article/details/52346205
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月20日
 * <p>
 * @Version 1.0
 */
public class JdkProxy {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //jdk动态代理
            jdkProxyTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * jdk动态代理
     */
    public static void jdkProxyTest() {
        try {
            //要代理的真实对象
            ISubject subject = new SubjectImpl();
            InvocationHandler handler = new MyInvocationHandler(subject);
            ClassLoader handlerClassLoader = handler.getClass().getClassLoader();
            ClassLoader subjectClassLoader = subject.getClass().getClassLoader();
            ClassLoader thisClassLoader = JdkProxy.class.getClassLoader();

            /*
             * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
             * 第一个参数handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
             * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
             * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
             */
            ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
            //ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), SubjectImpl.class.getInterfaces(), handler);//效果同上
            subjectProxy.say("JdkProxy", 28);

            String name = subjectProxy.getClass().getName();
            System.out.println(name);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }
}
