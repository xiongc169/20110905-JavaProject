package com.yoong.junior.community.utility;

/**
 * @Desc StringUtility
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class StringUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        StringTecent();
    }

    /**
     * 腾讯课堂——String
     */
    public static void StringTecent() {
        String result = "abc" + "def";
        System.out.println(result);

        String part1 = "opq";
        String part2 = "rst";
        part1 += part2;
        System.out.println(part1);
    }
}
