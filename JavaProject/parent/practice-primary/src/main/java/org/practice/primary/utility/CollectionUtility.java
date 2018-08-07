package org.practice.primary.utility;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

/**
 * 集合操作类 集合的类型，各个类型的特点，遍历的几种方式；
 * 
 * @author chaoxiong
 * @since 2015-08-30 09:06:00
 * @see http://www.cnblogs.com/xwdreamer/archive/2012/05/30/2526822.html(含Java集合类图)<br>
 *      http://blog.csdn.net/liulin_good/article/details/6213815
 *      http://blog.csdn.net/softwave/article/details/4166598
 *
 */
public class CollectionUtility {

	public static void main(String[] args) {
		mapDemo();
	}

	/**
	 * list继承collection接口
	 */
	// @MethodInfo(author = "tony", comments = "this hide the privacy", date =
	// "20180328", version = "1.0.0")
	public static void listDemo() {
		// Array arr=new Array();
		List<String> arrays = new ArrayList<String>();
		List<String> links = new LinkedList<String>();
		List<String> vector = new Vector<String>();
		List<String> stack = new Stack<String>();
		List<Integer> listInt = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			String item = "String " + i;
			arrays.add(item);
		}

		for (String item : arrays) {
			System.out.println(item);
		}

		Iterator arryaIt = arrays.iterator();
		while (arryaIt.hasNext()) {
			// Object obj=arryaIt.next();
			String item = (String) arryaIt.next();
			System.out.println(item);
		}

		Iterator it = stack.iterator();
		while (it.hasNext()) {
			// Object item=it.next();
			String item = (String) it.next();
		}

		ListIterator lit = stack.listIterator();
		while (lit.hasNext()) {
			Object item = lit.next();
		}
		lit.add(new Object());
	}

	/**
	 * set继承collection接口，是不包含重复元素的集合， 元素插入的顺序与输出的顺序不一致。
	 */
	public static void setDemo() {
		Set hashset = new HashSet();
		Set linkedHashset = new LinkedHashSet();
		SortedSet treeset = new TreeSet();

		for (int i = 0; i < 10; i++) {
			String item = "String " + i;
			hashset.add(item);
			hashset.add(item);
		}

		// try {
		// hashset.add("String 8");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		for (Object item : hashset) {
			System.out.println(item);
		}

		Iterator hashSetIt = hashset.iterator();
		while (hashSetIt.hasNext()) {
			String item = (String) hashSetIt.next();
			System.out.println(item);
		}
	}

	/**
	 * map没有继承collection接口
	 */
	public static void mapDemo() {
		Map hashtable = new Hashtable();// 同步的
		hashtable.put(01, "first");
		hashtable.get(01);

		Map hashmap = new HashMap();// 非同步的
		hashmap.put(01, "first");
		Object first = hashmap.get(01);
		hashmap.put(01, "second");
		Object second = hashmap.get(01);

		Map treemap = new TreeMap();

		Map weakhashmap = new WeakHashMap();

	}
}
