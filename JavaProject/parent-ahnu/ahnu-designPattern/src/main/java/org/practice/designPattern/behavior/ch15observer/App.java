package org.practice.designPattern.behavior.ch15observer;

import org.practice.designPattern.behavior.ch15observer.runoob.Observer;
import org.practice.designPattern.behavior.ch15observer.runoob.ObserverAA;
import org.practice.designPattern.behavior.ch15observer.runoob.ObserverBB;
import org.practice.designPattern.behavior.ch15observer.runoob.Subject;

/**
 * 观察者模式<br>
 * http://www.runoob.com/design-pattern/observer-pattern.html
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            observer_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void observer_runoob() {
        Subject sub = new Subject();

        Observer aa = new ObserverAA(sub);
        Observer bb = new ObserverBB(sub);

        sub.notifyAllObservers();
    }

}
