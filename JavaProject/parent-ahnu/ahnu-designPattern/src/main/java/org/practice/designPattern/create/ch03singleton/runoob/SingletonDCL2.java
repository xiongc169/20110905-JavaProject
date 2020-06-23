package org.practice.designPattern.create.ch03singleton.runoob;

/**
 * @Desc 单例模式
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
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
