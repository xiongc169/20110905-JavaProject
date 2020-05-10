package org.practice.springfx.book01.part03_aop.ch02dynamic.jdk01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.practice.springfx.book01.part03_aop.ch01static.proxy.SubjectImpl;
import org.practice.springfx.api.ISubject;

/**
 * @Desc java的动态代理机制详解 <br>
 * PS：jdk动态代理机制中，两个重要类或接口(InvocationHandler + Proxy)<br>
 * http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
 * <p>
 * 代理模式及JDK动态代理(InvocationHandler)的简单实现与分析 <br>
 * PS：实现方式：静态代理、jdk动态代理；<br>
 * https://blog.csdn.net/hello2mao/article/details/52346205
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月20日
 * <p>
 * @Version 1.0
 */
public class Client {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        //jdk动态代理
        jdkProxyTest();
    }

    /**
     * jdk动态代理
     */
    public static void jdkProxyTest() {
        try {
            ISubject subject = new SubjectImpl();
            InvocationHandler handler = new JdkProxy(subject);
            ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
            //ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);//效果同上
            subjectProxy.say("JDK Proxy", 28);

            String name = subjectProxy.getClass().getName();
            System.out.println(name);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }
}
