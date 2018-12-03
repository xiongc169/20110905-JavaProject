package org.practice.dataStructure.sort;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    /**
     * 入口函数(排序算法)
     *
     * @param args
     */
    public static void main(String[] args) {
        //交换排序-冒泡排序
        Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        bubbleSort(source);

        //交换排序-快速排序
        Integer[] source2 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        quickSort(0, source2.length - 1, source2);
        for (int i = 0; i < source2.length; i++) {
            System.out.print(source2[i] + "  ");
        }
        System.out.println();

        //选择排序-直接选择排序
        Integer[] source3 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        straightSelectSort(source3);
        System.out.println(source3.length);

        //选择排序-堆排序
        Integer[] source4 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        heapSort(source4);
    }

    /**
     * 交换排序-冒泡排序
     *
     * @param source
     */
    public static void bubbleSort(Integer[] source) {
        //排序前
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + "  ");
        }
        System.out.println();

        //排序后
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    Integer tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 交换排序-快速排序
     */
    public static void quickSort(Integer start, Integer end, Integer[] source) {
        if (start >= end) {
            return;
        }
        Integer base = source[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (source[j] > base && i < j) {
                j--;
            }
            source[i] = source[j];

            while (source[i] < base && i < j) {
                i++;
            }
            source[j] = source[i];
        }
        int middle = (i + j) / 2;
        source[middle] = base;
        Arrays.stream(source).forEach(item -> System.out.print(item + "  "));
        System.out.println();
        quickSort(start, middle - 1, source);
        quickSort(middle + 1, end, source);
    }

    /**
     * 选择排序-直接选择排序
     *
     * @param source
     */
    public static void straightSelectSort(Integer[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int tmpIndex = i + 1;
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] < source[tmpIndex]) {
                    tmpIndex = j;
                }
            }
            int original = source[i];
            source[i] = source[tmpIndex];
            source[tmpIndex] = original;
        }
    }

    /**
     * 选择排序-堆排序
     *
     * @param source
     */
    public static void heapSort(Integer[] source) {

    }

    /**
     * 插入排序-直接插入排序
     *
     * @param source
     */
    public static void straightInsertSort(Integer[] source) {
    }

    /**
     * 插入排序-希尔序
     *
     * @param source
     */
    public static void shellSort(Integer[] source) {
    }

    /**
     * 归并排序
     *
     * @param source
     */
    public static void mergeSort(Integer[] source) {
    }
}












