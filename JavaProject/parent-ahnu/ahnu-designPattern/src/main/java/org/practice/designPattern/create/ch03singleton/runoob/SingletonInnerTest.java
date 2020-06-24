package org.practice.designPattern.create.ch03singleton.runoob;

public class SingletonInnerTest {

    static {
        System.out.println("SingletonInnerTest.static{}");
    }

    public SingletonInnerTest() {
        System.out.println("SingletonInnerTest.SingletonInnerTest()");
    }

    public static SingletonInnerTest getInstance() {
        return HandlerTest.instance;
    }

    public static class HandlerTest {
        private static final SingletonInnerTest instance = new SingletonInnerTest();

        static {
            System.out.println("HandlerTest.static{}");
        }

        public HandlerTest() {
            System.out.println("HandlerTest.HandlerTest()");
        }
    }
}
