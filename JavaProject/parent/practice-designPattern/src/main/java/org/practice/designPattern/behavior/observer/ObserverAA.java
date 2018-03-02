package org.practice.designPattern.behavior.observer;

public class ObserverAA extends Observer {

	public ObserverAA(Subject sub) {
		this.theSubject = sub;
		sub.attach(this);
	}

	@Override
	public void update() {
		System.out.println("this is ObserverAA");
	}

}
