package org.practice.algorithm.book01;

public class DivideConquer {

    /**
     * 入口函數
     */
    public static void main(String[] args) {
        try {
            int[] array = {1, 4, 5, 3, 2, 21, 23, 44, 5, 6, 7, 3, 2, 111};
            int max = getMax0202(0, array.length - 1, array);
            System.out.println(max);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getMax0202(int start, int end, int[] array) {
        if (end - start <= 1) {
            return Math.max(array[start], array[end]);
        }
        int mid = (start + end) / 2;
        int leftMax = getMax0202(start, mid, array);
        int rightMax = getMax0202(mid + 1, end, array);
        return Math.max(leftMax, rightMax);
    }
}
