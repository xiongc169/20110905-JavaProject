package org.practice.algorithm.book01;

public class DivideConquer {

    /**
     * 入口函數
     */
    public static void main(String[] args) {
        try {
            int[] array = {1, 4, 5, 3, 32, 21, 23, 44, 65, 6, 7, 53, 24, 111};
            int max = getMax0202(0, array.length - 1, array);
            System.out.println(max);

            int[] array2 = {8, 4, 5, 7, 1, 2, 3, 6};
            divideMerge(0, array.length - 1, array);
            System.out.println(array2.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 求最大值
     */
    public static int getMax0202(int start, int end, int[] array) {
        if (end - start <= 1) {
            return Math.max(array[start], array[end]);
        }
        int mid = (start + end) / 2;
        int leftMax = getMax0202(start, mid, array);
        int rightMax = getMax0202(mid + 1, end, array);
        return Math.max(leftMax, rightMax);
    }

    /**
     * 归并排序(分治法)
     */
    public static void divideMerge(int start, int end, int[] array) {
        if (end - start <= 1) {
            if (array[end] < array[start]) {
                int tmp = array[end];
                array[end] = array[start];
                array[start] = tmp;
            }
            return;
        }
        int mid = (start + end) / 2;
        divideMerge(start, mid, array);
        divideMerge(mid + 1, end, array);
        merge(start, end, array);
    }

    public static void merge(int start, int end, int[] array) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int[] tmpArray = new int[end - start + 1];
        int tmpIndex = 0;
        while (i <= mid && j <= end) {
            if (j <= end && array[i] > array[j]) {
                tmpArray[tmpIndex++] = array[j];
                j++;
            } else if (i <= mid && array[i] <= array[j]) {
                tmpArray[tmpIndex++] = array[i];
                i++;
            }
        }
        while (i <= mid) {
            tmpArray[tmpIndex++] = array[i];
            i++;
        }
        while (j <= end) {
            tmpArray[tmpIndex++] = array[j];
            j++;
        }
        for (int k = 0; k < tmpArray.length; k++) {
            array[start + k] = tmpArray[k];
        }
    }
}
