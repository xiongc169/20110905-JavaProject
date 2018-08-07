package org.practice.spring.reflect.dynamicProxy;

public class RealSubject implements Subject {

	public String say(String name, int age) {
		return name + "  " + age;
	}

}
