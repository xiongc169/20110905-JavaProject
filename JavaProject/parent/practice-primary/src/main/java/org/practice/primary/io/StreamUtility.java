package org.practice.primary.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 
 * @author Administrator
 *         http://www.cnblogs.com/shitouer/archive/2012/12/19/2823641.html
 *
 */
public class StreamUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void inputStream() throws IOException {
		InputStream inStream = new FileInputStream("C:\\abc.txt");
		inStream.read();
	}

	public static void outputStream() {

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

}
