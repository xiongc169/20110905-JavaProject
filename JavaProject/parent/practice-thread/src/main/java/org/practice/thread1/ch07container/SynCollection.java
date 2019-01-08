package org.practice.thread1.ch07container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Java并发编程：同步容器 <br>
 * http://www.cnblogs.com/dolphin0520/p/3933404.html
 * 
 * @author Administrator
 *
 */
public class SynCollection {

	/**
	 * 入口函数
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 普通容器，非线程安全
	 */
	public void container() {
		List strList = new ArrayList<String>();
		Set nameSet = new HashSet<String>();
	}

	/**
	 * 同步容器，线程安全
	 */
	public void syncContainer() {

		Stack stack = new Stack();
		Vector vector = new Vector();
		Hashtable hTable = new Hashtable();

		List<Object> objs = Collections.synchronizedList(new ArrayList<Object>());
	}

	/**
	 * Java并发编程：并发容器之ConcurrentHashMap <br>
	 * http://www.cnblogs.com/dolphin0520/p/3932905.html<br>
	 * Java并发编程：并发容器之CopyOnWriteArrayList <br>
	 * PS：CopyOnWrite容器，写时复制容器。运用了读写分离的思想；<br>
	 * http://www.cnblogs.com/dolphin0520/p/3938914.html<br>
	 */
	public void parallelContainer() {
		ConcurrentHashMap conHashMap = new ConcurrentHashMap();

		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		CopyOnWriteArraySet set = new CopyOnWriteArraySet();
	}

	/**
	 * 阻塞队列，线程安全
	 */
	public void blockingQueue() {
		ArrayBlockingQueue arrayQue = new ArrayBlockingQueue(100);
		LinkedBlockingQueue linkQue = new LinkedBlockingQueue();
		SynchronousQueue synQue = new SynchronousQueue();
	}

}
