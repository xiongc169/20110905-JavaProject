package com.yoong.designPattern.struct.ch06adapter;

import com.yoong.designPattern.struct.ch06adapter.community.clazz.Adapter;
import com.yoong.designPattern.struct.ch06adapter.community.clazz.Source;
import com.yoong.designPattern.struct.ch06adapter.community.clazz.Target;
import com.yoong.designPattern.struct.ch06adapter.community.interfase.AbstractWrapper;
import com.yoong.designPattern.struct.ch06adapter.community.interfase.SourceSubB;
import com.yoong.designPattern.struct.ch06adapter.community.interfase.SourceSubC;
import com.yoong.designPattern.struct.ch06adapter.community.obj.Wrapper;
import com.yoong.designPattern.struct.ch06adapter.player01.AudioPlayer;

/**
 * @Desc 适配器模式
 * http://www.runoob.com/design-pattern/adapter-pattern.html
 * 适配器模式
 * PS：分为三类：类的适配器、对象的适配器、接口的适配器；
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。 *
 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
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
            adapter_runoob();
            adapter_community();
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

    private static void adapter_community() {
        //类的适配器模式：Adapter类继承Source类，实现Target接口，这样Target接口的实现类就具有了Source类的功能
        Target target = new Adapter();
        target.method1();
        target.method2();
        target.method3();
        System.out.println();

        //对象的适配器模式：基本思路和类的适配器模式相同，但修改Adapter类，不再继承Source类，而是持有Source类的实例，以达到解决兼容性的问题。
        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();
        wrapper.method3();
        System.out.println();

        //接口的适配器模式：一个接口中有多个抽象方法，实现该接口时，必须实现所有方法，比较费时。
        //所以引入了接口的适配器模式，借助于一个抽象类 AbstractClass, 该抽象类实现了该接口 Interface, 实现了所有的方法。而我们不和原始的接口打交道，只和该抽象类取得联系，所以我们写一个类，继承该抽象类，重写我们需要的方法就行。
        Target abstractWrapper = new AbstractWrapper();
        Target sourceSubB = new SourceSubB();
        Target sourceSubC = new SourceSubC();
        abstractWrapper.method2();
        abstractWrapper.method3();
        sourceSubB.method2();
        sourceSubB.method3();
        sourceSubC.method2();
        sourceSubC.method3();
    }
}
