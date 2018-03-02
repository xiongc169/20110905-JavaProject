package org.practice.primary.proxyDynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 20170523-动态代理类 <br>
 * http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
 * http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * 
 * @author Administrator
 *
 */
public class JDKDynamicPorxy implements InvocationHandler {

	private Object object = null;

	public JDKDynamicPorxy(Object target) {
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
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				this);
		return obj;

	}

	/**
	 * 调用方法
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("Before Invoke...");
		Object result = method.invoke(object, args);
		// System.out.println("Proxy:" + proxy);
		System.out.println("Method:" + method);
		System.out.println("After Invoke...");
		return result;
	}

}
