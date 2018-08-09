package org.practice.spring.proxy.ch02dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @desc JdkPorxy
 * 
 * @author yoong
 *
 */
public class JdkPorxy implements InvocationHandler {

	private Object object = null;

	public JdkPorxy(Object target) {
		this.object = target;
	}

	/**
	 * 绑定委托对象并返回一个代理类
	 * 
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.object = target;
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return obj;
	}

	/**
	 * 调用方法 proxy: 指代我们所代理的那个真实对象 method: 指代的是我们所要调用真实对象的某个方法的Method对象 args:
	 * 指代的是调用真实对象某个方法时接受的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("JdkPorxy.invoke start");
		Object result = method.invoke(object, args);
		// System.out.println("Proxy:" + proxy);
		System.out.println("Method:" + method);
		System.out.println("JdkPorxy.invoke end");
		return result;
	}

}
