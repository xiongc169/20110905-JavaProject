package org.practice.dataStructure.ch01.sort;

import java.util.Arrays;

/**
 * @Desc App4Sort2
 * @Author
 * @Date 2019年7月5日18:16:20
 * @Version 1.0
 */
public class App4Sort2 {

    /**
     * 入口函数(排序算法)
     */
    public static void main(String[] args) {
        Integer[] source = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
        Integer[] source2 = Arrays.copyOf(source, source.length);
        Integer[] source3 = Arrays.copyOf(source, source.length);
        Integer[] source4 = Arrays.copyOf(source, source.length);

        //交换排序-冒泡排序
        System.out.println("冒泡排序前：" + Arrays.toString(source));
        bubbleSort(source);
        System.out.println("冒泡排序后：" + Arrays.toString(source));

        //交换排序-快速排序
        System.out.println("快速排序前：" + Arrays.toString(source2));
        //quickSort(source2, 0, source2.length - 1);
        quickSort2(source2, 0, source2.length - 1);
        System.out.println("快速排序后：" + Arrays.toString(source2));

        //选择排序-直接选择排序
        System.out.println("选择排序前：" + Arrays.toString(source3));
        straightSelectSort(source3);
        System.out.println("选择排序后：" + Arrays.toString(source3));

        //TODO：选择排序-堆排序
        //heapSort(source2);
        //System.out.println("选择排序后：" + Arrays.toString(source2));

        //插入排序-直接插入排序
        System.out.println("插入排序前：" + Arrays.toString(source4));
        straightInsertSort(source4);
        System.out.println("插入排序后：" + Arrays.toString(source4));

        //TODO：插入排序-希尔排序
        //shellSort(source2);
        //System.out.println("希尔排序后：" + Arrays.toString(source2));

        //TODO：合并排序
        //mergeSort(source2);
        //System.out.println("合并排序后：" + Arrays.toString(source2));

        move(source2);
        System.out.println("移动集合后：" + Arrays.toString(source2));
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(Integer[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j + 1];
                    source[j + 1] = source[j];
                    source[j] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序一
     */
    public static void quickSort(Integer[] source, int left, int right) {
        if (left < right) {
            int mid = getMid(source, left, right);
            quickSort(source, left, mid - 1);
            quickSort(source, mid + 1, right);
        }
    }

    private static Integer getMid(Integer[] source, int left, int right) {
        int ll = left;
        int rr = right;
        Integer flag = source[left];
        while (left < right) {
            while (right > left && source[right] > flag) {
                right--;
            }
            source[left] = source[right];
            while (left < right && source[left] < flag) {
                left++;
            }
            source[right] = source[left];
        }
        Integer mid = (left + right) / 2;
        source[mid] = flag;
        return mid;
    }

    /**
     * 快速排序二
     */
    public static void quickSort2(Integer[] source, int left, int right) {
        int ll = left;
        int rr = right;

        if (left >= right) {
            return;
        }
        Integer flag = source[left];
        while (left < right) {
            while (right > left && source[right] > flag) {
                right--;
            }
            source[left] = source[right];
            while (left < right && source[left] < flag) {
                left++;
            }
            source[right] = source[left];
        }
        Integer mid = (left + right) / 2;
        source[mid] = flag;
        quickSort2(source, ll, mid - 1);
        quickSort2(source, mid + 1, rr);
    }

    /**
     * 直接选择排序
     */
    public static void straightSelectSort(Integer[] source) {
        for (int i = 0; i < source.length; i++) {
            int tmp = source[i];
            for (int j = i; j < source.length; j++) {
                if (source[j] < tmp) {
                    source[i] = source[j];
                    source[j] = tmp;
                    tmp = source[i];
                }
            }
        }
    }

    /**
     * 直接插入排序
     */
    public static void straightInsertSort(Integer[] source) {
        for (int i = 1; i < source.length; i++) {
            int j = 0;
            int tmp = source[i];
            for (j = i; j > 0 && source[j - 1] > tmp; j--) {
                source[j] = source[j - 1];
            }
            source[j] = tmp;
        }
    }

    private static void move(Integer[] source) {
        for (int i = 1; i < source.length; i++) {
            source[i - 1] = source[i];
        }
    }

}





































