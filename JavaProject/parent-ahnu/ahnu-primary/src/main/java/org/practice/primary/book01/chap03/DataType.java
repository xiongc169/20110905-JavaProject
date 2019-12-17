package org.practice.primary.book01.chap03;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
            intType();
            floatType();
            operator();
            stringTest();
            inputOutput();
            bigDecimalTest();
            stringTest2();
            integerTest();
            unicode();
            stringFormat();
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
        Double bb = 10d;
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        //double、Double的大小比较
        if (b == 10) {//true
            System.out.println("b==10");
        }
        if (bb.equals(10)) {//false
            System.out.println("bb.equals(10)");
        }
        if (bb.equals(10d)) {//true
            System.out.println("bb.equals(10d)");
        }
        if (bb.doubleValue() == 10) {//true
            System.out.println("bb.doubleValue() == 10");
        }

        char c = 65;//A
        char d = '\u2122';
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }

    /**
     * 基本数据类型
     */
    public static void primaryDataType() {
        byte b = 0;
        short s = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        boolean boolean1 = true;
        char c = 'a';
        System.out.println(b);
    }

    /**
     * 包装类
     */
    public static void wrapperClass() {
        Byte b = 0;//new Byte("0");
        Short s = 1;
        Integer i = 2;
        Long l = 3l;
        Float f = 4f;
        Double d = 5d;
        Boolean boolean1 = true;
        Character c = 'a';
        System.out.println(b);
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
     * BigDecimal的精度设置、舍入模式(RoundingMode)
     * PS：RoundingMode.UP、RoundingMode.DOWN、RoundingMode.CEILING、RoundingMode.FLOOR、RoundingMode.HALF_UP、RoundingMode.HALF_DOWN
     * RoundingMode.HALF_EVEN、RoundingMode.UNNECESSARY
     * https://blog.csdn.net/yeu12331/article/details/81986053
     * ROUND_UP() 绝对值向上进位、ROUND_DOWN 绝对值向下舍位；ROUND_CEILING() 向上进位、ROUND_FLOOR() 向下舍位；ROUND_HALF_UP() 四舍五入、ROUND_HALF_DOWN() 五舍六入；
     * https://blog.csdn.net/xingbaozhen1210/article/details/80777644
     * <p>
     * Non-terminating decimal expansion; no exact representable decimal result
     * https://blog.csdn.net/lopper/article/details/5314686
     */
    public static void bigDecimalTest() {
        //解释BigDecimal精度的坑
        //PS：如果需要精确的答案，请避免使用float和double；
        //https://blog.csdn.net/gege87417376/article/details/79550749
        System.out.println(new BigDecimal(0.1));//输出 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal(0.5));//输出 0.5
        System.out.println(new BigDecimal("0.1"));//输出 0.1
        System.out.println(new BigDecimal("0.5"));//输出 0.5
        System.out.println();

        BigDecimal aa = new BigDecimal(10.99);
        BigDecimal bb = new BigDecimal(3.99);
        System.out.println("aa: " + aa);//输出 10.9900000000000002131628207280300557613372802734375
        System.out.println("bb: " + bb);//输出 3.9900000000000002131628207280300557613372802734375
        System.out.println();

        System.out.println("add: " + aa.add(bb));//输出 14.9800000000000004263256414560601115226745605468750
        System.out.println("sub: " + aa.subtract(bb));//输出 7.0000000000000000000000000000000000000000000000000
        System.out.println("mul: " + aa.multiply(bb));//输出 43.85010000000000319317905450589028074322059922637374171556536028848682917669066227972507476806640625
        System.out.println("div: " + aa.divide(bb, 5));//不设置进度会抛异常。输出 2.7543859649122806080276037778525065412346317183785
        System.out.println();

        System.out.println("add: " + aa.add(bb).setScale(5, RoundingMode.UP));//14.98001
        System.out.println("sub: " + aa.subtract(bb).setScale(5));//7.00000
        System.out.println("mul: " + aa.multiply(bb).setScale(5, RoundingMode.UP));//43.85011
        System.out.println("div: " + aa.divide(bb, 5, RoundingMode.CEILING));//2.75439
        System.out.println();

        BigDecimal cc = new BigDecimal("10.505054");
        BigDecimal dd = new BigDecimal("10.505055");
        BigDecimal ee = new BigDecimal("10.505050");
        System.out.println(cc.setScale(5, RoundingMode.UP));//10.50506
        System.out.println(dd.setScale(5, RoundingMode.UP));//10.50506
        System.out.println(ee.setScale(5, RoundingMode.UP));//10.50505
        System.out.println(cc.setScale(5, RoundingMode.DOWN));//10.50505
        System.out.println(dd.setScale(5, RoundingMode.DOWN));//10.50505
        System.out.println(ee.setScale(5, RoundingMode.DOWN));//10.50505
        System.out.println();

        BigDecimal ff = new BigDecimal("10.555555");
        BigDecimal gg = new BigDecimal("-10.555555");
        System.out.println(ff.setScale(5, RoundingMode.CEILING));//10.55556
        System.out.println(gg.setScale(5, RoundingMode.CEILING));//-10.55555
        System.out.println(ff.setScale(5, RoundingMode.FLOOR));//10.55555
        System.out.println(gg.setScale(5, RoundingMode.FLOOR));//-10.55556
        System.out.println();

        BigDecimal hh = new BigDecimal("10.555554");
        BigDecimal ii = new BigDecimal("10.555555");
        BigDecimal jj = new BigDecimal("10.555556");
        System.out.println(hh.setScale(5, RoundingMode.HALF_UP));//10.55555
        System.out.println(ii.setScale(5, RoundingMode.HALF_UP));//10.55556
        System.out.println(jj.setScale(5, RoundingMode.HALF_UP));//10.55556
        System.out.println(hh.setScale(5, RoundingMode.HALF_DOWN));//10.55555
        System.out.println(ii.setScale(5, RoundingMode.HALF_DOWN));//10.55555
        System.out.println(jj.setScale(5, RoundingMode.HALF_DOWN));//10.55556
        System.out.println();
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

    /**
     * Unicode码
     * https://unicode-table.com/cn
     */
    public static void unicode() {
        System.out.println("\u2122");//™
        System.out.println("\u2FD0");//⿐
    }

    /**
     * String.format()的详细用法
     * https://blog.csdn.net/anita9999/article/details/82346552
     */
    public static void stringFormat() {
        String msg = String.format("boolean类型 %b %b", true, false);
        System.out.println(msg);
        String msg2 = String.format("boolean类型 %s %s", true, false);
        System.out.println(msg2);
        String msg3 = String.format("boolean类型 %s %s", 11, 22);
        System.out.println(msg3);
    }
}
