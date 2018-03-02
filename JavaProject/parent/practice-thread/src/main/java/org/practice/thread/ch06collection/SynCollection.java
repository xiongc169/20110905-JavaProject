package org.practice.thread.ch06collection;

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
 * 同步容器
 * 
 * @author Administrator
 *
 */
public class SynCollection {

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
	 * 并发容器，线程安全
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
