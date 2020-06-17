package org.practice.primary.book01.chap13;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 《Java核心技术·卷1》第十三章、集合
 * PS：集合操作类 集合的类型，各个类型的特点，遍历的几种方式；
 *
 * @author yoong
 * @since 2015-08-30 09:06:00
 */
public class AppCollection {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            collectionInterface1301();
            collection1302();
            set130203();
            queue130206();
            map130208();
            specialCollection130209();
            //练习
            removeTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 13.1、集合接口 (P560)
     */
    public static void collectionInterface1301() {
        Vector vector = new Vector();
        Stack stack = new Stack();
        Hashtable hashtable = new Hashtable();
        BitSet bitSet = new BitSet();

        Iterable iterable = new ArrayList();
        Collection collection = new ArrayList();
        List list = new ArrayList();
        AbstractCollection abstractCollection = new ArrayList();
        AbstractList abstractList = new ArrayList();

        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Enumeration vectorEnumeration = vector.elements();
        Enumeration stackEnumeration = stack.elements();
        while (vectorEnumeration.hasMoreElements()) {
            System.out.println(vectorEnumeration.nextElement());
        }

        for (Object item : iterable) {
            System.out.println(item);
        }
        iterable.forEach(item -> System.out.println(item));
    }

    /**
     * 13.2、具体的接口：链表、数组列表 (P567)
     */
    public static void collection1302() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("Amy");
        linkedList.add("Bob");
        linkedList.add("Carl");

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        listIterator.add("head");

        ArrayList arrayList = new ArrayList<>();
    }

    /**
     * 13.2.3、散列集 (P576)
     */
    public static void set130203() {
        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();
        SortedSet sortedSet = new TreeSet();
        NavigableSet navigableSet = new TreeSet();

        hashSet.add("Lee");
        hashSet.add("lee");
        hashSet.add("eel");

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        TreeSet<String> treeSet02 = new TreeSet(comparator);
        treeSet02.add("Bob");
        treeSet02.add("Amy");
        treeSet02.add("David");
        treeSet02.add("Cinema");
        for (String item : treeSet02) {
            System.out.println(item);
        }
    }

    /**
     * 13.2.3、队列与双端队列 (P585)
     */
    public static void queue130206() {
        Deque deque = new ArrayDeque();
        Deque deque02 = new LinkedList();

        Queue queue = new LinkedList();

        ArrayQueue arrayQueue = new ArrayQueue(10);

        PriorityQueue<String> priorityQueue = new PriorityQueue();
        priorityQueue.add("yoong");
        priorityQueue.add("zara");
        priorityQueue.add("singapore");
        for (String item : priorityQueue) {
            System.out.println(item);
        }
    }

    /**
     * 13.2.8、映射表 (P587)
     */
    public static void map130208() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        Map hashTable = new Hashtable();
        Dictionary dictionary = new Hashtable();

        for (int i = 0; i < 100; i++) {
            hashMap.put(i, "HashMap " + i);
        }
        for (Map.Entry<Integer, String> item : hashMap.entrySet()) {
            System.out.println(item.getKey() + "：" + item.getValue());
        }

        Map<String, String> map = new HashMap();
        String value01 = map.put("1", "value-01");
        String value02 = map.put("1", "value-02");
        System.out.println(value01);
        System.out.println(value02);
        Properties properties = new Properties();
    }

    /**
     * 13.2.9、专用集与映射表类 (P591)
     */
    public static void specialCollection130209() {
        WeakHashMap weakHashMap = new WeakHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        //EnumSet enumSet = EnumSet.allOf();
        //EnumMap enumMap = new EnumMap();
        IdentityHashMap identityHashMap = new IdentityHashMap();
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
