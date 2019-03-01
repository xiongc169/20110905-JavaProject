package com.yoong.practice.api;

/**
 * @Desc ICityHelper
 * @Author
 * @Date 2019年3月1日15:28:03
 * @Version 1.0
 */
public interface ICityHelper {

    String getWeatherReport(String cityName);

    String getTrafficReport(String cityName);

    String getCityNews(String cityName);
}
