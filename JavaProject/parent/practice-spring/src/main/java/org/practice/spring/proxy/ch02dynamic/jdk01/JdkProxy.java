package org.practice.spring.proxy.ch02dynamic.jdk01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
public class JdkProxy implements InvocationHandler {
	// 代理的真实对象
	private Object subject;

	// 构造方法，给我们要代理的真实对象赋初值
	public JdkProxy(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		// 在代理真实对象前我们可以添加一些自己的操作
		System.out.println("before rent house");

		System.out.println("Method:" + method);

		// 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		Object result = method.invoke(subject, args);

		// 在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("after rent house");

		return result;
	}
}
