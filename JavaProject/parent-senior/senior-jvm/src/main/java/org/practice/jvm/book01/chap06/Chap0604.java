package org.practice.jvm.book01.chap06;

/**
 * @Desc 《深入理解Java虚拟机·JVM高级特性与实践》
 * 第六章、类文件结构
 * @Author
 * @Date
 * @Version 1.0
 */
public class Chap0604 {

    /**
     * 6.4、字节码指令简介
     */
    public static void main(String[] args) {
        Integer a = 100;
        System.out.println("A" + a);
        Integer b = 200;
        System.out.println("B" + b);
        Integer c = a + b;
        System.out.println("C" + c);
    }
}
