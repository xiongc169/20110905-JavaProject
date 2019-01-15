package org.practice.designPattern.struct.ch08proxy;

/**
 * 代理模式<br>
 * http://www.runoob.com/design-pattern/proxy-pattern.html
 */
public class App {
	public static void main(String[] args) {

		ProxyImage proxy = new ProxyImage("beautiful");
		proxy.display();
	}
}
