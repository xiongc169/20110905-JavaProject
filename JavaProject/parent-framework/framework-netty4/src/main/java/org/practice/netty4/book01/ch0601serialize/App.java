package org.practice.netty4.book01.ch0601serialize;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * App
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) throws Exception {
        UserInfo info = new UserInfo();
        info.buildUserId(1000).buildUserName("Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(info);
        oos.flush();
        oos.close();
        byte[] b = bos.toByteArray();
        System.out.println("The JDK Serializable Length is " + b.length);
        bos.close();
        System.out.println("The Byte Array Serializable Length is " + info.codeC().length);
    }
}
