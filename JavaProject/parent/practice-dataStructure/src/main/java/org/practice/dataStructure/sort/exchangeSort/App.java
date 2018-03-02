package org.practice.dataStructure.sort.exchangeSort;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		double[] source = { 11, 33, 44, 5, 6, 2 };
		bubbleSort(source);
	}

	public static void bubbleSort(double[] source) {

		int size = source.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (source[j] < source[j + 1]) {
					double tmp = source[j];
					source[j] = source[j + 1];
					source[j] = tmp;
				}
			}
		}
		int a = 0;
	}
}
