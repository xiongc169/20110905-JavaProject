package org.practice.jvm;

/**
 * @Desc JvmApp
 * @Author
 * @Date
 * @Version 1.0
 */
public class JvmApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}