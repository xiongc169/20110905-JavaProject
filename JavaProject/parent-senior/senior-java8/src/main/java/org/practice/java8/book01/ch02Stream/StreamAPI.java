package org.practice.java8.book01.ch02Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {

	}

	public static void convert() {

		double[] doubleArray = new double[] { 1, 2, 3, 4, 5 };

		Stream doubleStream = (Stream) Arrays.stream(doubleArray);
		Stream doubleStream2 = Stream.of(doubleArray);
	}
}
