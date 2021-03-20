package com.yoong.thread.deadlock;

public class B {

    public static void main(String[] args) {
        B.synB();
    }

    public static synchronized void synB() {
        try {
            System.out.println("B:进入synA");
            Thread.sleep(2000);
            System.out.println("B:申请A.synA");
            A.synA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
