package org.practice.primary.init_order;

/**
 * @author yoong
 *
 * @desc 关于static语句, 构造代码块, 构造方法的执行顺序
 *       PS：父static块 - 子static块 - 父{} - 父构造函数 - 子{} - 子构造函数
 *          父static变量、static代码块 - 子static变量、static代码块 - 父变量、代码块 - 父构造函数 - 子变量、代码块 - 子构造函数
 *       http://blog.csdn.net/tt_zhang/article/details/7614180
 *       http://blog.sina.com.cn/s/blog_4f925fc30102dtgc.html
 *       https://www.cnblogs.com/jj-chenjunjie/p/5331107.html
 *
 * @version 1.0
 *
 * @date 2012年4月2日
 */
public class DeriveClass extends BaseClass {

	static Foo FOO = new Foo("DeriveClass static FOO");

	Foo foo = new Foo("DeriveClass FOO");

	static {
		System.out.println("DeriveClass Static 块");
	}

	{
		System.out.println("DeriveClass {}");
	}

	public DeriveClass() {
		System.out.println("DeriveClass Constructor");
	}

	public static void staticSay() {
		System.out.println("DeriveClass staticSay ");
	}

	@Override
	public void say() {
		System.out.println("DeriveClass say");
	}
}
