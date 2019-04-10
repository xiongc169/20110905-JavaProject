package org.practice.book01.chap03;

import java.io.Console;
import java.io.PrintWriter;
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
public class DataType implements Cloneable {

    public String deepClone = "DeepClone";

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            intType();
            floatType();
            operator();
            stringTest();
            inputOutput();
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

    public DataType clone() {
        try {
            Object object = super.clone();
            return (DataType) object;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
