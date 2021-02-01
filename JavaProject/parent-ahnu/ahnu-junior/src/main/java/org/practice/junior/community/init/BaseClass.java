package org.practice.junior.community.init;

/**
 * @Desc BaseClass
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年4月2日
 * <p>
 * @Version 1.0
 */
public class BaseClass {

    private final String name = new String("baseClass-name");

    static {
        System.out.println("BaseClass Static 块");
    }

    static Foo FOO = new Foo("BaseClass static FOO");

    Foo foo = new Foo("BaseClass FOO");

    {
        System.out.println("BaseClass {}");
    }

    private String id = new String("baseClass-Id");

    private final String sex = new String("baseClass-sex");

    public BaseClass() {
        System.out.println("BaseClass Constructor");
    }

    public static void staticSay() {
        System.out.println("BaseClass staticSay");
    }

    public void say() {
        System.out.println("BaseClass say");
    }
}