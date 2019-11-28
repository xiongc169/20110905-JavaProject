package org.practice.dataStructure.sort;

import javafx.scene.paint.Stop;

import java.util.Arrays;

/**
 * App4Sort
 */
public class App4Sort {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source2 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source3 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source4 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};

        //交换排序-冒泡排序
        System.out.println("冒泡排序前：" + Arrays.toString(source));
        bubbleSort(source);
        System.out.println("冒泡排序后：" + Arrays.toString(source));

        //交换排序-快速排序
        System.out.println("快速排序前：" + Arrays.toString(source2));
        quickSort(0, source2.length - 1, source2);
        System.out.println("快速排序后：" + Arrays.toString(source2));

        //选择排序-直接选择排序
        System.out.println("选择排序前：" + Arrays.toString(source3));
        straightSelectSort(source3);
        System.out.println("选择排序后：" + Arrays.toString(source3));

        //TODO：选择排序-堆排序、插入排序-直接插入排序、插入排序-希尔排序、合并排序
        //heapSort(source4);
        //straightInsertSort(source4);
        //shellSort(source4);
        //mergeSort(source4);
    }

    /**
     * 交换排序-冒泡排序
     */
    public static void bubbleSort(Integer[] source) {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    Integer tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                }
            }
        }
        Long span = System.currentTimeMillis() - start;
        //System.out.println("冒泡耗时：" + span);
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
        //输出一行
        //Arrays.stream(source).forEach(item -> System.out.print(item + "  "));
        //System.out.println();
        //输出一行
        // System.out.println(Arrays.toString(source));
        quickSort(start, middle - 1, source);
        quickSort(middle + 1, end, source);
    }

    /**
     * 选择排序-直接选择排序
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
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     */
    @Deprecated
    public static void heapSort(Integer[] source) {
    }

    @Deprecated
    private static void adjustHeap(Integer[] source) {
    }

    /**
     * 插入排序-直接插入排序
     */
    @Deprecated
    public static void straightInsertSort(Integer[] source) {
    }

    /**
     * 插入排序-希尔序
     */
    @Deprecated
    public static void shellSort(Integer[] source) {
    }

    /**
     * 归并排序
     */
    @Deprecated
    public static void mergeSort(Integer[] source) {
    }
}












