package org.practice.algorithm.ch05.divide;

/**
 * @Desc 分治算法
 * https://www.cnblogs.com/huangxincheng/archive/2012/02/07/2340797.html
 * <p/>
 * @Author yoong
 * <p/>
 * @Date 2019年2月14日10:15:00
 * <p/>
 * @Version 1.0
 */
public class App4DivideConquer {

    private static int newIndex = 0;

    private static int[] newArray = new int[100];

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int[] oldArray = {8, 4, 5, 7, 1, 2, 3, 6};
            divide(0, oldArray.length - 1, oldArray);
            System.out.println(newArray.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 归并排序
     */
    public static void divide(int left, int right, int[] oldArray) {
        int mid = (left + right) / 2;
        if (right - left <= 1) {
            return;
        }
        divide(left, mid, oldArray);
        int div1 = (left + mid) / 2;
        merge(left, right, div1, oldArray);

        divide(mid + 1, right, oldArray);
        int div2 = (mid + 1 + right) / 2;
        merge(mid + 1, right, div2, oldArray);
    }

    public static void merge(int left, int right, int mid, int[] oldArray) {
        int i = left;
        int j = mid + 1;
        while (i <= mid || j <= right) {
            if (oldArray[i] <= oldArray[j]) {
                newArray[newIndex++] = oldArray[i];
                i++;
            } else {
                newArray[newIndex++] = oldArray[j];
                j++;
            }
        }
    }
}
