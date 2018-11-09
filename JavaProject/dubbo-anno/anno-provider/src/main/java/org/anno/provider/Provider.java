package org.anno.provider;

import java.io.IOException;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Provider {
	public static void main(String[] args) {

		try {

			FileSystemXmlApplicationContext fs = new FileSystemXmlApplicationContext(new String[] { "classpath:provider.xml" });
			fs.start();
			System.out.println("启动成功");
			int input = System.in.read();
			System.out.println(input);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
