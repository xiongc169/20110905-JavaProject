package org.practice.primary.book01.chap03;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author yoong
 * <p>
 * @desc 《Java核心技术·卷1》第三章、Java的基本程序设计结构
 * <p>
 * @date 2019/2/1 11:50
 */
public class AppDataType {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //数据类型
            intType0303();
            floatType0303();
            operator0305();
            stringType0306();
            inputOutput0307();
            array0310();
            //练习
            primaryDataType();
            wrapperClass();
            integerTest();
            integerTest2();
            operatorTest();
            stringTest();
            bigDecimalTest();
            bigDecimalTest2();
            unicode();
            stringFormat();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 3.3、数据类型(整型)
     */
    public static void intType0303() {
        byte byte01 = 0;
        byte byte02 = 127;//赋值2^7=128，编译不通过
        System.out.println("byte01: " + byte01);
        System.out.println("byte02: " + byte02);

        short short01 = 0;
        short short02 = 32767;//赋值2^15=32768，编译不通过
        System.out.println("short01: " + short01);
        System.out.println("short02: " + short02);

        int int01 = 0x10;//16进制
        int int02 = 010;//8进制
        int int03 = 0b10;//2进制
        int int04 = 1000_000_000;//可以使用下划线
        int int05 = 2147483647;//赋值2^31=2147483648，编译不通过
        System.out.println("int01: " + int01);
        System.out.println("int02: " + int02);
        System.out.println("int03: " + int03);
        System.out.println("int04: " + int04);
        System.out.println("int05: " + int05);

        long long01 = 0;
        long long02 = 9223372036854775807l;//赋值2^63=9223372036854775808l，编译不通过
        System.out.println("long01: " + long01);
        System.out.println("long02: " + long02);

        int x = 'A';
        System.out.println("x: " + x);
    }

    /**
     * 3.3、数据类型(浮点型)
     */
    public static void floatType0303() {
        float float01 = 123.111222333444555666777888999f;
        float float02 = 10.0f;
        double double01 = 123.111222333444555666777888999d;
        double double02 = 10.0d;
        Double Double01 = 123.111222333444555666777888999d;
        Double Double02 = 10.0d;
        System.out.println("float01: " + float01);
        System.out.println("double01: " + double01);
        System.out.println("Double01: " + Double01);

        System.out.println("Float.NEGATIVE_INFINITY: " + Float.NEGATIVE_INFINITY);
        System.out.println("Float.POSITIVE_INFINITY: " + Float.POSITIVE_INFINITY);
        System.out.println("Double.NEGATIVE_INFINITY: " + Double.NEGATIVE_INFINITY);
        System.out.println("Double.POSITIVE_INFINITY: " + Double.POSITIVE_INFINITY);

        //double、Double的大小比较
        System.out.println("double02 == 10: " + (double02 == 10));//true
        System.out.println("Double02.equals(10): " + (Double02.equals(10)));//false
        System.out.println("Double02.equals(10d): " + (Double02.equals(10d)));//true
        System.out.println("Double02.doubleValue() == 10: " + (Double02.doubleValue() == 10));//true

        char c = 65;//A
        char d = '\u2122';//™
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }

