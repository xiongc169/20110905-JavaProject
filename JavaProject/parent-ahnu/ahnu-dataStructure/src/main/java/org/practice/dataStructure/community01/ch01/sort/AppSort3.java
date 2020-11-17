package org.practice.dataStructure.community01.ch01.sort;

import java.util.Arrays;

/**
 * @Desc AppSort3
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppSort3 {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        try {
            Integer[] source1 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
            Integer[] source2 = Arrays.copyOf(source1, source1.length);
            Integer[] source3 = Arrays.copyOf(source1, source1.length);
            Integer[] source4 = Arrays.copyOf(source1, source1.length);
            Integer[] source5 = Arrays.copyOf(source1, source1.length);

            //冒泡排序
            System.out.println("冒泡排序前：" + Arrays.toString(source1));
            bubbleSort(source1);
            System.out.println("冒泡排序后：" + Arrays.toString(source1));

            //快速排序
            System.out.println("快速排序前：" + Arrays.toString(source2));
            quickSort(source2, 0, source2.length - 1);
            System.out.println("快速排序后：" + Arrays.toString(source2));

            //直接选择排序
            System.out.println("选择排序前：" + Arrays.toString(source3));
            straightSelectSort(source3);
            System.out.println("选择排序后：" + Arrays.toString(source3));

            //直接插入排序
            System.out.println("插入排序前：" + Arrays.toString(source4));
            straightInsertSort(source4);
            System.out.println("插入排序后：" + Arrays.toString(source4));

            //希尔排序
            System.out.println("希尔排序前：" + Arrays.toString(source5));
            shellSort(source5, source5.length / 2);
            System.out.println("希尔排序后：" + Arrays.toString(source5));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 交换排序-冒泡排序
     */
    public static void bubbleSort(Integer[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 交换排序-快速排序
     */
    public static void quickSort(Integer[] source, int left, int right) {
        if (left >= right) {
            return;
        }
        int ll = left;
        int rr = right;
        int flag = source[ll];
        while (ll < rr) {
            while (rr > ll && source[rr] >= flag) {
                rr--;
            }
            source[ll] = source[rr];
            while (ll < rr && source[ll] <= flag) {
                ll++;
            }
            source[rr] = source[ll];
        }
        int mid = (ll + rr) / 2;
        source[mid] = flag;
        quickSort(source, left, mid - 1);
        quickSort(source, mid + 1, right);
    }

    /**
     * 选择排序-直接选择排序
     */
    public static void straightSelectSort(Integer[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int base = source[i];
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] < base) {
                    int tmp = source[j];
                    source[j] = base;
                    base = tmp;
                }
            }
            source[i] = base;
        }
    }

    /**
     * 插入排序-直接插入排序
     */
    public static void straightInsertSort(Integer[] source) {
        for (int i = 1; i < source.length; i++) {
            int base = source[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (source[j] > base) {
                    source[j + 1] = source[j];
                }
            }
            source[j + 1] = base;
        }
    }

    /**
     * 插入排序-希尔排序
     */
    public static void shellSort(Integer[] source, int span) {
        if (span <= 0) {
            return;
        }
        for (int i = 0; i < span; i++) {
            for (int j = i; j < source.length; j += span) {
                if (j + span < source.length && source[j] > source[j + span]) {
                    int tmp = source[j];
                    source[j] = source[j + span];
                    source[j + span] = tmp;
                }
            }
        }
        shellSort(source, span / 2);
    }
}
