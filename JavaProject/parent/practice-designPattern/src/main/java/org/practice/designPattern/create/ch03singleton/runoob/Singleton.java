package org.practice.designPattern.create.ch03singleton.runoob;

/**
 * @author yoong
 * <br>
 * @desc Singleton
 * <br>
 * @date 2019/1/15 17:35
 */
public class Singleton {

    private static Singleton Instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Singleton.Instance;
    }
}
