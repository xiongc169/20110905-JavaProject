package org.practice.designPattern.create.singleton.runoob;

/**
 * 单例模式
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 *
 * @author yoong
 */
public class SingletonInner {

    private SingletonInner() {
    }

    public static SingletonInner getInstance() {
        return Handler.instance;
    }

    public static class Handler {
        private static final SingletonInner instance = new SingletonInner();
    }

}
