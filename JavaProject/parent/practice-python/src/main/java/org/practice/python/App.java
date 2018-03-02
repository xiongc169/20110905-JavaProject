package org.practice.python;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		// 执行python脚本
		// PythonInterpreter interpreter = new PythonInterpreter();
		// interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun');
		// ");

		try {
			// 执行python py文件
			// PythonInterpreter interpreter = new PythonInterpreter();
			// InputStream filepy = new FileInputStream("D:\\hello.py");
			// interpreter.execfile(filepy);
			// filepy.close();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		}

		System.out.println("Hello World Ending!");
	}
}
