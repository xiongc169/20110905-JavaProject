package org.practice.spring.proxy;

import org.practice.spring.proxy.ch01static.CalculatorProxy;

/**
 * 
 * @desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC <br>
 *       PS：业务逻辑+横切关注点；静态代理、动态代理(JDK动态代理、Cglib动态代理)<br>
 *       http://www.cnblogs.com/best/p/5679656.html
 * 
 *       代理模式及JDK动态代理(InvocationHandler)的简单实现与分析 <br>
 *       PS：实现方式：静态代理、jdk动态代理；<br>
 *       https://blog.csdn.net/hello2mao/article/details/52346205
 * @author chaoxiong
 * @date 2016年8月13日 下午2:27:36
 */
public class App {

	/**
	 * @description TODO
	 * @param args
	 * @return void
	 * @author chaoxiong
	 * @date 2016年8月13日 下午2:27:36
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void staticProxy() {
		CalculatorProxy calcProxy = new CalculatorProxy();
		calcProxy.add(20, 10);

	}

}
