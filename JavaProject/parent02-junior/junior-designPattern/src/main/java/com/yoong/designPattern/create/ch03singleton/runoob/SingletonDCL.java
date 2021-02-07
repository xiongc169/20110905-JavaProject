package com.yoong.designPattern.create.ch03singleton.runoob;

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
