package org.practice.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Desc ZooKeeper客户端 - 原生API
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
            operateZooKeeper();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }

    /**
     * ZooKeeper API
     * https://www.ibm.com/developerworks/cn/opensource/os-cn-zookeeper/
     */
    public static void operateZooKeeper() throws Exception {

        // 创建一个与服务器的连接
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 60000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 监控所有被触发的事件
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });

        // 创建一个目录节点path、data、acl、createMode
        String createResult = zooKeeper.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 创建一个子目录节点
        String createResult02 = zooKeeper.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] dataBytes = zooKeeper.getData("/testRootPath", false, null);
        String dataString = new String(dataBytes);
        System.out.println(dataString);
        // 取出子目录节点列表
        List<String> children = zooKeeper.getChildren("/testRootPath", true);
        System.out.println(children.size());

        // 修改子目录节点数据
        Stat setStat = zooKeeper.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
        Stat existStat = zooKeeper.exists("/testRootPath", true);
        System.out.println("设置状态：[" + setStat + "]");
        System.out.println("目录节点状态：[" + existStat + "]");

        // 创建另外一个子目录节点
        String createResult03 = zooKeeper.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] dataBytes02 = zooKeeper.getData("/testRootPath/testChildPathTwo", false, null);
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
}
