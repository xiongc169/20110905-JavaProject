package org.practice.spring.proxy.ch02dynamic;

import org.practice.spring.proxy.api.ICalculator;
import org.practice.spring.proxy.ch01static.CalculatorImpl;
import org.practice.spring.proxy.ch01static.SubjectImpl;
import org.practice.spring.proxy.ch02dynamic.cglib01.CglibProxy;
import org.practice.spring.proxy.ch02dynamic.jdk02.JdkPorxy;

/**
 * @author yoong
 *
 * @desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC <br>
 *       PS：业务逻辑+横切关注点；静态代理、动态代理(JDK动态代理、Cglib动态代理)、使用Spring实现AOP、使用XML配置方式实现AOP<br>
 *       http://www.cnblogs.com/best/p/5679656.html
 * 
 *       java动态代理（JDK和cglib）
 *       PS：静态代理：由程序员创建或特定工具自动生成源代码，再对其编译，在程序运行前，代理类的.class文件就已经存在；<br>
 *       动态代理：在程序运行时，运用反射机制动态创建而成；<br>
 *       JDK动态代理中包含一个类和一个接口，即InvocationHandler + Proxy；<br>
 *       JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理，这就要使用cglib动态代理；<br>
 *       cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理；<br>
 *       http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * 
 *       代理模式及JDK动态代理(InvocationHandler)的简单实现与分析 <br>
 *       PS：实现方式：静态代理、jdk动态代理；<br>
 *       https://blog.csdn.net/hello2mao/article/details/52346205
 * 
 *       两个InvocationHandler接口：java.lang.reflect.InvocationHandler、org.springframework.cglib.proxy.InvocationHandler
 *
 * @date 2016年8月9日
 *
 */
public class DynamicApp {

	public static void main(String[] args) {
		jdkProxyTest2();
		cglibProxyTest();
		cglibProxyTest2();
	}

	/**
	 * jdk02 动态代理
	 */
	public static void jdkProxyTest2() {
		try {
			ICalculator calcImpl = new CalculatorImpl();
			JdkPorxy jdkProxy = new JdkPorxy(calcImpl);
			ICalculator calcProxy = (ICalculator) jdkProxy.getProxyObject(calcImpl);
			Object result = calcProxy.add(100, 200);
			System.out.println(result);
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}

	/**
	 * cglib01 动态代理
	 */
	public static void cglibProxyTest() {
		try {
			CglibProxy cglibProxy = new CglibProxy();
			SubjectImpl subject = (SubjectImpl) cglibProxy.getProxy(SubjectImpl.class);
			subject.say("yong Cglib", 288);
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}

	/**
	 * cglib02 动态代理
	 */
	public static void cglibProxyTest2() {
		try {
			ICalculator calcImpl = new CalculatorImpl();
			org.practice.spring.proxy.ch02dynamic.cglib02.CglibProxy dynamicProxy = new org.practice.spring.proxy.ch02dynamic.cglib02.CglibProxy();
			ICalculator calcProxy = (ICalculator) dynamicProxy.getProxy(calcImpl);
			Object result = calcProxy.div(200, 10);
			System.out.println(result);
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}
}
