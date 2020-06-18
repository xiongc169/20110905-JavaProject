package org.practice.primary.book01.chap13;

import com.alibaba.fastjson.JSON;
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
            Integer DEFAULT_INITIAL_CAPACITY = 1 << 4; //2^4 = 16
            Integer MAXIMUM_CAPACITY = 1 << 30; //2^30 = 1073741824
            System.out.println(DEFAULT_INITIAL_CAPACITY);
            System.out.println(MAXIMUM_CAPACITY);
            //Demo
            collectionApi1301();
            collection1302();
            set130203();
            queue130206();
            map130208();
            specialCollection130209();
            viewAndWrapper130301();
            algorithm1304();
            oldCollection1305();
            //练习
            removeTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 13.1、集合接口 (P560)
     */
    public static void collectionApi1301() {
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
     * 13.2、具体的接口：链表(LinkedList)、数组列表(ArrayList) (P567)
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

        //JSON序列化，transient属性不会序列化，static属性不会序列化
        String linkedListJson = JSON.toJSONString(linkedList);
        System.out.println(linkedListJson);//["head","Amy","Bob","Carl"]

        ArrayList arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.add("Fourth");
        arrayList.add("Fifth");
        arrayList.add("Sixth");
        arrayList.add("Seventh");
        arrayList.add("Eighth");
        arrayList.add("Ninth");
        arrayList.add("Tenth");
        arrayList.add("Eleventh");//无参构造函数，默认容量是10，这里会扩容1.5倍，Arrays.copyOf(elementData, newCapacity)
        arrayList.add("Twelfth");
        arrayList.add("Thirteenth");
        arrayList.add("Fourteenth");
        arrayList.add("Fifteenth");
        arrayList.add("Sixteenth");//无参构造函数，扩容1.5倍后，这里会继续扩容1.5倍
        arrayList.add("Seventeenth");
        arrayList.add("Eighteenth");
        arrayList.add("Nineteenth");
        arrayList.add("Thirteenth");
        arrayList.add("Twentieth");
        arrayList.add("Twenty-First");
        arrayList.add("Twenty-Second");
        for (Object object : arrayList) {
            System.out.println(object);
        }
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

        TreeSet<String> treeSet02 = new TreeSet();
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
        Map hashTable = new Hashtable();
        Dictionary dictionary = new Hashtable();
        HashMap<Integer, String> hashMap = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();

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
        Enumeration enumeration = properties.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
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

    /**
     * 13.3.1、视图与包装器 (P598)
     */
    public static void viewAndWrapper130301() {
        //轻量级包装器
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = Arrays.asList(intArray);
        System.out.println(intList.size());

        List<String> copyList = Collections.nCopies(0, "Default");
        System.out.println(copyList.size());

        Set<Integer> singleton = Collections.singleton(2);
        List<Integer> singletonList = Collections.singletonList(2);
        Map<String, String> singletonMap = Collections.singletonMap("id", "id-001");

        //子范围
        List<Integer> subList = intList.subList(1, 4);// [)
        subList.clear();

        //不可修改的视图
        Collections.unmodifiableCollection(null);
        Collections.unmodifiableList(null);
        Collections.unmodifiableSet(null);
        Collections.unmodifiableSortedSet(null);
        Collections.unmodifiableMap(null);
        Collections.unmodifiableSortedMap(null);

        //同步视图
        Collections.synchronizedCollection(null);
        Collections.synchronizedList(null);
        Collections.synchronizedSet(null);
        Collections.synchronizedSortedSet(null);
        Collections.synchronizedMap(null);
        Collections.synchronizedSortedMap(null);

        //检查视图
        Collections.checkedList(subList, Integer.class);
    }

    /**
     * 13.4、算法 (P606)
     */
    public static void algorithm1304() {
        Collections.max(null);
        Collections.sort(null);
        Collections.sort(null, Collections.reverseOrder());
        Collections.shuffle(null);

        //13.4.2、二分查找
        Collections.binarySearch(null, null);

        //13.4.3、简单算法
        Collections.min(null);
        Collections.copy(null, null);
        Collections.fill(null, null);
    }

    /**
     * 13.5、遗留的集合 (P613)
     */
    public static void oldCollection1305() {
        Hashtable hashtable = new Hashtable();
        Properties properties = new Properties();
        Vector vector = new Vector();
        Stack stack = new Stack();
        BitSet bitSet = new BitSet();

        Enumeration enumeration = hashtable.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
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
