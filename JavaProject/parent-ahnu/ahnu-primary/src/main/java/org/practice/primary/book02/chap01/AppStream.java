package org.practice.primary.book02.chap01;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》第一章、流与文件
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppStream {

    private static String filePath = "D:\\Temp\\IO";

    private static String txtFileName = "D:\\Temp\\IO\\abc.txt";
    private static String txtFileName01 = "D:\\Temp\\IO\\abc01.txt";

    private static String zipFileName = "D:\\Temp\\IO\\zip.zip";

    private static String mp4FileName = "D:\\Temp\\IO\\video.mp4";
    private static String mp4FileName01 = "D:\\Temp\\IO\\video01.mp4";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //1.1.1、读写字节
            byte[] bytes = inputStream0101(mp4FileName);
            outputStream0101(mp4FileName01, bytes);

            //1.1.3、组合流过滤器
            String userDir = System.getProperty("user.dir");
            Properties properties = System.getProperties();
            System.out.println("userDir  " + userDir);
            System.out.println("properties.size  " + properties.size());
            composedStream0101(txtFileName);

            //1.2.1、文本输出
            reader0102(txtFileName);
            writer0102(txtFileName01, "Java");

            //1.6、文件操作
            fileTest0106();

            systemIn();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.1.1、读写字节(字节流)
     * PS：文件读取为字节数组
     */
    public static byte[] inputStream0101(String filePath) {
        try {
            //TODO: 输入流实现类
            FileInputStream fileInputStream = new FileInputStream(filePath);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            PushbackInputStream pushbackInputStream = new PushbackInputStream(fileInputStream);
            byte[] buf = new byte[4096];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);

            //获取文件大小，单位：字节Byte / 1024 = KB / 1024 = MB
            int available = fileInputStream.available();
            System.out.println("available  " + available);
            //for (int i = 0; i < 10; i++) {
            //    System.out.println(fileInputStream.read());
            //    System.out.println(fileInputStream.available());
            //}

            //文件读取为字节数组
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //1048576 Byte = 1024 KB = 1MB
            byte[] buffer = new byte[1048576];
            int n = 0;
            while ((n = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
            byte[] result = byteArrayOutputStream.toByteArray();
            System.out.println("result.length  " + result.length);

            //关闭输入流
            byteArrayOutputStream.close();
            fileInputStream.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 1.1.1、读写字节(字节流)
     * PS：字节数组输出到文件
     */
    public static void outputStream0101(String destPath, byte[] bytes) {
        try {
            File destFile = new File(destPath);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            //TODO: 输出流实现类
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            //字节数组输出到文件
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            //关闭输出流
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.1.3、组合流过滤器
     */
    public static void composedStream0101(String filePath) {
        try {
            //文本内容为：abcdefghijklmnopqrstuvwxyz
            FileInputStream fileInputStream = new FileInputStream(filePath);
            //int result = fileInputStream.read();//a=97
            //System.out.println("result  " + result);

            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            //Integer result1 = dataInputStream.readInt();//1633837924
            //System.out.println("result1  " + result1);
            //char char1 = dataInputStream.readChar();//慢
            //System.out.println("char1  " + char1);
            String line = dataInputStream.readLine();//abcdefghijklmnopqrstuvwxyz
            System.out.println("line  " + line);

            dataInputStream.close();
            fileInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.2.2、文本输入(字符流)
     * PS：StringReader\FileReader\InputStreamReader
     */
    public static void reader0102(String filePath) throws Exception {
        //TODO: Reader实现类
        StringReader stringReader = new StringReader(filePath);
        FileReader fileReader = new FileReader(filePath);
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        char[] charBuff = new char[4096];
        CharArrayReader charArrayReader = new CharArrayReader(charBuff);

        //System.out.println(stringReader.read());
        char[] charBuffer = new char[4096];
        int length = stringReader.read(charBuffer);
        String result = new String(charBuffer, 0, length);
        System.out.println("result1: " + result);//filePath的值

        char[] charBuffer2 = new char[4096];
        int length2 = fileReader.read(charBuffer2);
        String result2 = new String(charBuffer2, 0, length2);
        System.out.println("result2: " + result2);//filePath的文本的内容

        char[] charBuffer3 = new char[4096];
        int length3 = streamReader.read(charBuffer3);
        String result3 = new String(charBuffer3, 0, length3);
        System.out.println("result3: " + result3);//filePath的文本的内容
    }

    /**
     * 1.2.1、文本输出(字符流)
     */
    public static void writer0102(String filePath, String content) throws Exception {
        File dest = new File(filePath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        //TODO: Writer实现类
        StringWriter stringWriter = new StringWriter();
        FileWriter fileWriter = new FileWriter(filePath, true);
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
        PrintWriter printWriter = new PrintWriter(dest);
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        char[] charBuffer = new char[4096];
        stringWriter.write(charBuffer);

        fileWriter.append("2019年8月15日10:25:40");
        fileWriter.flush();

        streamWriter.write("2019年8月16日10:25:40");
        streamWriter.flush();

        printWriter.append(content);
        printWriter.flush();
    }

    /**
     * 1.6、操作文件
     * PS：File、Path、Paths、Files
     */
    public static void fileTest0106() throws Exception {
        File file = new File(txtFileName);
        System.out.println("report.isDirectory() " + file.isDirectory());
        System.out.println("report.isFile() " + file.isFile());
        System.out.println("report.exists() " + file.exists());
        if (file.isDirectory()) {
            boolean result = file.mkdir();
            System.out.println("file.mkdir() " + result);
        } else {
            boolean result = file.createNewFile();
            System.out.println("file.createNewFile() " + result);
        }

        Path path = Paths.get("D:", "Temp", "IO", "abc02.txt");
        boolean isDelete = Files.deleteIfExists(path);
        System.out.println("isDelete  " + isDelete);
        FileSystem fileSystem = path.getFileSystem();
        System.out.println(fileSystem.getSeparator());
    }

    /**
     * java中System.in和System.out快速学会使用
     * https://blog.csdn.net/qq_34173549/article/details/79671792
     * java从控制台获得输入
     * https://blog.csdn.net/joananjin/article/details/79418110
     */
    public static void systemIn() throws Exception {
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;
        //封装System.in，从控制台读取字符串
        BufferedReader reader = new BufferedReader(new InputStreamReader(systemIn));
        String line = reader.readLine();
        //调用System.out
        systemOut.println("line  " + line);
        systemOut.write(line.getBytes());
        //从控制台读取字符串
        Scanner scanner = new Scanner(System.in);
        String line2 = scanner.nextLine();
        System.out.println(line2);
    }
}
