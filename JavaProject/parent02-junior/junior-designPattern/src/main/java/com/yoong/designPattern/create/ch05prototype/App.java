package com.yoong.designPattern.create.ch05prototype;

import com.yoong.designPattern.create.ch05prototype.community.Prototype;
import com.yoong.designPattern.create.ch05prototype.community.Ticket;

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
        Ticket ticket = new Ticket();

        Prototype prototype = new Prototype();
        prototype.setName("prototype");
        prototype.setTicket(ticket);

        Prototype prototype02 = prototype;
        prototype02.setName("prototype-02");//影响

        Prototype prototype03 = prototype.clone();
        System.out.println(prototype03.getName() == prototype.getName());//true，浅拷贝
        prototype03.setName(new String("prototype-02"));//不可变，所以不影响
        System.out.println(prototype03.getName() == prototype.getName());//false
        prototype03.setId(20);//不可变，所以不影响
        prototype03.getTicket().setId(20);//影响

        Prototype prototype04 = (Prototype) prototype.deepClone();
        System.out.println(prototype04.getName() == prototype.getName());//false，深拷贝
        prototype04.setId(30);//不影响
        prototype04.getTicket().setId(30);//不影响

        int input = System.in.read();
        System.out.println(input);
    }

    private static void prototype_runoob() {
    }
}
