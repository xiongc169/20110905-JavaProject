package org.practice.spring.proxy.ch02dynamic.jdk01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.practice.spring.proxy.api.ISubject;
import org.practice.spring.proxy.ch01static.SubjectImpl;

/**
 * @author yoong
 *
 * @desc java的动态代理机制详解 <br>
 *       PS：jdk动态代理机制中，两个重要类或接口(InvocationHandler + Proxy)<br>
 *       http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
 *
 * @date 2016年8月20日
 *
 */
public class Client {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
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
			subjectProxy.say("yoong JDK", 28);

			String name = subjectProxy.getClass().getName();
			System.out.println(name);
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}
}
