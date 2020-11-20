package org.practice.junior.community.inherit01;

/**
 * @Desc 如果一个类实现了一个接口，又继承了一个类，如果接口和父类有同名的变量
 * https://zhidao.baidu.com/question/107588610.html
 * 接口和父类具有同名属性、方法重载
 * https://blog.csdn.net/yechaodechuntian/article/details/51861683
 * java中子类继承父类和实现接口有同名方法怎么处理
 * https://blog.csdn.net/xichengqc/article/details/78380244
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年4月2日
 * <p>
 * @Version 1.0
 */
public class App extends BaseB implements InterfaceA {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //编译不通过，对a的引用不明确
        //System.out.println(a);
        //System.out.println((new App()).a);
    }

}
