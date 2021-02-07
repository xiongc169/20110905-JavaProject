package com.yoong.xclient;

import com.yoong.xclient.api.ICityHelper;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

/**
 * @Desc AppXfireClient
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月1日15:28:03
 * <p>
 * @Version 1.0
 */
public class AppXfireClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            xfireClient();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void xfireClient() throws Exception {
        Service service = new ObjectServiceFactory().create(ICityHelper.class);
        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
        String url = "http://localhost:8080/xfire_server/services/CityService";
        ICityHelper cityHelper = (ICityHelper) factory.create(service, url);
        System.out.println(cityHelper.getWeatherReport("Hangzhou"));
        System.out.println(cityHelper.getTrafficReport("Hangzhou"));
        System.out.println(cityHelper.getCityNews("Hangzhou"));
    }
}
