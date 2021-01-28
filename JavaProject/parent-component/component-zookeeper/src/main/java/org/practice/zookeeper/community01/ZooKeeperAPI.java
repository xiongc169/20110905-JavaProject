package org.practice.zookeeper.community01;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Desc ZooKeeper客户端 - ZooKeeper原生API
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017年8月2日
 * <p>
 * @Version 1.0
 */
public class ZooKeeperAPI {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            zooKeeperDemo();
            zooKeeperDemo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ZooKeeper的Java客户端使用
     * https://www.cnblogs.com/LiZhiW/p/4923693.html
     * ZooKeeper API
     * https://developer.ibm.com/zh/articles/os-cn-zookeeper/
     */
    public static void zooKeeperDemo() throws Exception {
        // 创建一个与服务器的连接
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 100000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 监控所有被触发的事件
                System.out.println("Watcher001: " + event.toString());
            }
        });
        // 创建一个目录节点path、data、acl、createMode
        String createResult = zooKeeper.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 创建一个子目录节点
        String createResult02 = zooKeeper.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 查询目录节点的数据
        byte[] dataBytes = zooKeeper.getData("/testRootPath", true, null);
        String dataString = new String(dataBytes);
        System.out.println(dataString);

        // 取出子目录节点列表
        List<String> children = zooKeeper.getChildren("/testRootPath/testChildPathOne", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("Watcher002: " + event);
            }
        });
        System.out.println(children.size());

        // 修改子目录节点数据
        Stat setStat = zooKeeper.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
        Stat existStat = zooKeeper.exists("/testRootPath", true);
        System.out.println("设置状态：" + setStat);
        System.out.println("目录节点状态：" + existStat);

        // 创建另外一个子目录节点
        String createResult03 = zooKeeper.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] dataBytes02 = zooKeeper.getData("/testRootPath/testChildPathTwo", true, null);
        String dataString02 = new String(dataBytes02);
        System.out.println(dataString02);
        System.out.println(dataString02);

        // 删除子目录节点
        zooKeeper.delete("/testRootPath/testChildPathTwo", -1);
        zooKeeper.delete("/testRootPath/testChildPathOne", -1);
        // 删除父目录节点
        zooKeeper.delete("/testRootPath", -1);
        // 关闭连接
        zooKeeper.close();
    }

    /**
     * zookeeper 的Java客户端
     * https://www.jianshu.com/p/1db003ea69f5
     */
    public static void zooKeeperDemo2() throws Exception {
        //到计数器,默认倒数1下
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 创建一个与服务器的连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.182.129:2181", 100000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 监控所有被触发的事件
                System.out.println("已经触发了" + event.getType() + "事件！");
                //获取事件的状态
                Event.KeeperState state = event.getState();
                //获取事件类型
                Event.EventType type = event.getType();
                //校验连接状态和类型,连接上的状态为SyncConnected,类型为None
                if (Event.KeeperState.SyncConnected == state) {
                    if (Event.EventType.None == type) {
                        System.out.println("连接成功...");
                        countDownLatch.countDown();
                    }
                }
            }
        });
        Long sessionId = zooKeeper.getSessionId();
        byte[] sessionPwd = zooKeeper.getSessionPasswd();
        // 倒数计数器没有倒数完成,不能执行下面的代码.确保zookeeper对象创建成功
        System.out.println("连接中...");
        countDownLatch.await();
        System.out.println("连接成功！！！");

        // 关闭连接
        zooKeeper.close();
    }
}
