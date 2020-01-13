package org.practice.primary.book01.chap05;

/**
 * @Desc Executive
 * @Author
 * @Date
 * @Version 1.0
 */
public class Executive extends Manager {

    {
        System.out.println("Executive 代码块");
    }

    static {
        System.out.println("Executive 静态代码块");
    }

    public Executive() {
        System.out.println("Executive.Executive()");
        super.greet();//调用直接父类的greet()方法；
    }

    public String greet() {
        System.out.println("Executive.greet()");
        String greet = "Executive " + this.getName();
        return greet;
    }

    public String getTitle() {
        System.out.println("Executive.getTitle()");
        return "Executive.getTitle()";
    }
}
