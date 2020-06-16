package org.practice.primary.community.utility;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Desc 集合操作类 集合的类型，各个类型的特点，遍历的几种方式；
 * Java中集合包简要分析
 * PS：集合包主要有 Collection、Map 两种接口：
 * Collection 存储单对象，分为两种接口：List、Set，
 * List 支持放入重复对象，实现类主要包括：ArrayList、LinkedList、Vector、Stack。
 * Vector 是基于synchronized实现的线程安全的ArrayList；
 * Stack 继承了Vector，实现了LIFO操作；
 * Set 不支持放入重复对象，实现类主要包括：HashSet、TreeSet。
 * Map 存储Key-Value形式的键值对，实现类主要包括：HashMap、TreeMap。
 * http://www.cnblogs.com/huangfox/archive/2012/08/15/2640106.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class CollectionUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            listDemo();
            setDemo();
            mapDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * list继承collection接口
     */
    //@MethodInfo(author = "tony", comments = "this hide the privacy", date = "20180328", version = "1.0.0")
    public static void listDemo() {
        // Array array = new SerialArray();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Queue<String> linkedQueue = new LinkedList<>();
        Vector<String> vector = new Vector<>();
        Stack<String> stack = new Stack<>();

        // TODO：空集合，执行add()会报错
        try {
            List<String> emptyList = Collections.emptyList();
            emptyList.add("2018年11月9日17:39:38");
        } catch (Exception ex) {
            //java.lang.UnsupportedOperationException
            ex.printStackTrace();
        }

        // TODO：ArrayList
        for (int i = 0; i < 5; i++) {
            String item = "arrayList " + i;
            boolean isSuccess = arrayList.add(item);
        }
        //遍历ArrayList集合中的元素
        for (String item : arrayList) {
            System.out.println(item);
        }
        Iterator arrayIterator = arrayList.iterator();
        while (arrayIterator.hasNext()) {
            //Object obj = arrayIterator.next();
            String item = (String) arrayIterator.next();
            System.out.println(item);
        }

        // TODO：LinkedList
        linkedList.add("");

        // TODO：Queue
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add("");
        Object peek = priorityQueue.peek();
        System.out.println(priorityQueue.size());
        linkedQueue.add("123");
        linkedQueue.peek();

        // TODO：Vector(同步添加，synchronized)
        vector.add("vector 01");

        // TODO：Stack
        for (int i = 0; i < 5; i++) {
            String item = "Stack add " + i;
            stack.add(item);
        }
        Iterator stackIterator = stack.iterator();
        while (stackIterator.hasNext()) {
            //Object item = stackIterator.next();
            String item = (String) stackIterator.next();
            System.out.println(item);
        }
        //遍历Stack集合中的元素
        ListIterator stackListIterator = stack.listIterator();
        while (stackListIterator.hasNext()) {
            Object item = stackListIterator.next();
            System.out.println(item);
        }
        Stack stack1 = new Stack();
        for (int i = 0; i < 5; i++) {
            ((Stack<String>) stack1).push("Stack push " + i);
        }
        while (!stack1.empty()) {
            String peek1 = ((Stack<String>) stack1).pop();
            System.out.println(peek1);
        }
    }

    /**
     * set继承collection接口，是不包含重复元素的集合， 元素插入的顺序与输出的顺序不一致。
     */
    public static void setDemo() {
        Set hashSet = new HashSet();
        SortedSet treeSet = new TreeSet();
        Set linkedHashSet = new LinkedHashSet();
        Set copyOnWriteArraySet = new CopyOnWriteArraySet();

        //region TODO：HashSet添加元素
        for (int i = 0; i < 10; i++) {
            String item = "HashSet " + i;
            hashSet.add(item);
            hashSet.add(item);
        }
        try {
            hashSet.add("HashSet 8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //遍历HashSet
        for (Object item : hashSet) {
            System.out.println(item);
        }
        //遍历HashSet
        Iterator hashSetIterator = hashSet.iterator();
        while (hashSetIterator.hasNext()) {
            String item = (String) hashSetIterator.next();
            System.out.println(item);
        }

        //HashSet去重、排序
        Set intHashSet = new HashSet();
        intHashSet.add(1);
        intHashSet.add(4);
        intHashSet.add(3);
        intHashSet.add(2);
        intHashSet.add(5);
        intHashSet.add(5);
        intHashSet.add(5);
        Iterator iterator = intHashSet.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println(value);
        }
        //endregion

        //region TODO：LinkedHashSet添加元素(去重、不排序)
        linkedHashSet.add(1);
        linkedHashSet.add(5);
        linkedHashSet.add(4);
        linkedHashSet.add(1);
        linkedHashSet.add(5);
        linkedHashSet.add(0);
        linkedHashSet.add(1);
        linkedHashSet.add(6);
        iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println(value);
        }
        //endregion
    }

    /**
     * map没有继承collection接口
     */
    public static void mapDemo() {
        //region TODO：Hashtable，较早提供的，线程安全的、put\get操作是同步的
        Map hashtable = new Hashtable();
        hashtable.put("OK", "first");
        hashtable.put(2524, "second");

        Object value = hashtable.get(01);
        //endregion

        //region TODO：HashMap，后来提供的，非线程安全的、put\get操作是异步的
        Map<Integer, Object> intHashMap = new HashMap();
        Map<String, Object> stringHashMap = new HashMap();
        intHashMap.put(01, "first");
        Object first = intHashMap.get(01);
        intHashMap.put(01, "second");
        Object second = intHashMap.get(01);
        for (int i = 0; i < 10; i++) {
            intHashMap.put(i, "HashMap " + i);
        }
        //HashMap遍历一
        for (Integer key : intHashMap.keySet()) {
            System.out.println(intHashMap.get(key));
        }
        //HashMap遍历二
        Iterator iterator = intHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Object tmpValue = iterator.next();
            System.out.println(tmpValue);
        }
        //HashMap遍历三
        for (Map.Entry<Integer, Object> item : intHashMap.entrySet()) {
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        }
        //HashMap遍历四
        for (Object tmpValue : intHashMap.values()) {
            System.out.println(tmpValue);
        }
        //endregion

        //region TODO：TreeMap
        Map treemap = new TreeMap();
        for (int i = 0; i < 10; i++) {
            treemap.put(i, "TreeMap " + i);
        }
        for (Object tmpValue : treemap.entrySet()) {
            String val = tmpValue.toString();
        }
        //endregion

        Map weakhashmap = new WeakHashMap();
    }
}
