package com.yoong.designPattern.struct.ch08proxy;

import com.yoong.designPattern.struct.ch08proxy.runoob.ProxyImage;

/**
 * @Desc 代理模式
 * http://www.runoob.com/design-pattern/proxy-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            proxy_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void proxy_runoob() {
        ProxyImage proxy = new ProxyImage("beautiful");
        proxy.display();
    }
}
