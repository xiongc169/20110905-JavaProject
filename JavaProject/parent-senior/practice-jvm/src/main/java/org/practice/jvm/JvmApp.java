package org.practice.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class JvmApp {

    private static Integer stackLength = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
//        heapOutOfMemory();
//        stackLeak();
//        nativeStackLeak();
        methodArea();
//        testAllocation();
//        System.gc();
    }

    /**
     * 2.4.1、堆溢出
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void heapOutOfMemory() {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }

    /**
     * 2.4.2、虚拟机栈溢出
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /**
     * 2.4.2、本地方法栈溢出
     */
    public static void nativeStackLeak() {
    }

    /**
     * 2.4.3、方法区和运行时常量池溢出
     * -XX:PermSize=10M -XX:MaxPermSize=10M
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public static void methodArea() {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (true) {
            result.add(String.valueOf("String" + i).intern());
            i++;
        }
    }

    /**
     * 3.6.1
     * -XX:+PrintGCDetails
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    public static void testAllocation() {

        byte[] allocation1 = new byte[2 * 1024 * 1024];
        byte[] allocation2 = new byte[2 * 1024 * 1024];
        byte[] allocation3 = new byte[2 * 1024 * 1024];
        byte[] allocation4 = new byte[4 * 1024 * 1024];
    }
}
