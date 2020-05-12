package org.practice.springfx.book01.part03_aop.ch01static.proxy;

import org.practice.springfx.api.ISubject;

/**
 * @Desc SubjectImpl
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月13日 下午2:26:34
 * <p>
 * @Version 1.0
 */
public class SubjectImpl implements ISubject {

    public String say(String name, int age) {
        String msg = name + "-" + age;
        System.out.println("SubjectImpl.say: " + msg);
        return msg;
    }

}
