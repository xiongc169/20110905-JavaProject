package org.practice.designPattern.behavior.observer;

import org.practice.designPattern.behavior.observer.runoob.Observer;
import org.practice.designPattern.behavior.observer.runoob.ObserverAA;
import org.practice.designPattern.behavior.observer.runoob.ObserverBB;
import org.practice.designPattern.behavior.observer.runoob.Subject;

/**
 * 观察者模式<br>
 * http://www.runoob.com/design-pattern/observer-pattern.html
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            runoob_observer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void runoob_observer() {
        Subject sub = new Subject();

        Observer aa = new ObserverAA(sub);
        Observer bb = new ObserverBB(sub);

        sub.notifyAllObservers();
    }

}
