package org.practice.book02.chap01;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》
 * 第一章、流与文件
 * @Author
 * @Date
 * @Version 1.0
 */
public class StreamUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String file = "D:\\home\\upload\\report.txt";
            String dest = "D:\\home\\upload\\report2.txt";

            //1.1.1、读写字节
            String srcPath = "D:\\home\\upload\\5f9d5038-a73f-4e84-8050-3ae187585f01.mp4";
            byte[] bytes = readBytes(srcPath);
            String destPath = "D:\\home\\upload\\5f9d5038-a73f-4e84-8050-3ae187585f02.mp4";
            writeBytes(destPath, bytes);

            //1.1.3、组合流过滤器
            String userDir = System.getProperty("user.dir");
            Properties properties = System.getProperties();
            System.out.println(userDir);
            System.out.println(properties.size());
            composedStream(file);

            //1.2.1、文本输出
            writer(dest, "Java");
            reader(dest);

            systemIn();

            //1.6、文件操作
            fileTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.1.1、读写字节
     */
    public static byte[] readBytes(String filePath) {
        try {
            FileInputStream smallStream = new FileInputStream("D:\\home\\upload\\small.txt");
            //FileInputStream smallStream = new FileInputStream(filePath);
            int smallAvailable = smallStream.available();
            System.out.println(smallAvailable);
            for (int i = 0; i < 10; i++) {
                System.out.println(smallStream.read());
                System.out.println(smallStream.available());
            }

            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while ((n = smallStream.read(buffer)) != -1) {
                byteOutput.write(buffer, 0, n);
            }
            byte[] result = byteOutput.toByteArray();
            System.out.println(result.length);

            FileInputStream reportStream = new FileInputStream("D:\\home\\upload\\report.txt");
            FileInputStream videoStream = new FileInputStream(filePath);

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 1.1.1、读写字节
     */
    public static byte[] writeBytes(String path, byte[] bytes) {
        try {
            File destFile = new File(path);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileOutputStream videoStream = new FileOutputStream(path);
            videoStream.write(bytes);
            videoStream.flush();
            videoStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 1.1.3、组合流过滤器
     */
    public static void composedStream(String filePath) {
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            int result = fileStream.read();
            System.out.println(result);

            DataInputStream dataStream = new DataInputStream(fileStream);
            Integer result1 = dataStream.readInt();
            System.out.println(result1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 1.2.1、文本输出
     */
    public static void writer(String filePath, String content) throws Exception {
        File dest = new File(filePath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Writer stringWriter = new StringWriter();
        Writer fileWriter = new FileWriter(filePath, true);
        Writer streamWriter = new OutputStreamWriter(new FileOutputStream(filePath));

        char[] charBuffer = new char[4096];
        stringWriter.write(charBuffer);

        fileWriter.append("2019年8月15日10:25:40");
        fileWriter.flush();

        Writer printWriter = new PrintWriter(dest);
        printWriter.append(content);
        printWriter.flush();
    }

    /**
     * 1.2.2、文本输入：StringReader\FileReader\InputStreamReader
     */
    public static void reader(String filePath) throws Exception {
        byte[] byteBuffer = new byte[4096];

        Reader stringReader = new StringReader(filePath);
        Reader fileReader = new FileReader(filePath);
        Reader streamReader = new InputStreamReader(new FileInputStream(filePath));

        //System.out.println(stringReader.read());
        char[] charBuffer = new char[4096];
        int length = stringReader.read(charBuffer);
        String result = new String(charBuffer, 0, length);
        System.out.println("result1: " + result);

        char[] charBuffer2 = new char[4096];
        int length2 = fileReader.read(charBuffer2);
        String result2 = new String(charBuffer2, 0, length2);
        System.out.println("result2: " + result2);

        char[] charBuffer3 = new char[4096];
        int length3 = streamReader.read(charBuffer3);
        String result3 = new String(charBuffer3, 0, length3);
        System.out.println("result3: " + result3);
    }

    //java中System.in和System.out快速学会使用：https://blog.csdn.net/qq_34173549/article/details/79671792
    //java从控制台获得输入：https://blog.csdn.net/joananjin/article/details/79418110
    public static void systemIn() {
        try {
            InputStream systemIn = System.in;
            OutputStream systemOut = System.out;
            BufferedReader reader = new BufferedReader(new InputStreamReader(systemIn));
            String line = reader.readLine();

            ((PrintStream) systemOut).println(line);
            systemOut.write(line.getBytes());

            Scanner scanner = new Scanner(System.in);
            String line2 = scanner.nextLine();
            System.out.println(line2);

            InputStreamReader reader2 = new InputStreamReader(System.in);
            OutputStreamWriter writer2 = new OutputStreamWriter(System.out);
        } catch (Exception ex) {
        }
    }

    /**
     * 1.6、操作文件
     */
    public static void fileTest() {
        File report = new File("D:\\home\\upload2");
        System.out.println("report.isDirectory() " + report.isDirectory());
        System.out.println("report.isFile() " + report.isFile());
        System.out.println("report.exists() " + report.exists());
        if (!report.exists()) {
            boolean result = report.mkdir();
            System.out.println("report.mkdir() " + result);
        }
    }
}
