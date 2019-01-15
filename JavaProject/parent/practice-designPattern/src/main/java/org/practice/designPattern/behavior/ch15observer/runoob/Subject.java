package org.practice.designPattern.behavior.ch15observer.runoob;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> observerList = new ArrayList<Observer>();

	public void attach(Observer observer) {
		observerList.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer obj : observerList) {
			obj.update();
		}
	}
}
