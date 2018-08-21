package org.practice.spring.proxy.ch02dynamic.cglib02;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author yoong
 *
 * @desc Cglib动态代理类，实现方法拦截器接口<br>
 *       http://www.cnblogs.com/best/p/5679656.html
 *
 * @date 2016年8月20日
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Object target = null;

	public Object getProxy(Object target) {
		this.target = target;

		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(target.getClass());
		Object proxy = enhancer.create();

		return proxy;
	}

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		System.out.println("DynamicProxy.intercept begin");
		// Object result1 = method.invoke(target, objects);
		Object result = methodProxy.invoke(target, objects);
		System.out.println("DynamicProxy.intercept end");
		return result;
	}

}
