package org.practice.primary.community.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Administrator
 */
public class StreamUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            zipStream();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void inputStream() throws IOException {
        InputStream inStream = new FileInputStream("C:\\abc.txt");
        inStream.read();

        InputStream keyboardIn = System.in;
        int in = keyboardIn.read();
    }

    public static void outputStream() {
        try {
            OutputStream outputStream = new FileOutputStream("C:\\aaa.txt");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void reader() throws IOException {
        FileReader fileReader = new FileReader("C:\\abc.txt");
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void writer() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\abc.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println("abcdefg");
        printWriter.close();
    }

    public static void zipStream() {
        try {
            InputStream inputStream = new FileInputStream("C:\\test\\test.zip");
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            ZipEntry entry = zipInputStream.getNextEntry();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
