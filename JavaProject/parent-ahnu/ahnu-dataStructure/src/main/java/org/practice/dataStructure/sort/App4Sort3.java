package org.practice.dataStructure.sort;

import java.util.Arrays;

/**
 * @Desc App4Sort3
 * @Author
 * @Date 2019年11月28日15:21:25
 * @Version 1.0
 */
public class App4Sort3 {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        Integer[] source1 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source2 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source3 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source4 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};

        //冒泡排序
        bubbleSort(source1);
        System.out.println("冒泡排序后：" + Arrays.toString(source1));

        //快速排序
        quickSort(source2, 0, source2.length - 1);
        System.out.println("快速排序后：" + Arrays.toString(source2));

        //直接选择排序
        straightSelectSort(source3);
        System.out.println("选择排序后：" + Arrays.toString(source3));
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
}
