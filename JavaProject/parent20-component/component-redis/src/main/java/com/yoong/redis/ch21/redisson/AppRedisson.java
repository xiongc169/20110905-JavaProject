package com.yoong.redis.ch21.redisson;

import org.redisson.Redisson;
import org.redisson.api.*;

/**
 * @Desc Redis 客户端 Redisson
 * https://www.oschina.net/p/redisson
 * https://github.com/redisson/redisson/wiki
 * Redisson基本用法
 * https://www.cnblogs.com/cjsblog/p/11273205.html
 * 为什么 Redisson 会有这么好用
 * https://zhuanlan.zhihu.com/p/97484791
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-3-31 14:50:41
 * <p>
 * @Version 1.0
 */
public class AppRedisson {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            redissonListDemo();
            redissonMapDemo();
            redissonLockDemo();
            redissonAutomicDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void redissonListDemo() throws Exception {
        // 默认连接上 127.0.0.1:6379
        RedissonClient client = Redisson.create();
        // RList 继承了 java.util.List 接口
        RList<String> nameList = client.getList("nameList");
        nameList.clear();
        nameList.add("bingo");
        nameList.add("yanglbme");
        nameList.add("https://github.com/yanglbme");
        nameList.remove(-1);
        boolean contains = nameList.contains("yanglbme");
        System.out.println("List size: " + nameList.size());
        System.out.println("Is list contains name 'yanglbme': " + contains);
        nameList.forEach(System.out::println);
        client.shutdown();
    }

    public static void redissonMapDemo() throws Exception {
        // 默认连接上127.0.0.1:6379
        RedissonClient client = Redisson.create();
        // RMap 继承了 java.util.concurrent.ConcurrentMap 接口
        RMap<String, String> map = client.getMap("personalInfo");
        map.put("name", "yanglbme");
        map.put("address", "Shenzhen");
        map.put("link", "https://github.com/yanglbme");
        boolean contains = map.containsKey("link");
        System.out.println("Map size: " + map.size());
        System.out.println("Is map contains key 'link': " + contains);
        String value = map.get("name");
        System.out.println("Value mapped by key 'name': " + value);
        boolean added = map.putIfAbsent("link", "https://doocs.github.io") == null;
        System.out.println("Is value mapped by key 'link' added: " + added);
        client.shutdown();
    }

    public static void redissonLockDemo() throws Exception {
        // 默认连接上127.0.0.1:6379
        RedissonClient client = Redisson.create();
        // RLock 继承了 java.util.concurrent.locks.Lock 接口
        RLock lock = client.getLock("lock");
        lock.lock();
        System.out.println("lock acquired");
        Thread t = new Thread(() -> {
            System.out.println("Join Thread run()...");
            RLock lock1 = client.getLock("lock");
            lock1.lock();
            System.out.println("lock acquired by thread");
            lock1.unlock();
            System.out.println("lock released by thread");
        });
        t.start();
        t.join(2000);
        System.out.println("Join Finished");
        lock.unlock();
        System.out.println("lock released");
        t.join();
        client.shutdown();
    }

    public static void redissonAutomicDemo() {
        // 默认连接上127.0.0.1:6379
        RedissonClient client = Redisson.create();
        RAtomicLong atomicLong = client.getAtomicLong("myLong");
        System.out.println("Init value: " + atomicLong.get());
        atomicLong.incrementAndGet();
        System.out.println("Current value: " + atomicLong.get());
        atomicLong.addAndGet(10L);
        System.out.println("Final value: " + atomicLong.get());
        client.shutdown();
    }
}
