package org.practice.primary.book01.chap13;

import com.alibaba.fastjson.JSON;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Desc 《Java核心技术·卷1》第十三章、集合
 * PS：集合操作类 集合的类型，各个类型的特点，遍历的几种方式；
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
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
            hashMap130208();
            hashtable130208();
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
        stack.push("AAAA");
        stack.add("AAAA");
        hashtable.put("Key", "Value");

        int num = 10;
        for (int i = 0; i < num; i++) {
            vector.add("vector-" + i);
        }
        //遍历一
        for (Object obj : vector) {
            System.out.println(obj);
        }
        //遍历二
        vector.forEach(item -> System.out.println(item));
        //遍历三
        Enumeration vectorEnumeration = vector.elements();
        Enumeration stackEnumeration = stack.elements();
        while (vectorEnumeration.hasMoreElements()) {
            System.out.println(vectorEnumeration.nextElement());
        }

        Iterable iterable = new ArrayList();
        Collection collection = new ArrayList();
        List list = new ArrayList();
        AbstractCollection abstractCollection = new ArrayList();
        AbstractList abstractList = new ArrayList();
        for (int i = 0; i < num; i++) {
            ((ArrayList) iterable).add("iterable-" + i);
        }
        //遍历一
        for (Object item : iterable) {
            System.out.println(item);
        }
        //遍历二
        iterable.forEach(item -> System.out.println(item));
        //遍历三
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            //iterator.add();
        }
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
            listIterator.add("Dell");
            listIterator.set("Modified");
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
     * 13.2.3、散列集HashSet (P576)
     * 13.2.4、树集TreeSet (P579)
     * 13.2.5、对象的比较 (P580)
     */
    public static void set130203() {
        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();
        SortedSet sortedSet = new TreeSet();
        NavigableSet navigableSet = new TreeSet();

        int num = 100;
        for (int i = 0; i < num; i++) {
            hashSet.add("hashSet-" + i);
        }
        //输出方式一 (乱序)
        for (Object object : hashSet) {
            System.out.println(object);
        }
        //输出方式二 (乱序)
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Comparable comparable = null;
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
        //输出方式一 (按字典顺序输出)
        for (String item : treeSet02) {
            System.out.println(item);
        }
    }

    /**
     * 13.2.6、队列与双端队列 Queue\Deque (P585)
     * 13.2.7、优先级队列 Queue\Deque (P585)
     */
    public static void queue130206() {
        Deque deque = new ArrayDeque();
        Deque deque02 = new LinkedList();
        Queue queue = new LinkedList();
        ArrayQueue arrayQueue = new ArrayQueue(10);
        PriorityQueue<String> priorityQueue = new PriorityQueue();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

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
    public static void hashMap130208() {
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        //tableSizeFor is not public in HashMap, Cannot be accessed from outside package
        //HashMap.tableSizeFor(10);
        Integer threshold = tableSizeFor(2);
        System.out.println(threshold);

        int num = 100;
        for (int i = 0; i < num; i++) {
            //key 0、key 11会冲突，hashmap.table[12]处存储
            hashMap.put("key " + i, "value " + i);
        }
        for (Map.Entry<String, String> item : hashMap.entrySet()) {
            System.out.println(item.getKey() + "：" + item.getValue());
        }
        //HashMap.Entry has private access in Hashtable
        //for (HashMap.EntrySet item : hashMap.entrySet()) {
        //    System.out.println(item.getKey() + "：" + item.getValue());
        //}

        Map<String, String> map = new HashMap();
        String value01 = map.put("1", "value-01");
        String value02 = map.put("1", "value-02");
        System.out.println(value01);
        System.out.println(value02);
    }

    /**
     * 13.2.8、映射表 (P587)
     */
    public static void hashtable130208() {
        Dictionary dictionary = new Hashtable();
        Hashtable<String, String> hashtable = new Hashtable();
        //hashtable.put(null, "value ");//key为空，计算key.hashCode()时，会报空指针异常
        //hashtable.put("key", "value pre");
        //String value01 = hashtable.get("key");
        //hashtable.put("key", "value ");//若key重复，会覆盖
        //String value02 = hashtable.get("key");
        //hashtable.putIfAbsent("key", "value post");//若key重复，不会保存
        //String value03 = hashtable.get("key");

        int num = 100;
        for (int i = 0; i < num; i++) {
            hashtable.put("key " + i, "value " + i);
        }
        for (Map.Entry<String, String> item : hashtable.entrySet()) {
            System.out.println(item.getKey() + "：" + item.getValue());
        }
        //Hashtable.Entry has private access in Hashtable
        //for (Hashtable.Entry<String,String> item : hashTable.entrySet()) {
        //    System.out.println(item.getKey() + "：" + item.getValue());
        //}

        Properties properties = new Properties();
        Enumeration enumeration = properties.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    static final int tableSizeFor(int cap) {
        Integer MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 13.2.9、专用集与映射表类 (P591)
     */
    public static void specialCollection130209() {
        WeakHashMap weakHashMap = new WeakHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 5; i++) {
            linkedHashMap.put(i, i);
        }
        System.out.println(linkedHashMap.get(2));
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
