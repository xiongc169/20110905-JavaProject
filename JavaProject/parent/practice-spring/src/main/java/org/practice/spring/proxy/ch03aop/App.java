package org.practice.spring.proxy.ch03aop;

import java.lang.reflect.Method;

import org.practice.spring.proxy.api.ICalculator;
import org.practice.spring.proxy.ch01static.CalculatorImpl;
import org.practice.spring.proxy.ch03aop.advice.AfterReturnAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author yoong
 *
 * @desc 各种通知：前置通知、后置通知(3类)、环绕通知 <br>
 *       http://www.cnblogs.com/best/p/5679656.html
 *
 * @date 2018年8月20日
 *
 */
public class App {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		weaverTest();

	}

	/**
	 * SpringAPI手动创建代理对象——ProxyFactory <br>
	 * PS：配置多个通知时，前置通知正序执行，后置通知逆序执行，环绕通知前正、后逆。MethodInterceptor：方法拦截器可以实现MethodBeforeAdvice接口、AfterReturningAdvice接口、ThrowsAdvice三个接口所能够实现的效果
	 * <br>
	 * https://blog.csdn.net/u012834750/article/details/71773598
	 */
	private static void weaverTest() {
		try {
			// 目标对象
			ICalculator calc = new CalculatorImpl();
			// 织入器
			ProxyFactory weaver = new ProxyFactory(calc);
			// 织入通知，前置通知
			weaver.addAdvice(new MethodBeforeAdvice() {
				@Override
				public void before(Method method, Object[] args, Object target) throws Throwable {
					System.out.println("MethodBeforeAdvice.befor()");
				}
			});
			// 织入通知，后置通知
			weaver.addAdvice(new AfterReturnAdvice());
			// 代理对象
			ICalculator calcProxy = (ICalculator) weaver.getProxy();
			int result = calcProxy.add(12, 23);
			System.out.println(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
