package org.practice.springfx.book01.proxy.ch02dynamic;

import org.practice.springfx.book01.proxy.api.ICalculator;
import org.practice.springfx.book01.proxy.api.ISubject;
import org.practice.springfx.book01.proxy.ch01static.CalculatorImpl;
import org.practice.springfx.book01.proxy.ch01static.SubjectImpl;
import org.practice.springfx.book01.proxy.ch02dynamic.accidence.MyCglibProxy;
import org.practice.springfx.book01.proxy.ch02dynamic.accidence.MyJdkProxy;
import org.practice.springfx.book01.proxy.ch02dynamic.cglib01.CglibProxy;
import org.practice.springfx.book01.proxy.ch02dynamic.summary.JdkProxy;

/**
 * @author yoong
 *
 * @desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC <br>
 *      PS：业务逻辑+横切关注点；静态代理、动态代理(JDK动态代理、Cglib动态代理)、使用Spring实现AOP、使用IOC配置的方式实现AOP、使用XML配置Spring AOP切面<br>
 *      http://www.cnblogs.com/best/p/5679656.html
 * <p>
 *      java动态代理（JDK和cglib）
 *      PS：静态代理：由程序员创建或特定工具自动生成源代码，再对其编译，在程序运行前，代理类的.class文件就已经存在；<br>
 *      动态代理：在程序运行时，运用反射机制动态创建而成；<br>
 *      JDK动态代理中包含一个类和一个接口，即InvocationHandler + Proxy；<br>
 *      JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理，这就要使用cglib动态代理；<br>
 *      cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理；<br>
 *      http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * <p>
 *      两个InvocationHandler接口：java.lang.reflect.InvocationHandler、org.springframework.cglib.ch08proxy.InvocationHandler
 *      JDK动态代理：InvocationHandler + Proxy
 *      CGLIB动态代理：MethodInterceptor + Enhancer
 *
 * @date 2016年8月9日
 */
public class DynamicApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            cglibProxyTest();
            jdkProxyTest2();
            cglibProxyTest2();
            accidenceTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * cglib01 动态代理
     */
    public static void cglibProxyTest() {
        try {
            CglibProxy cglibProxy = new CglibProxy();
            SubjectImpl subject = (SubjectImpl) cglibProxy.getProxy(SubjectImpl.class);
            subject.say("Cglib Proxy", 100);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
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
            org.practice.springfx.book01.proxy.ch02dynamic.summary.CglibProxy dynamicProxy = new org.practice.springfx.book01.proxy.ch02dynamic.summary.CglibProxy();
            ICalculator calcProxy = (ICalculator) dynamicProxy.getProxy(calcImpl);
            Object result = calcProxy.div(200, 10);
            System.out.println(result);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }

    /**
     * by myself - 2018年12月29日14:08:11
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
}
