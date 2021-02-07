package com.yoong.junior.community.init;

/**
 * @Desc DeriveClass
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年4月2日
 * <p>
 * @Version 1.0
 */
public class DeriveClass extends BaseClass {

    private final String name = new String("deriveClass-name");

    static {
        System.out.println("DeriveClass Static 块");
    }

    static Foo FOO = new Foo("DeriveClass static FOO");

    {
        System.out.println("DeriveClass {}");
    }

    private String id = new String("deriveClass-Id");

    private final String sex = new String("deriveClass-sex");

    Foo foo = new Foo("DeriveClass FOO");

    public DeriveClass() {
        System.out.println("DeriveClass Constructor");
    }

    public static void staticSay() {
        System.out.println("DeriveClass staticSay ");
    }

    @Override
    public void say() {
        System.out.println("DeriveClass say");
    }
}
