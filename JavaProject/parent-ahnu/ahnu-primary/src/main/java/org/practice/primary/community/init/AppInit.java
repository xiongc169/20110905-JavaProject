package org.practice.primary.community.init;

/**
 * @Desc AppInit
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppInit {

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

    public static void initOrder() {
        //静态变量静态块(按声明顺序执行)、构造函数
        OssUtils ossUtils = new OssUtils();
        //OssUtils.upload();
    }
}
