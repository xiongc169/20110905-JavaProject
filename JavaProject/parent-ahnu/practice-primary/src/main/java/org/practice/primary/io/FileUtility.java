package org.practice.primary.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作
 *
 * @author Administrator
 */
public class FileUtility {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            String filePath = "C:\\abc.txt";
            fileTest(filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void fileTest(String filePath) {
        File abcTxt = new File(filePath);
        if (abcTxt.exists()) {
            System.out.println("exists");
        } else {
            try {
                boolean result = abcTxt.createNewFile();
            } catch (IOException e) {
                String msg = e.getMessage();
            }
        }
        if (abcTxt.isFile()) {
            System.out.println("isFile");
        } else {
            abcTxt.mkdir();
        }
    }
}
