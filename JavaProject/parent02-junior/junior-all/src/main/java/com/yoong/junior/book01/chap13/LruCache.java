package com.yoong.junior.book01.chap13;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Desc 缓存算法(FIFO 、 LRU 、 LFU三种算法的区别)
 * https://www.cnblogs.com/hongdada/p/10406902.html
 * https://tonydeng.github.io/2015/07/16/linkedhashmap-based-lrucache-implementation/
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    public LruCache(int cacheSize) {
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
