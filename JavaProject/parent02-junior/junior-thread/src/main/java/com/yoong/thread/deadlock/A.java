package com.yoong.thread.deadlock;

public class A {

    public static void main(String[] args) {
        A.synA();
    }

    public static synchronized void synA() {
        try {
            System.out.println("A:进入synA");
            Thread.sleep(2000);
            System.out.println("A:申请B.synB");
            B.synB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
