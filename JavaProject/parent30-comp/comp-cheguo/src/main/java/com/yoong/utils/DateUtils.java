package com.yoong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * @Desc DateUtils
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年1月15日
 * <p>
 * @Version 1.0
 */
public class DateUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            format();
            getYearMonthDay();
            List<String> payDate = getMonthList("2017-01", "2018-02");
            List<String> payDate2 = getMonthBetween("2017-01", "2018-02");
            System.out.println(payDate.size());
            System.out.println(payDate2.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java中Date转换大全，返回yyyy-MM-dd的Date类型
     * https://www.cnblogs.com/endtel/p/6018429.html
     */
    public static void format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowStr = sdf.format(now);
        String nowStr2 = sdf2.format(now);
        System.out.println(now);
        System.out.println(nowStr);
        System.out.println(nowStr2);

        String serial = StringUtils.leftPad(String.valueOf(1), 4, '0');
        System.out.println(serial);
    }

    public static String getYearMonthDay() {
        JSONObject contractParam = new JSONObject();
        contractParam.put("7", Calendar.getInstance().get(Calendar.YEAR));
        contractParam.put("8", Calendar.getInstance().get(Calendar.MONTH) + 1);
        contractParam.put("9", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        System.out.println(contractParam.toJSONString());
        return contractParam.toJSONString();
    }

    public static List<String> getMonthList(String monthBegin, String monthEnd) throws ParseException {
        List<String> payDate = new ArrayList<String>();
        Date monthBeginDate = new SimpleDateFormat("yyyy-MM").parse(monthBegin);// 定义起始日期
        Date monthEndDate = new SimpleDateFormat("yyyy-MM").parse(monthEnd);// 定义结束日期
        Calendar dd = Calendar.getInstance();// 定义日期实例
        dd.setTime(monthBeginDate);// 设置日期起始时间
        while (dd.getTime().before(monthEndDate)) {// 判断是否到结束日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String str = sdf.format(dd.getTime());
            System.out.println(str);// 输出日期结果
            dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
            payDate.add(str);
        }
        return payDate;
    }

    /**
     * java获得两个日期之间的所有月份
     * https://www.cnblogs.com/zq-boke/p/5868254.html
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }
}
