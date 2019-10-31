package org.practice.dataStructure.sort;

/**
 * @Desc App2
 * @Author
 * @Date 2019年7月5日18:16:20
 * @Version 1.0
 */
public class App2 {

    public static void main(String[] args) {
        Integer[] source = new Integer[]{7, 30, 50, 21, 12, 14, 19};
        Integer[] source2 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};

        //交换排序-冒泡排序
        bubbleSort(source);
        output(source);

        //交换排序-快速排序
        //quickSort(source2, 0, source2.length - 1);
        quickSort2(source2, 0, source2.length - 1);
        output(source2);

        //选择排序-直接选择排序
        straightSelectSort(source2);
        output(source2);

        //TODO：选择排序-堆排序
        //straightSelectSort(source2);
        //output(source2);

        //插入排序-直接插入排序
        straightInsertSort(source2);
        output(source2);

        //TODO：插入排序-希尔排序
        //straightInsertSort(source2);
        //output(source2);

        //TODO：合并排序
        //straightInsertSort(source2);
        //output(source2);

        move(source2);
        output(source2);

        System.out.println("Ending");
    }

    private static void output(Integer[] source) {
        for (int i : source) {
            System.out.printf("%d  ", i);
        }
        System.out.println();
    }

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





































