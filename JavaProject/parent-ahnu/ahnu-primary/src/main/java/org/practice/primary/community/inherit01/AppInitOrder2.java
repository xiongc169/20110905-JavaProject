package org.practice.primary.community.inherit01;

/**
 * @author yoong
 * <p>
 * @desc 关于static语句, 构造代码块, 构造方法的执行顺序
 *       PS：父static块 - 子static块 - 父{} - 父构造函数 - 子{} - 子构造函数
 *          父static变量、static代码块(按声明顺序执行) - 子static变量、static代码块 - 父变量、代码块 - 父构造函数 - 子变量、代码块 - 子构造函数
 *       https://www.cnblogs.com/jj-chenjunjie/p/5331107.html
 *       http://blog.csdn.net/tt_zhang/article/details/7614180
 *       http://blog.sina.com.cn/s/blog_4f925fc30102dtgc.html
 * <p>
 * @version 1.0
 * <p>
 * @date 2012年4月2日
 */
public class AppInitOrder2 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            initOrderTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 静态变量、静态代码块、变量、代码块、构造函数的执行顺序
     */
    private static void initOrderTest() {
        DeriveClass deriveClass = new DeriveClass();
        DeriveClass.staticSay();
        deriveClass.say();
    }
}
