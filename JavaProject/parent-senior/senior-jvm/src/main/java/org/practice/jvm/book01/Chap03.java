package org.practice.jvm.book01;

/**
 * @Desc 《深入理解Java虚拟机·JVM高级特性与实践》
 * 第三章、垃圾收集器与内存分配策略
 * @Author
 * @Date
 * @Version 1.0
 */
public class Chap03 {

    private static Integer length = 0;

    /**
     * 入口函数：-Xms3m -Xmx3m -Xmn1m -XX:+PrintGCDetails
     * -XX:+PrintGCDetails，输出日志参数
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
}
