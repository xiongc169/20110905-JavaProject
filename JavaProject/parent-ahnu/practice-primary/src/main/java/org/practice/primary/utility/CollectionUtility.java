package org.practice.primary.utility;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.*;

/**
 * 集合操作类 集合的类型，各个类型的特点，遍历的几种方式；
 *
 * @author chaoxiong
 * @since 2015-08-30 09:06:00
 */
public class CollectionUtility {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            listDemo();
            setDemo();
            mapDemo();
            collection();
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
        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        List<String> vector = new Vector<String>();
        List<String> stack = new Stack<String>();

        //region TODO：空集合，执行add()会报错
        try {
            List<String> emptyList = Collections.emptyList();
            emptyList.add("2018年11月9日17:39:38");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //endregion

        //region TODO：ArrayList集合中添加元素
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
        //endregion

        //region TODO：Stack集合中添加元素
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
            String peek = ((Stack<String>) stack1).pop();
            System.out.println(peek);
        }
        //endregion
    }

    /**
     * set继承collection接口，是不包含重复元素的集合， 元素插入的顺序与输出的顺序不一致。
     */
    public static void setDemo() {
        Set hashset = new HashSet();
        SortedSet treeset = new TreeSet();
        Set linkedHashset = new LinkedHashSet();
        Set copyOnWriteArraySet = new CopyOnWriteArraySet();

        //region TODO：HashSet添加元素
        for (int i = 0; i < 10; i++) {
            String item = "HashSet " + i;
            hashset.add(item);
            hashset.add(item);
        }
        try {
            hashset.add("HashSet 8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //遍历HashSet
        for (Object item : hashset) {
            System.out.println(item);
        }
        //遍历HashSet
        Iterator hashSetIterator = hashset.iterator();
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
        linkedHashset.add(1);
        linkedHashset.add(5);
        linkedHashset.add(4);
        linkedHashset.add(1);
        linkedHashset.add(5);
        linkedHashset.add(0);
        linkedHashset.add(1);
        linkedHashset.add(6);
        iterator = linkedHashset.iterator();
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
        hashtable.put(01, "first");
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

    /**
     * 集合——《Java核心技术·卷1》13章
     */
    public static void collection() {
        ArrayQueue queue = new ArrayQueue(10);
        List<String> linkedList = new LinkedList<String>();
        Iterator<String> iterator = linkedList.iterator();
        ListIterator<String> listIterator = linkedList.listIterator();
        ((ListIterator<String>) listIterator).add("Head");
        boolean hasPrevious = ((ListIterator<String>) iterator).hasPrevious();

        TreeSet<String> treeSet = new TreeSet();
        treeSet.add("Bob");
        treeSet.add("Amy");
        treeSet.add("David");
        treeSet.add("Cinema");
        for (String item : treeSet) {
            System.out.println(item);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue();
        priorityQueue.add("yoong");
        priorityQueue.add("zara");
        priorityQueue.add("singapore");
        for (String item : priorityQueue) {
            System.out.println(item);
        }

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, "HashMap " + i);
        }
        for (Map.Entry<Integer, String> item : hashMap.entrySet()) {
            System.out.println(item.getKey() + "：" + item.getValue());
        }
    }

    /**
     * 阻塞队列——《Java核心技术·卷1》14.6节
     */
    public static void blockingCollection() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
    }

    /**
     * 线程安全的集合——《Java核心技术·卷1》14.7节
     */
    public static void concurrentCollection() {
        // 14.7.1、高效的映射表、集合、队列
        ConcurrentHashMap conHashMap = new ConcurrentHashMap();
        ConcurrentSkipListMap conSkipListMap = new ConcurrentSkipListMap();
        ConcurrentSkipListSet conSkipListSet = new ConcurrentSkipListSet();
        ConcurrentLinkedQueue conLinkedQueue = new ConcurrentLinkedQueue();
        conHashMap.put(1, "eva huang");

        // 14.7.2、写数组的拷贝
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        // 14.7.3、较早的线程安全集合
        List<Integer> syncArrayList = Collections.synchronizedList(new ArrayList<>());
        Map<Integer, String> syncHashMap = Collections.synchronizedMap(new HashMap<>());
    }
}
