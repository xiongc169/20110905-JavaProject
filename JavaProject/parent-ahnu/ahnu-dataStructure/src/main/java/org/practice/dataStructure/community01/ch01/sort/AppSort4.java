package org.practice.dataStructure.community01.ch01.sort;

import java.util.Arrays;

/**
 * @Desc AppSort4
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020-11-16 17:00:00
 * <p>
 * @Version 1.0
 */
public class AppSort4 {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        try {
            Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
            Integer[] source2 = Arrays.copyOf(source, source.length);
            Integer[] source3 = Arrays.copyOf(source, source.length);

            //交换排序-冒泡排序
            bubbleSort(source);
            bubbleSort2(source);

            //交换排序-快速排序
            quickSort(source2, 0, source.length - 1);
            for (int i = 0; i < source2.length; i++) {
                System.out.print(source2[i] + "  ");
            }
            System.out.println();

            //选择排序-直接选择排序
            selectSort(source3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    public static void quickSort(Integer[] source, Integer start, Integer end) {
        if (start >= end) {
            return;
        }

        int leftIndex = start;
        int rightIndex = end;
        int flag = source[leftIndex];
        while (leftIndex < rightIndex) {
            while (rightIndex > leftIndex && source[rightIndex] > flag) {
                rightIndex--;
            }
            source[leftIndex] = source[rightIndex];
            while (leftIndex < rightIndex && source[leftIndex] < flag) {
                leftIndex++;
            }
            source[rightIndex] = source[leftIndex];
        }
        int mid = (leftIndex + rightIndex) / 2;
        source[mid] = flag;
        quickSort(source, start, mid - 1);
        quickSort(source, mid + 1, end);
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



































