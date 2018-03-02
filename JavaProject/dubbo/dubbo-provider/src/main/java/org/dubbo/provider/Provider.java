package org.dubbo.provider;

import java.util.Scanner;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Provider {
	public static void main(String[] args) {

		try {

			FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(
					new String[] { "classpath:provider.xml" });
			fsContext.start();

			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			System.out.println(input);

			System.in.read();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
