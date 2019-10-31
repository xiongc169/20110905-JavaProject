package org.practice.primary.community.network.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chaoxiong
 * @desc Java网络编程
 * http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 * <p>
 * @date 2016年4月4日 上午9:29:18
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Byte decodes = Byte.decode("chaoxiong");
            Byte parse = Byte.parseByte("chaoxiong");

            inetAddressDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return void
     * @desc 演示InetAddress类的基本使用
     * @author chaoxiong
     * @date 2016年4月4日 上午9:38:05
     */
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
