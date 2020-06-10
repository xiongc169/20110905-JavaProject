package org.practice.primary.community.init02;

/**
 * @Desc AppInit
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019-5-10 11:27:55
 * <p>
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
        //静态变量、静态块(按声明顺序执行) -> 实例变量、代码块 -> 构造函数
        OssUtils ossUtils = new OssUtils();
        ossUtils.upload();
        OssUtils.upload();
    }
}
