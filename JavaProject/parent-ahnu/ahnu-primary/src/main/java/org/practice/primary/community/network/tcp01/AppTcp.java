package org.practice.primary.community.network.tcp01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc Java网络编程
 * PS：13.1.3、网络通讯方式
 * TCP、UDP，传输控制协议、用户数据报协议；
 * 13.2.2、Java网络编程技术
 * http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年4月4日 上午9:29:18
 * <p>
 * @Version 1.0
 */
public class AppTcp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Byte decodes = Byte.decode("yoong");
            Byte parse = Byte.parseByte("yoong");

            inetAddressDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void inetAddressDemo() {
        try {
            InetAddress inetA = InetAddress.getByName("www.baidu.com");
            InetAddress inetB = InetAddress.getByName("127.0.0.1");
            InetAddress inetC = InetAddress.getLocalHost();

            String host = inetC.getHostName();
            String ip = inetC.getHostAddress();
            System.out.println(host);
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
