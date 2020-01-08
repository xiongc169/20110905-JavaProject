package org.practice.primary.community.inherit;

/**
 * @Desc AppInherit
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月28日20:37:27
 * <p>
 * @Version 1.0
 */
public class AppInherit {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            AbstractBaseHandler baseHandler = new AbstractJunHandler();
            String time = baseHandler.getTime();
            String time2 = (String) baseHandler.handle(100l);

            System.out.println(time);
            System.out.println(time2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
