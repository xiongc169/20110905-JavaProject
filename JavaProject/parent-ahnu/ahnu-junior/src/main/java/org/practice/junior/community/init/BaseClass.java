package org.practice.junior.community.init;

/**
 * @Desc 关于static语句, 构造代码块, 构造方法的执行顺序
 * PS：父static块 - 子static块 - 父{} - 父构造函数 - 子{} - 子构造函数
 * 父static变量、static代码块(按声明顺序执行) - 子static变量、static代码块 - 父变量、代码块 - 父构造函数 - 子变量、代码块 - 子构造函数
 * https://www.cnblogs.com/jj-chenjunjie/p/5331107.html
 * http://blog.csdn.net/tt_zhang/article/details/7614180
 * http://blog.sina.com.cn/s/blog_4f925fc30102dtgc.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年4月2日
 * <p>
 * @Version 1.0
 */
public class BaseClass {

    private final String name = new String("baseClass-name");

    static {
        System.out.println("BaseClass Static 块");
    }

    static Foo FOO = new Foo("BaseClass static FOO");

    Foo foo = new Foo("BaseClass FOO");

    {
        System.out.println("BaseClass {}");
    }

    private String id = new String("baseClass-Id");

    private final String sex = new String("baseClass-sex");

    public BaseClass() {
        System.out.println("BaseClass Constructor");
    }

    public static void staticSay() {
        System.out.println("BaseClass staticSay");
    }

    public void say() {
        System.out.println("BaseClass say");
    }
}