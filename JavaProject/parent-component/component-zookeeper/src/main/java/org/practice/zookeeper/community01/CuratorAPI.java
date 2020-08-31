package org.practice.zookeeper.community01;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Desc ZooKeeper客户端 - Curator
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017年8月2日
 * <p>
 * @Version 1.0
 */
public class CuratorAPI {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            curatorDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ZooKeeper的Java客户端使用
     * https://www.cnblogs.com/LiZhiW/p/4923693.html
     */
    public static void curatorDemo() throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryNTimes(2, 1000));
        CuratorFramework curatorFramework02 = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .namespace("yoong")
                .retryPolicy(new ExponentialBackoffRetry(1000, 2))
                .build();

        curatorFramework.start();
        List<String> children = curatorFramework.getChildren().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("Watcher.process " + event);
            }
        }).forPath("/");
        System.out.println(children);

        String path = curatorFramework.create().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath("/yoong", "yoongData".getBytes());
        List<String> addChildren = curatorFramework.getChildren().forPath("/");
        System.out.println(addChildren);

        curatorFramework.setData().forPath("/yoong", "newYoongData".getBytes());
        List<String> setChildren = curatorFramework.getChildren().forPath("/");
        System.out.println(setChildren);

        Stat existStat = curatorFramework.checkExists().forPath("/yoong");
        System.out.println(existStat);

        curatorFramework.delete().forPath("/yoong");
        List<String> delChildren = curatorFramework.getChildren().forPath("/");
        System.out.println(delChildren);
    }
}
