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
