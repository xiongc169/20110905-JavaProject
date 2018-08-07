package org.practice.spring.proxy.dynamic;

import java.lang.reflect.Proxy;

import org.practice.spring.proxy.dynamic.cglib.CGlibDynamicProxy;
import org.practice.spring.proxy.dynamic.jdk.JDKDynamicPorxy;
import org.practice.spring.proxy.dynamic.jdk.RealSubject;
import org.practice.spring.proxy.dynamic.jdk.Subject;

public class App {

	public static void main(String[] args) {

		jdkDynamicProxy();
		// cglibDynamicProxy();
	}

	/**
	 * JDK动态代理
	 */
	public static void jdkDynamicProxy() {

		try {
			Subject subject = new RealSubject();
			JDKDynamicPorxy handler = new JDKDynamicPorxy(subject);
			Subject proxySub = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
			proxySub.say("chaochao", 28);

			// Subject subject = new RealSubject();
			// JDKDynamicPorxy handler = new JDKDynamicPorxy(subject);
			// Subject subjectProxy = (Subject) handler.bind(subject);
			// subjectProxy.say("chaochao", 28);

			String name = proxySub.getClass().getName();
			System.out.println(name);

		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}

	/**
	 * CGlib动态代理
	 */
	public static void cglibDynamicProxy() {
		try {
			CGlibDynamicProxy cglibProxy = new CGlibDynamicProxy();
			RealSubject subject = (RealSubject) cglibProxy.getProxy(RealSubject.class);
			subject.say("chaoxiong", 288);
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}
	}
}