    /**
     * 3.5、运算符
     */
    public static void operator0305() {
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
    public static void stringType0306() {
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
     */
    public static void inputOutput0307() throws Exception {
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
     * 3.10、数组
     */
    public static void array0310() throws Exception {
        int[] intArray = new int[10];
        int[] intArray2 = {1, 2, 3, 4, 5, 6};
        int[] intArray3 = new int[]{1, 2, 3, 4, 5, 6};
        String[] stringArray = new String[]{"111", "222"};
        String[] stringArray2 = {"111", "222"};
    }

    /**
     * 八种基本类型与引用类型及它们的内存原理
     * PS：基本数据类型、包装类、引用类型；
     * 自动拆箱：把包装类型自动拆为基本类型，自动装箱：把基本类型自动包装为包装类型；
     * Integer.valueOf(i)函数，当i值在-128~127之间时，不会创建新的对象，但当i值超出这个范围就会新建一个对像，可以用==这个来判断。
     * 基本数据类型就是在栈中保存，而引用类型变量在栈中，指向的对象在堆中，所以当用==比较两个变量时，一定要看清楚它是什么数据类型。
     * https://blog.csdn.net/qq_31071255/article/details/82192075
     * PS：基本数据类型在被创建时，在栈上给其划分一块内存，将数值直接存储在栈上。
     * 引用数据类型在被创建时，首先要在栈上给其引用（句柄）分配一块内存，而对象的具体信息都存储在堆内存上，然后由栈上面的引用指向堆中对象的地址。
     * https://blog.csdn.net/weixin_44509889/article/details/93347191
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

    public static void wrapperClass() {
        Byte b = 0;//new Byte("0");
        Short s = 1;
        Integer i = 2;
        Integer wrapperInt = 2; //Integer.valueOf(2)
        int primaryInt = wrapperInt; //wrapperInt.intValue()

        Long l = 3l;
        Float f = 4f;
        Double d = 5d;
        Boolean boolean1 = true;
        Character c = 'a';
        System.out.println(b);
    }

    /**
     * 比较两个Integer 对象是否相等
     * https://blog.csdn.net/Peter_S/article/details/85091168
     */
    public static void integerTest() {
        Integer aaa = 100; //自动装箱，Integer.valueOf(100)
        Integer bbb = 100; //自动装箱
        Integer ccc = new Integer(100);
        System.out.println(aaa == bbb);//true
        System.out.println(aaa.equals(bbb));//true
        System.out.println(aaa == ccc);//false
        System.out.println(aaa.equals(ccc));//true

        Integer ddd = 200;
        Integer eee = 200;
        System.out.println(ddd == eee);//false
        System.out.println(ddd.equals(eee));//true

        Integer fff = 300;
        int ggg = 300;
        System.out.println(fff == ggg);//true, 会自动拆箱
        System.out.println(fff.equals(ggg));//true


        Integer i1 = 100, i2 = 100, i3 = 150, i4 = 150;
        Integer i5 = new Integer(100);
        Integer i6 = new Integer(100);
        Integer i7 = new Integer("100");
        Integer i8 = Integer.parseInt("100");
        Integer i9 = Integer.parseInt("150");
        System.out.println(i1 == i2);//true
        System.out.println(i3 == i4);//false
        System.out.println(i1 == i5);//false
        System.out.println(i6 == i5);//false
        System.out.println(i1 == i7);//false
        System.out.println(i8 == i7);//false
        System.out.println(i1 == i8);//true ！！！！！
        System.out.println(i3 == i9);//false ！！！！！
        System.out.println(i5.equals(i6));//true
        System.out.println(i3.equals(i4));//true
    }

    /**
     * Integer.parseInt()与Integer.valueOf()的区别
     * PS：Integer.parseInt、Integer.valueOf都可以将String转成int，不同的是parseInt返回的是int，valueOf返回的是Integer；
     * https://blog.csdn.net/zhang_zhenwei/article/details/90691948
     */
    public static void integerTest2() {
        Integer i = Integer.parseInt("100");
        Integer j = Integer.parseInt("100");
        System.out.println(i == j); // true

        Integer m = Integer.valueOf("100");
        Integer n = Integer.valueOf("100");
        System.out.println(m == n); // true

        Integer p = Integer.valueOf("200");
        Integer q = Integer.valueOf("200");
        System.out.println(p == q); // false
        System.out.println(p.equals(q)); // true

        Integer a = Integer.parseInt("200");
        Integer b = Integer.parseInt("200");
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true
    }

    /**
     * java中的运算 ^, << , >>,&
     * PS：& | ~ ^ << >> >>>
     * https://blog.csdn.net/sx729034738/article/details/69569055
     */
    public static void operatorTest() {
        // 左移n位就相当于乘以2的n次方
        int a = 3 << 10;
        int b = 48 >> 2;
        System.out.println(a);
        System.out.println(b);
        int c = 5 & 2;
        int d = 5 | 2;
        int e = ~5;
        int f = 5 ^ 2;
        int g = 64 >>> 2;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }

    /**
     * 字符串类型
     * String的比较，“==”比较，equals()比较
     * PS：“==”判断的是地址值，equals()方法判断的是内容
     * 注意：需要用括号括起来
     * https://blog.csdn.net/jakezhang1990/article/details/80827015
     * https://www.cnblogs.com/gc65/p/java.html
     * https://blog.csdn.net/qq_37476266/article/details/89344302
     */
    public static void stringTest() {
        String s01 = "OK";
        String s02 = new String("OK");
        String s03 = "OK";
        String s04 = s01;
        System.out.println("s01==s02 " + (s01 == s02));//false
        System.out.println("s01==s03 " + (s01 == s03));//true
        System.out.println("s01==s04 " + (s01 == s04));//true

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
     * 工作日志：chesheng/20190715-E分期1.2
     * BigDecimal的精度设置、舍入模式(RoundingMode)
     * PS：RoundingMode.UP、RoundingMode.DOWN、RoundingMode.CEILING、RoundingMode.FLOOR、RoundingMode.HALF_UP、RoundingMode.HALF_DOWN、RoundingMode.HALF_EVEN、RoundingMode.UNNECESSARY
     * https://blog.csdn.net/yeu12331/article/details/81986053
     * PS：ROUND_UP() 绝对值向上进位、ROUND_DOWN 绝对值向下舍位；ROUND_CEILING() 向上进位、ROUND_FLOOR() 向下舍位；ROUND_HALF_UP() 四舍五入、ROUND_HALF_DOWN() 五舍六入；
     * https://blog.csdn.net/xingbaozhen1210/article/details/80777644
     * <p>
     * Non-terminating decimal expansion; no exact representable decimal result
     * https://blog.csdn.net/lopper/article/details/5314686
     */
    public static void bigDecimalTest() {
        BigDecimal cc = new BigDecimal("10.505054");
        BigDecimal dd = new BigDecimal("10.505055");
        BigDecimal ee = new BigDecimal("10.505050");
        System.out.println(cc.setScale(5, RoundingMode.UP));//10.50506，在舍弃部分非零情况下，向前进位加1。
        System.out.println(dd.setScale(5, RoundingMode.UP));//10.50506
        System.out.println(ee.setScale(5, RoundingMode.UP));//10.50505
        System.out.println(cc.setScale(5, RoundingMode.DOWN));//10.50505，截断舍入模式，始终不进位。
        System.out.println(dd.setScale(5, RoundingMode.DOWN));//10.50505
        System.out.println(ee.setScale(5, RoundingMode.DOWN));//10.50505
        System.out.println();

        BigDecimal ff = new BigDecimal("10.555555");
        BigDecimal gg = new BigDecimal("-10.555555");
        System.out.println(ff.setScale(5, RoundingMode.CEILING));//10.55556，舍入模式朝向正无穷大，如果BigDecimal是正的，则表现为ROUND_UP；如果为负，则表现为ROUND_DOWN。
        System.out.println(gg.setScale(5, RoundingMode.CEILING));//-10.55555
        System.out.println(ff.setScale(5, RoundingMode.FLOOR));//10.55555，舍入模式朝向负无穷大，如果BigDecimal是正的，则表现为ROUND_DOWN；如果为负，则表现为ROUND_UP。
        System.out.println(gg.setScale(5, RoundingMode.FLOOR));//-10.55556
        System.out.println();

        BigDecimal hh = new BigDecimal("10.555554");
        BigDecimal ii = new BigDecimal("10.555555");
        BigDecimal jj = new BigDecimal("10.555556");
        System.out.println(hh.setScale(5, RoundingMode.HALF_UP));//10.55555，如果舍弃部分大于等于0.5，则表现为ROUND_UP，否则，表现为ROUND_DOWN。四舍五入。
        System.out.println(ii.setScale(5, RoundingMode.HALF_UP));//10.55556
        System.out.println(jj.setScale(5, RoundingMode.HALF_UP));//10.55556
        System.out.println(hh.setScale(5, RoundingMode.HALF_DOWN));//10.55555，如果舍弃部分大于0.5，则表现为ROUND_UP；否则，表现为ROUND_DOWN。五舍六入。
        System.out.println(ii.setScale(5, RoundingMode.HALF_DOWN));//10.55555
        System.out.println(jj.setScale(5, RoundingMode.HALF_DOWN));//10.55556
        System.out.println();
    }

    /**
     * 解释BigDecimal精度的坑
     * PS：如果需要精确的答案，请避免使用float和double；
     * https://blog.csdn.net/gege87417376/article/details/79550749
     */
    public static void bigDecimalTest2() {
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
