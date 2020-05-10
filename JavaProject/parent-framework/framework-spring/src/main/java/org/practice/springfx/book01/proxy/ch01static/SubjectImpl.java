package org.practice.springfx.book01.proxy.ch01static;

import org.practice.springfx.book01.proxy.api.ISubject;

public class SubjectImpl implements ISubject {

    public String say(String name, int age) {
        String msg = name + "  " + age;
        System.out.println("SubjectImpl.say " + msg);
        return msg;
    }

}
