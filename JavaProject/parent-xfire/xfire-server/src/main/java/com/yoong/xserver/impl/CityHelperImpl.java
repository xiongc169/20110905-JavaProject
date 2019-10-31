package com.yoong.xserver.impl;

import com.yoong.xserver.api.ICityHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc CityHelperImpl
 * PS：XFire框架实现WebService，201902-riskctrlgw与junyu的对接框架；
 * http://localhost:8080/xfire_server/services
 * @Author
 * @Date 2019年3月1日15:28:34
 * @Version 1.0
 */
public class CityHelperImpl implements ICityHelper {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String getWeatherReport(String cityName) {
        String weather = format.format(new Date()) + " " + cityName + " Sunny ";
        return weather;
    }

    @Override
    public String getTrafficReport(String cityName) {
        String traffic = format.format(new Date()) + " " + cityName + " Traffic Well ";
        return traffic;
    }

    @Override
    public String getCityNews(String cityName) {
        String news = format.format(new Date()) + " " + cityName + " Very Harmony ";
        return news;
    }
}
