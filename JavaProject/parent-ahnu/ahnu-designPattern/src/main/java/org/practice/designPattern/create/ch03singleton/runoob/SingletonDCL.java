package org.practice.designPattern.create.ch03singleton.runoob;

/**
 * 单例模式
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 *
 * @author yoong
 */
public class SingletonDCL {

    private static volatile SingletonDCL instance;

    private SingletonDCL() {
    }

    public static SingletonDCL getSingletonDCL() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }

    public void getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
    }

}
