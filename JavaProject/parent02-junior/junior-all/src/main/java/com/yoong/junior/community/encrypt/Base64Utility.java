package com.yoong.junior.community.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * @Desc Base64Utility
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年7月5日 下午3:59:23
 * <p>
 * @Version 1.0
 */
public class Base64Utility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            sunMiscDemo();
            javaDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sunMiscDemo() throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        BASE64Decoder decode = new BASE64Decoder();

        byte[] input = "This is a Secret".getBytes();
        String output = encoder.encode(input);
        byte[] b1 = decode.decodeBuffer(output);
        String dStr1 = new String(b1);
        System.out.println(dStr1);

        // MTIzNDU2Nzg5MC1hc2RmZ2hqa2wt54ix5LiK5a+55pa56L+H5ZCO5bCx5ZOt5LqGLTIwMTYtNy03IDE1OjQ2OjUy
        String description = "MTIzNDU2Nzg5MC1xd2VydHl1aW8t5Y67546p5YS/56ul5LiO5qyn5pmuLTIwMTYtNy04IDEwOjQ3OjE1";

        byte[] b = decode.decodeBuffer(description);
        String dStr = new String(b);
        System.out.println(dStr);
    }

    private static void javaDemo() throws Exception {
        String hello = "hello";
        byte[] bytes = Base64.getDecoder().decode(hello);
        System.out.println(bytes.length);
    }
}
