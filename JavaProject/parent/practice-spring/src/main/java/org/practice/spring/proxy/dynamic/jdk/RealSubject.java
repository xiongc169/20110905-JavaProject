package org.practice.spring.proxy.dynamic.jdk;

public class RealSubject implements Subject {

	public String say(String name, int age) {
		String msg = name + "  " + age;
		System.out.println(msg);
		return msg;
	}

}
