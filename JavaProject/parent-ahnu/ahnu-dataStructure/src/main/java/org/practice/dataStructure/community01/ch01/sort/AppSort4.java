package org.practice.dataStructure.community01.ch01.sort;

import java.util.Arrays;

/**
 * @Desc AppSort4
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppSort4 {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source2 = Arrays.copyOf(source, source.length);
        Integer[] source3 = Arrays.copyOf(source, source.length);

        bubbleSort(source);
        bubbleSort2(source);
        selectSort(source);
    }

    public static void bubbleSort(Integer[] source) {
        for (int i = 1; i < source.length; i++) {
            for (int j = 0; j < source.length - i; j++) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j + 1];
                    source[j + 1] = source[j];
                    source[j] = tmp;
                }
            }
        }
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + "  ");
        }
        System.out.println();
    }

    public static void bubbleSort2(Integer[] source) {
        for (int i = 1; i < source.length; i++) {
            for (int j = source.length - 1; j >= i; j--) {
                if (source[j] > source[j - 1]) {
                    int tmp = source[j - 1];
                    source[j - 1] = source[j];
                    source[j] = tmp;
                }
            }
        }
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + "  ");
        }
        System.out.println();
    }


    public static void selectSort(Integer[] source) {
        for (int i = 0; i < source.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] > source[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = source[i];
                source[i] = source[minIndex];
                source[minIndex] = tmp;
            }
        }
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + "  ");
        }
        System.out.println();
    }
}



































