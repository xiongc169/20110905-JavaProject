package com.yoong.xserver.api;

/**
 * @Desc ICityHelper
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月1日15:28:03
 * <p>
 * @Version 1.0
 */
public interface ICityHelper {

    String getWeatherReport(String cityName);

    String getTrafficReport(String cityName);

    String getCityNews(String cityName);
}
