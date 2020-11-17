package org.practice.dataStructure.community01.ch01.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc AppSort
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppSort {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        try {
            Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
            Integer[] source2 = Arrays.copyOf(source, source.length);
            Integer[] source3 = Arrays.copyOf(source, source.length);
            Integer[] source4 = Arrays.copyOf(source, source.length);

            //Java原生排序——Arrays.sort()、Collections.sort()
            nativeSort();
            //移动集合
            move(source2);
            System.out.println("移动集合后：" + Arrays.toString(source2));
            //for循环执行顺序流程
            forTest();

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

            //TODO：选择排序-堆排序
            //heapSort(source4);

            //TODO：插入排序-直接插入排序
            //straightInsertSort(source4);

            //TODO：插入排序-希尔排序
            //shellSort(source4);

            //TODO：归并排序
            //mergeSort(source4);

            //TODO：基数排序
            //radixSort(source4);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Java原生排序
     */
    public static void nativeSort() {
        Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source2 = Arrays.copyOf(source, source.length);
        Integer[] source3 = Arrays.copyOf(source, source.length);

        Arrays.sort(source);
        Collections.sort(Arrays.asList(source2));
        Arrays.asList(source).sort(null);

        //默认升序，Comparator.reverseOrder()则降序
        List source33 = Arrays.asList(source3).stream().sorted().collect(Collectors.toList());
        System.out.println(source33.size());
    }

    /**
     * 移动集合元素
     */
    public static void move(Integer[] source) {
        for (int i = 1; i < source.length; i++) {
            source[i - 1] = source[i];
        }
    }

    /**
     * for循环执行顺序流程
     * https://blog.csdn.net/bjbz_cxy/article/details/80225912
     * https://blog.csdn.net/qq_37480297/article/details/90548018
     */
    public static void forTest() {
        int k = 5;
        for (; k > 0; k--) {
            System.out.println(k);
        }
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

    /**
     * 基数排序
     */
    @Deprecated
    public static void radixSort(Integer[] source) {
    }
}












