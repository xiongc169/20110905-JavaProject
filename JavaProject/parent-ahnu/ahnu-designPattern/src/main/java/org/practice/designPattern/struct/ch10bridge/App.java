package org.practice.designPattern.struct.ch10bridge;

import org.practice.designPattern.struct.ch10bridge.community.Bridge;
import org.practice.designPattern.struct.ch10bridge.community.api.SourceSub1;
import org.practice.designPattern.struct.ch10bridge.community.api.SourceSub2;

/**
 * @Desc 桥接模式
 * http://www.runoob.com/design-pattern/bridge-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            bridge_community();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void bridge_community() {
        Bridge bridge = new Bridge();
        SourceSub1 sub1 = new SourceSub1();
        SourceSub2 sub2 = new SourceSub2();
        bridge.setSource(sub1);
        bridge.method();

        bridge.setSource(sub2);
        bridge.method();
    }
}
