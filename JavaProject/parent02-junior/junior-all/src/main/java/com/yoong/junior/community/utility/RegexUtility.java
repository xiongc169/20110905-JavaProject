package com.yoong.junior.community.utility;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc 正则表达式
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class RegexUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String pattern = "^\\d{2}$";
            boolean match = pattern.matches("123");
            boolean match2 = pattern.matches("12");
            System.out.println(match);
            System.out.println(match2);

            test();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 2018年11月8日15:38:18
     * Java 正则表达式
     * http://www.runoob.com/java/java-regular-expressions.html
     * java中正则表达式基本用法
     * https://www.cnblogs.com/xhj123/p/6032683.html
     * https://www.cnblogs.com/shuqi/p/4427693.html
     * http://www.cnblogs.com/ggjucheng/p/3423731.html
     * https://www.cnblogs.com/lzq198754/p/5780340.html
     */
    public static void test() {
        String input = "您好，这里是{coBankName}，请问是{customerName}的{sex+age}吗？";

        String pattern1 = "\\S*";
        boolean result1 = Pattern.matches(pattern1, input);
        boolean result2 = input.matches(pattern1);
        System.out.println(result1);
        System.out.println(result2);

        //注：\w，匹配任何字类字符，包括下划线，与[A-Za-z0-9_]等效
        Pattern pattern = Pattern.compile("\\{[\\w\\+]+\\}");
        String[] parts = pattern.split(input);
        System.out.println(parts.length);

        Matcher matcher = pattern.matcher(input);
        Integer count = matcher.groupCount();//无效
        System.out.println(count);

        MatchResult matchResult = matcher.toMatchResult();
        Integer count2 = matchResult.groupCount();//无效
        System.out.println(count2);

        int index = 0;
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            input = input.replace(group, index + "----" + index);
            index++;
        }

        if (matcher.find()) {
            String group0 = matcher.group(0);
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            System.out.println(group0);
            System.out.println(group1);
            System.out.println(group2);
        }
    }
}
