package org.practice.jvm.book01;

/**
 * @Desc 《深入理解Java虚拟机·JVM高级特性与实践》
 * PS：第十章、早期(编译期)优化
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-04-01 09:00:00
 * <p>
 * @Version 1.0
 */
public class Chap10 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //byte数组：1Byte * 1024 * 1024  = 1048576
            byte[] content = new byte[1024 * 1024];
            //Integer数组：4Byte * 1024 * 1024 = 4M
            //Integer[] content = new Integer[1000 * 1024 * 5];
            System.out.println(content.length);
            int sum = 500;
            System.out.println(sum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void add() {
        //-Xss4M，2560*1024会堆溢出
        Integer[] content = new Integer[2560 * 1024];
        System.out.println(content.length);

        Integer a = 100;
        Integer b = 200;
        Integer c = a + b;
        System.out.println(c);
        Integer d = 300;
        System.out.println(d);
    }
}
