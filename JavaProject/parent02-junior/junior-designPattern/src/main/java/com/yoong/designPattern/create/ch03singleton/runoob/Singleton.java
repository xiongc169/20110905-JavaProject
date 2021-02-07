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
public class Singleton {

    private static Singleton Instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Singleton.Instance;
    }
}
