package org.practice.designPattern.behavior.ch15observer;

import org.practice.designPattern.behavior.ch15observer.runoob.Observer;
import org.practice.designPattern.behavior.ch15observer.runoob.ObserverAA;
import org.practice.designPattern.behavior.ch15observer.runoob.ObserverBB;
import org.practice.designPattern.behavior.ch15observer.runoob.Subject;

/**
 * @Desc 观察者模式
 * http://www.runoob.com/design-pattern/observer-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
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
