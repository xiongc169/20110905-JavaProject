package org.practice.spring.proxy.ch01static;

import org.practice.spring.proxy.api.ISubject;

public class SubjectImpl implements ISubject {

	public String say(String name, int age) {
		String msg = name + "  " + age;
		System.out.println("SubjectImpl.say " + msg);
		return msg;
	}

}
