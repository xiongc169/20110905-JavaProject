package org.practice.redis.ch21.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class AppRedisson {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            // 默认连接上127.0.0.1:6379
            RedissonClient client = Redisson.create();
            // RLock 继承了 java.util.concurrent.locks.Lock 接口
            RLock lock = client.getLock("lock");
            lock.lock();
            System.out.println("lock acquired");
            Thread t = new Thread(() -> {
                RLock lock1 = client.getLock("lock");
                lock1.lock();
                System.out.println("lock acquired by thread");
                lock1.unlock();
                System.out.println("lock released by thread");
            });
            t.start();
            t.join(1000);
            lock.unlock();
            System.out.println("lock released");
            t.join();
            client.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
