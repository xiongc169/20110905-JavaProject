package org.practice.book01.chap03;

import java.io.Console;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author yoong
 * <br>
 * @desc DataType
 * <br>
 * @date 2019/2/1 11:50
 */
public class DataType {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("Java\u2122");

            intType();
            floatType();
            operator();
            stringTest();
            inputOutput();
            bigDecimalTest();
            stringTest2();

            integerTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 3.3、数据类型
     */
    public static void intType() {
        int a = 010;
        int b = 0x10;
        int c = 0b10;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

        int d = 'A';
        System.out.println("d: " + d);
    }

    public static void floatType() {
        float a = 10f;
        double b = 10d;
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        char c = 65;//A
        char d = '\u2122';
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }

    /**
     * 3.5、运算符
     */
    public static void operator() {
        int a = 6;
        int b = 5;
        int c = 5;
        System.out.println(a & b);//4
        System.out.println(a | b);//7
        System.out.println(a ^ b);//3
        System.out.println(~b);//-6

        System.out.println(a << 3);//48
        System.out.println(b >> 1);//2
        System.out.println(c >>> 1);//2

        System.out.println(Math.sqrt(9));
    }

    /**
     * 3.6、字符串
     */
    public static void stringTest() {
        String aaaa = "aaaa";
        String bbbb = "aaaa";
        String cccc = "aaaabbbb";
        System.out.println(aaaa == "aaaa");//true
        System.out.println(aaaa.equals("aaaa"));//true

        System.out.println(aaaa == bbbb);//true
        System.out.println(aaaa.equals(bbbb));//true

        System.out.println(aaaa == cccc.substring(0, 4));//false
        System.out.println(aaaa.equals(cccc.substring(0, 4)));//true
        //3.6.6、代码点数量
        int codePoint = cccc.codePointCount(0, cccc.length());

        String dddd = null;
        System.out.println(dddd);//null
    }

    /**
     * 3.7、输入输出
     *
     * @throws Exception
     */
    public static void inputOutput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);

//        Console console = System.console();
//        String input2 = console.readLine("Password: ");
//        System.out.println(input2);

        int age = scanner.nextInt();
        System.out.printf("Hello, %s %d\n", input, age);

        //3.7.3、文件输入与输出
        Scanner fileStr = new Scanner(Paths.get("c:\\tmp.txt"));
        System.out.printf("fileStr: %s\n", fileStr.nextLine());

        PrintWriter printWriter = new PrintWriter("c:\\tmp.txt");
        printWriter.write("2019年2月1日15:19:07");
    }

    /**
     * 工作日志：chesheng/20190715-E分期1.2
     * BigDecimal的精度设置、舍入模式
     */
    private static void bigDecimalTest() {
        BigDecimal aa = new BigDecimal(10.99);
        BigDecimal bb = new BigDecimal(3.99);

        BigDecimal result1 = aa.add(bb).setScale(3, RoundingMode.UP);
        System.out.println("add : " + result1);
        BigDecimal result2 = aa.subtract(bb).setScale(3);
        System.out.println("subtract : " + result2);
        BigDecimal result3 = aa.multiply(bb).setScale(3, RoundingMode.UP);
        System.out.println("multiply : " + result3);
        BigDecimal result4 = aa.divide(bb, 4, RoundingMode.CEILING);
        System.out.println("divide : " + result4);


        BigDecimal cc = new BigDecimal(10.5555);
        BigDecimal dd = new BigDecimal(-10.5555);

        BigDecimal result5 = cc.setScale(2, RoundingMode.DOWN);
        System.out.println("UP : " + result5);
        BigDecimal result6 = dd.setScale(2, RoundingMode.DOWN);
        System.out.println("DOWN : " + result6);
    }

    public static void stringTest2() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        Long timestamp11 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            stringBuffer.append(String.valueOf(i));
        }
        Long timestamp12 = System.currentTimeMillis();
        System.out.println(timestamp12 - timestamp11);

        Long timestamp21 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        Long timestamp22 = System.currentTimeMillis();
        System.out.println(timestamp22 - timestamp21);
    }

    /**
     * 比较两个Integer 对象是否相等
     * https://blog.csdn.net/Peter_S/article/details/85091168
     */
    public static void integerTest() {
        Integer aaa = 100;
        Integer bbb = 100;
        Integer ccc = new Integer(100);
        System.out.println(aaa == bbb);//true
        System.out.println(aaa.equals(bbb));//true

        System.out.println(aaa == ccc);//false
        System.out.println(aaa.equals(ccc));//true

        Integer ddd = 200;
        Integer eee = 200;
        System.out.println(ddd == eee);//false
        System.out.println(ddd.equals(eee));//true
    }
}
