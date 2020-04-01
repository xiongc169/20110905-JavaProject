package org.practice.primary.book01.chap13;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 《Java核心技术·卷1》第十三章、集合
 * PS：集合操作类 集合的类型，各个类型的特点，遍历的几种方式；
 *
 * @author chaoxiong
 * @since 2015-08-30 09:06:00
 */
public class AppCollection {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Iterable iterable = new ArrayList();
            Iterator iterator = iterable.iterator();
            Collection collection = new ArrayList();
            List<String> list = new ArrayList<>();

            iterable.forEach(item -> System.out.println(item));
            for (Object item : iterable) {
                System.out.println(item);
            }

            Set hashSet = new HashSet();
            Set treeSet = new TreeSet();

            Queue queue = new LinkedList();
            Deque deque = new LinkedList();
            Queue priorityQueue = new PriorityQueue<Integer>();

            Collection vector = new Vector();
            Collection stack = new Stack();

            Map hashMap = new HashMap();
            Map hashTable = new Hashtable();
            Dictionary dictionary = new Hashtable();


            AbstractCollection abstractCollection = new ArrayList();
            AbstractList abstractList = new ArrayList();
            Map<String, String> map = new HashMap();
            String value01 = map.put("1", "value-01");
            String value02 = map.put("1", "value-02");
            System.out.println(value01);
            System.out.println(value02);
            Properties properties = new Properties();

            collection();
            removeTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 集合——《Java核心技术·卷1》13章
     */
    public static void collection() {
        List<Integer> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<String>();
        Iterator<String> iterator = linkedList.iterator();
        boolean hasPrevious = ((ListIterator<String>) iterator).hasPrevious();
        ListIterator<String> listIterator = linkedList.listIterator();
        ((ListIterator<String>) listIterator).add("Head");

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        ArrayQueue queue = new ArrayQueue(10);

        TreeSet<String> treeSet = new TreeSet(comparator);
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

    public static void removeTest() {
        List<String> list = new ArrayList<>();
        list.add("Bob");
        list.add("Amy");
        list.add("David");
        list.add("Cinema");
        String result = list.remove(0);
        System.out.println(result);
    }
}
