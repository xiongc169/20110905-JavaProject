package org.practice.primary.utility;

public class RegexUtils {

	public static void main(String[] args) {

		String pattern = "^\\d{2}$";

		boolean match = pattern.matches("123");
		boolean match2 = pattern.matches("12");

		System.out.println(match);
		System.out.println(match2);

	}
}
