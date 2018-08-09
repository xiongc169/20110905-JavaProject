package org.practice.spring.proxy.ch02dynamic;

import java.lang.reflect.Proxy;

import org.practice.spring.proxy.api.ISubject;
import org.practice.spring.proxy.ch01static.SubjectImpl;
import org.practice.spring.proxy.ch02dynamic.cglib.CglibProxy;
import org.practice.spring.proxy.ch02dynamic.jdk.JdkPorxy;

/**
 * @author yoong
 *
 * @desc java的动态代理机制详解 <br>
 *       PS：java的动态代理机制中，两个重要类或接口(InvocationHandler + Proxy)<br>
 *       http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
 * 
 *       java动态代理（JDK和cglib）
 *       PS：静态代理：由程序员创建或特定工具自动生成源代码，再对其编译，在程序运行前，代理类的.class文件就已经存在；<br>
 *       动态代理：在程序运行时，运用反射机制动态创建而成；<br>
 *       JDK动态代理中包含一个类和一个接口，即InvocationHandler + Proxy；<br>
 *       JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理，这就要使用cglib动态代理；<br>
 *       cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理；<br>
 *       http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 *
 * @date 2016年8月9日
 *
 */
public class App {

	public static void main(String[] args) {
		jdkProxyTest();
		cglibProxyTest();
	}

	/**
	 * jdk动态代理
	 */
	public static void jdkProxyTest() {
		try {
			ISubject subject = new SubjectImpl();
			JdkPorxy handler = new JdkPorxy(subject);
			ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
			subjectProxy.say("yoong JDK", 28);

			String name = subjectProxy.getClass().getName();
			System.out.println(name);

		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}

	/**
	 * cglib动态代理
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
}
