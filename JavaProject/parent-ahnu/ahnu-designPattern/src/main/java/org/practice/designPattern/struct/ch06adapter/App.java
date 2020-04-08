package org.practice.designPattern.struct.ch06adapter;

import org.practice.designPattern.struct.ch06adapter.adapter.clazz.Source;
import org.practice.designPattern.struct.ch06adapter.adapter.interfase.AbstractWrapper;
import org.practice.designPattern.struct.ch06adapter.adapter.interfase.SourceSubB;
import org.practice.designPattern.struct.ch06adapter.adapter.interfase.SourceSubC;
import org.practice.designPattern.struct.ch06adapter.adapter.obj.Wrapper;
import org.practice.designPattern.struct.ch06adapter.player01.AudioPlayer;
import org.practice.designPattern.struct.ch06adapter.adapter.clazz.Adapter;
import org.practice.designPattern.struct.ch06adapter.adapter.clazz.Target;

/**
 * 适配器模式
 * http://www.runoob.com/design-pattern/adapter-pattern.html
 * 适配器模式
 * PS：分为三类：类的适配器、对象的适配器、接口的适配器；
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。 *
 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            adapter_runoob();
            adapter_accidence();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void adapter_runoob() {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

    private static void adapter_accidence() {
        //类的适配器模式
        Target target = new Adapter();
        ((Adapter) target).methodA();
        target.methodB();
        target.methodC();
        System.out.println();

        //对象的适配器模式
        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        wrapper.methodB();
        wrapper.methodC();
        System.out.println();

        //接口的适配器模式
        Target abstractWrapper = new AbstractWrapper();
        Target sourceSubB = new SourceSubB();
        Target sourceSubC = new SourceSubC();
        abstractWrapper.methodB();
        abstractWrapper.methodC();
        sourceSubB.methodB();
        sourceSubB.methodC();
        sourceSubC.methodB();
        sourceSubC.methodC();
    }
}
