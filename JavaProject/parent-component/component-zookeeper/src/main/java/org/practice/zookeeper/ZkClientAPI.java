package org.practice.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @Desc ZooKeeper客户端 - ZkClient
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017年8月2日
 * <p>
 * @Version 1.0
 */
public class ZkClientAPI {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            zkClientDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ZooKeeper 的Java客户端
     * PS：ZooKeeper服务器有三种Java客户端:
     * 1、ZooKeeper，Zookeeper官方提供的原生Java客户端；
     * 2、ZkClient，在原生Zookeeper基础上进行扩展的开源第三方Java客户端；
     * 3、Curator，Netflix公司在原生zookeeper基础上开源的Java客户端；
     * CountDownLatch计数器。
     * https://www.jianshu.com/p/1db003ea69f5
     */
    public static void zkClientDemo() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 50000);
        Boolean exist = zkClient.exists("/zkClient");
        System.out.println(exist);

        if (!exist) {
            String createResult = zkClient.create("/zkClient", "zkClientData".getBytes(), CreateMode.PERSISTENT);
            System.out.println(createResult);
        }

        List<String> children = zkClient.getChildren("/");
        System.out.println(children);

        byte[] readResult = zkClient.readData("/zkClient");
        System.out.println(new String(readResult));

        zkClient.writeData("/zkClient", "newZkClientData".getBytes());

        byte[] readResult02 = zkClient.readData("/zkClient");
        System.out.println(new String(readResult02));

        Boolean deleteResult = zkClient.deleteRecursive("/zkClient");
        System.out.println(deleteResult);
    }
}
