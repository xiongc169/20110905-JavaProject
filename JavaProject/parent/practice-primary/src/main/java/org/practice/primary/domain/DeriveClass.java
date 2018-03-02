package org.practice.primary.domain;

/**
 * 测试static方法、static块、构造函数的执行顺序
 * 
 * @author Administrator <br/>
 *         http://blog.csdn.net/tt_zhang/article/details/7614180
 *         http://blog.sina.com.cn/s/blog_4f925fc30102dtgc.html
 *
 */
public class DeriveClass extends BaseClass {

	{
		System.out.println("DeriveClass {}");
	}

	public DeriveClass() {
		System.out.println("DeriveClass Constructor");
	}

	static {
		System.out.println("DeriveClass Static 块");
	}

	public static void Say() {
		System.out.println("DeriveClass Static 方法");
	}
}
