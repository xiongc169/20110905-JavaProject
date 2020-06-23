package org.practice.designPattern.create.ch05prototype;

import org.practice.designPattern.create.ch05prototype.community.Prototype;

/**
 * @Desc 原型模式
 * http://www.runoob.com/design-pattern/prototype-pattern.html
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
            prototype_community();
            prototype_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void prototype_community() throws Exception {
        Prototype prototype = new Prototype();
        prototype.setName("prototype");

        Prototype prototype02 = prototype;
        prototype02.setName("prototype-02");

        Prototype prototype03 = prototype.clone();
        prototype03.setName("prototype-03");
    }

    private static void prototype_runoob() {
    }
}
