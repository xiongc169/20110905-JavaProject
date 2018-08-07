package org.practice.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

/**
 * @description CalculatorProxy.java
 * @author chaoxiong
 * @date 2016年8月13日 下午2:27:22
 */
public class CalculatorProxy {

	private Calculator target = null;

	public CalculatorProxy(Calculator cal) {
		target = cal;
	}

	public Calculator getCalculatorProxy() {
		Calculator proxy = null;

		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = new Class[] { Calculator.class };

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

		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
