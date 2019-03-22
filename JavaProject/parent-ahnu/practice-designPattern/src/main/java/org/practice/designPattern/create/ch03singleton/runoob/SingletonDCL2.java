package org.practice.designPattern.create.ch03singleton.runoob;

/**
 * 单例模式
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 *
 * @author yoong
 */
public class SingletonDCL2 {

    private volatile static SingletonDCL2 singleton;

    private SingletonDCL2() {
    }

    public static SingletonDCL2 getInstance() {
        if (singleton == null) {
            synchronized (SingletonDCL2.class) {
                if (singleton == null) {
                    singleton = new SingletonDCL2();
                }
            }
        }
        return singleton;
    }
}
