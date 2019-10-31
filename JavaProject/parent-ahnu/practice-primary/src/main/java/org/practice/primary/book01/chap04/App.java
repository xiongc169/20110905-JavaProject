package org.practice.primary.book01.chap04;

/**
 * @Desc App
 * @Author
 * @Date
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            initOrder();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void initOrder() {
        //父静态代码块 - 子静态代码块 - 父代码块 - 父构造函数 - 子代码块 - 子构造函数
        ApiServiceRecord apiServiceRecord = new ApiServiceRecord();
    }
}