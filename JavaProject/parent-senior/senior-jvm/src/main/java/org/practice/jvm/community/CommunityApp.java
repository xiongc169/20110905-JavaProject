package org.practice.jvm.community;

/**
 * @Desc CommunityApp
 * @Author
 * @Date
 * @Version 1.0
 */
public class CommunityApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
