package org.practice.designPattern.behavior.observer;

/**
 * 观察者模式<br>
 * http://www.runoob.com/design-pattern/observer-pattern.html
 *
 */
public class App {
	public static void main(String[] args) {
		Subject sub = new Subject();

		Observer aa = new ObserverAA(sub);
		Observer bb = new ObserverBB(sub);

		sub.notifyAllObservers();
	}
}
