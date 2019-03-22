package org.practice.primary.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作
 * 
 * @author Administrator
 *
 */
public class FileUtility {
	public static void main(String[] args) {

		File abcTxt = new File("C:\\abc.txt");

		if (abcTxt.exists()) {
			System.out.println("abcTxt exists");
		} else {
			try {
				boolean result = abcTxt.createNewFile();
			} catch (IOException e) {
				String msg = e.getMessage();
			}
		}
		if (abcTxt.isFile()) {
			System.out.println("abcTxt isFile");
		} else {
			abcTxt.mkdir();
		}
	}
}
