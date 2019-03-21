package org.practice.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * 
 * @author yoong
 *
 * @desc ZooKeeperClient
 *              https://www.ibm.com/developerworks/cn/opensource/os-cn-zookeeper/
 *
 * @date 2017年8月2日
 *
 * @version 1.0
 *
 */
public class ZooKeeperClient {

	/**
	 * 入口函数
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			operateZooKeeper();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hello World!");
	}

	public static void operateZooKeeper() throws Exception {

		// 创建一个与服务器的连接
		ZooKeeper zk = new ZooKeeper("192.168.119.131:" + 2181, 1000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				// 监控所有被触发的事件
				System.out.println("已经触发了" + event.getType() + "事件！");
			}
		});

		// 创建一个目录节点path、data、acl、createMode
		zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		// 创建一个子目录节点
		zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(new String(zk.getData("/testRootPath", false, null)));
		// 取出子目录节点列表
		System.out.println(zk.getChildren("/testRootPath", true));

		// 修改子目录节点数据
		zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
		System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");

		// 创建另外一个子目录节点
		zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));

		// 删除子目录节点
		zk.delete("/testRootPath/testChildPathTwo", -1);
		zk.delete("/testRootPath/testChildPathOne", -1);
		// 删除父目录节点
		zk.delete("/testRootPath", -1);
		// 关闭连接
		zk.close();
	}
}
