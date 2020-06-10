package org.practice.primary.community.init02;

/**
 * @Desc OssUtils
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019-5-10 11:27:55
 * <p>
 * @Version 1.0
 */
public class OssUtils {

    static {
        System.out.println("static-01");
    }

    public static String name = "name";

    public static PropertiesUtils propertiesUtils = new PropertiesUtils("ossBucke.properties");

    private static String NODE_HANGZHOU = propertiesUtils.getProperty("NODE_HANGZHOU");

    private static String NODE_HANGZHOU_INTERNAL = propertiesUtils.getProperty("NODE_HANGZHOU_INTERNAL");

    static {
        System.out.println("static-02");
    }

    public static void upload() {
        String systemDir = propertiesUtils.getProperty("user.dir");
        System.out.println(systemDir);
        String nodeHangzhou = propertiesUtils.getProperty("NODE_HANGZHOU");
        System.out.println(nodeHangzhou);
    }

    public OssUtils() {
        System.out.println("OssUtils.OssUtils");
    }
}
