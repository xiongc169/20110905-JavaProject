package org.practice.spring.proxy.ch02dynamic.jdk;

import java.lang.reflect.Method;

import org.practice.spring.proxy.ch01static.CalculatorImpl;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

/**
 * @description CalculatorProxy
 * @author yoong
 * @date 2016年8月13日 下午2:27:22
 */
public class CalculatorJdkProxy {

	private CalculatorImpl target = null;

	public CalculatorJdkProxy(CalculatorImpl cal) {
		target = cal;
	}

	public CalculatorImpl getCalculatorProxy() {
		CalculatorImpl proxy = null;

		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = new Class[] { CalculatorImpl.class };

		InvocationHandler h = new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();

				Object result = null;
				try {
					// 1、前置通知
					// 2、调用方法
					result = method.invoke(target, args);
					// 3、返回通知
				} catch (Exception ex) {
					ex.printStackTrace();
					// 异常通知
				}
				// 4、后置通知
				return result;
			}
		};

		proxy = (CalculatorImpl) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
