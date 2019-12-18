package org.practice.primary.book01.chap04;

/**
 * @Desc 《Java核心技术·卷1》第四章、类与对象
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppObject {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            initOrder();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void initOrder() {
        ApiBaseRecord apiBaseRecord = new ApiBaseRecord();//父静态代码块 - 父代码块 - 父构造函数
        ApiServiceRecord apiServiceRecord = new ApiServiceRecord();//父静态代码块 - 子静态代码块 - 父代码块 - 父构造函数 - 子代码块 - 子构造函数
        ApiBaseRecord.output();//父静态代码块 - 子静态方法
        ApiServiceRecord.output();//父静态代码块 - 子静态代码块 - 子静态方法
    }
}