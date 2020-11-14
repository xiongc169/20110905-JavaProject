package org.practice.primary.book01.chap14.thread02.ch11phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class Person implements Runnable {
    private final Random random = new Random();
    private String name;
    private Phaser phaser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phaser getPhaser() {
        return phaser;
    }

    public void setPhaser(Phaser phaser) {
        this.phaser = phaser;
    }

    public Person(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        eat();
        sing();
        film();
    }

    // 吃饭
    public void eat() {
        sleep(random.nextInt(1000));
        System.out.println(name + " 已经吃完");
        // 到达某个阶段，等待其他线程到达
        phaser.arriveAndAwaitAdvance();
    }

    // 唱歌
    public void sing() {
        if ("p0p1".contains(name)) {
            // p0、p1不去唱歌
            // 线程到达后，注销该线程（不参与接下来的流程）
            phaser.arriveAndDeregister();
        } else {
            // 其余的人去唱歌
            sleep(random.nextInt(1000));
            System.out.println(name + " 已经到达KTV");
            // 到达某个阶段，等待其他线程到达
            phaser.arriveAndAwaitAdvance();
        }
    }

    // 看电影
    public void film() {
        if ("p2p3".contains(name)) {
            // p2、p3不去看电影
            // 线程到达后，注销该线程（不参与接下来的流程）
            phaser.arriveAndDeregister();
        } else if (!"p0p1".contains(name)) {
            // p4、p5去看电影
            sleep(random.nextInt(1000));
            System.out.println(name + " 已经到达电影院");
            // 到达某个阶段，等待其他线程到达
            phaser.arriveAndAwaitAdvance();
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
