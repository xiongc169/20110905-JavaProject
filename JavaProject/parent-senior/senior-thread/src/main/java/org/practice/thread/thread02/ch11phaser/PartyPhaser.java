package org.practice.thread.thread02.ch11phaser;

import java.util.concurrent.Phaser;

public class PartyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                // 所有注册的线程都到达第一个屏障后，执行这个case
                System.out.println("所有人均已吃完，共：" + registeredParties + " 人");
                return false;
            case 1:
                // 所有注册的线程都到达第二个屏障后，执行这个case
                System.out.println("所有人均已达到KTV，共：" + registeredParties + " 人");
                return false;
            case 2:
                // 所有注册的线程都到达第三个屏障后，执行这个case
                System.out.println("所有人均已到达电影院，共：" + registeredParties + " 人");
                return true;
            default:
                return true;
        }
    }
}
