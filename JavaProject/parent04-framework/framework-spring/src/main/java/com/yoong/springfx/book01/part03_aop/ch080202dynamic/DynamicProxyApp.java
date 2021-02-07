package com.yoong.springfx.book01.part03_aop.ch080202dynamic;

import com.yoong.springfx.api.ICalculator;
import com.yoong.springfx.api.ISubject;
import com.yoong.springfx.api.impl.CalculatorImpl;
import com.yoong.springfx.book01.part03_aop.ch080202dynamic.accidence.MyCglibProxy;
import com.yoong.springfx.book01.part03_aop.ch080202dynamic.accidence.MyJdkProxy;
import com.yoong.springfx.book01.part03_aop.ch080202dynamic.summary.CglibProxy;
import com.yoong.springfx.book01.part03_aop.ch080202dynamic.summary.JdkProxy;
import com.yoong.springfx.api.impl.SubjectImpl;

/**
 * @Desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC <br>
 * PS：业务逻辑+横切关注点；静态代理、动态代理(JDK动态代理、Cglib动态代理)、使用Spring实现AOP、使用IOC配置的方式实现AOP、使用XML配置Spring AOP切面<br>
 * http://www.cnblogs.com/best/p/5679656.html
 * <p>
 * java动态代理（JDK和cglib）
 * PS：静态代理：由程序员创建或特定工具自动生成源代码，再对其编译，在程序运行前，代理类的.class文件就已经存在；<br>
 * 动态代理：在程序运行时，运用反射机制动态创建而成；<br>
 * JDK动态代理中包含一个类和一个接口，即InvocationHandler + Proxy；<br>
 * JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理，这就要使用cglib动态代理；<br>
 * cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理；<br>
 * http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * <p>
 * 两个InvocationHandler接口：java.lang.reflect.InvocationHandler、org.springframework.cglib.ch08proxy.InvocationHandler
 * JDK动态代理：InvocationHandler + Proxy
 * CGLIB动态代理：MethodInterceptor + Enhancer
 * <p>
 * PS：CGlib的 MethodInterceptor 接口：org.springframework.cglib.proxy.MethodInterceptor
 * SpringAOP的 MethodInterceptor 接口：org.aopalliance.intercept.MethodInterceptor
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月9日
 * <p>
 * @Version yoong
 */
public class DynamicProxyApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            accidenceTest();
            jdkProxyTest2();
            cglibProxyTest2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * accidence - 2018年12月29日14:08:11 - by myself
     */
    public static void accidenceTest() {
        ISubject subject = new SubjectImpl();

        MyJdkProxy myJdkProxy = new MyJdkProxy();
        MyCglibProxy myCglibProxy = new MyCglibProxy();

        ISubject subjectJdkProxy = (ISubject) myJdkProxy.getJdkProxy(subject);
        ISubject subjectCglibProxy = (ISubject) myCglibProxy.getCglibProxy(subject);

        subjectJdkProxy.say("myJdkProxy", 123);
        subjectCglibProxy.say("myCglibProxy", 321);
    }


    /**
     * summary-jdk 动态代理
     */
    public static void jdkProxyTest2() {
        try {
            ICalculator calcImpl = new CalculatorImpl();
            JdkProxy jdkProxy = new JdkProxy(calcImpl);
            ICalculator calcProxy = (ICalculator) jdkProxy.getProxyObject(calcImpl);
            Object result = calcProxy.add(100, 200);
            System.out.println(result);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }

    /**
     * summary-cglib 动态代理
     */
    public static void cglibProxyTest2() {
        try {
            ICalculator calcImpl = new CalculatorImpl();
            CglibProxy dynamicProxy = new CglibProxy();
            ICalculator calcProxy = (ICalculator) dynamicProxy.getProxy(calcImpl);
            Object result = calcProxy.div(200, 10);
            System.out.println(result);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }
}
