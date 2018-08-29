package org.practice.primary.domain;

/**
 * @author yoong
 *
 * @description http://blog.csdn.net/tt_zhang/article/details/7614180
 *              http://blog.sina.com.cn/s/blog_4f925fc30102dtgc.html
 *              https://www.cnblogs.com/jj-chenjunjie/p/5331107.html
 *              测试static方法、static块、构造函数的执行顺序
 *
 * @date 2012年4月2日
 *
 * @version 1.0
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
