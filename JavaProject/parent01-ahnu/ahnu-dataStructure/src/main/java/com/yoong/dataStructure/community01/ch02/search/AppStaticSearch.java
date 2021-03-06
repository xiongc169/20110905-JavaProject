package com.yoong.dataStructure.community01.ch02.search;

/**
 * @Desc 静态查找
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppStaticSearch {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            Integer[] source = new Integer[]{7, 30, 50, 21, 12, 14, 19};
            Integer[] source2 = {11, 33, 44, 5, 6, 2, 99, 13, 35, 21, 87};
            Integer[] source3 = {11, 33, 44, 55, 60, 98, 99, 103, 135, 210, 870};

            //顺序查找
            int index = sequenceSearch(source, 50);
            System.out.println("sequenceSearch index: " + index);

            //折半查找(递归)
            int index2 = binarySearchRecursion(source3, 0, source3.length - 1, 60);
            System.out.println("binarySearchRecursion index: " + index2);

            //折半查找(非递归)
            int index3 = binarySearchNonRecursion(source3, 60);
            System.out.println("binarySearchNonRecursion index: " + index3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 顺序查找
     */
    public static int sequenceSearch(Integer[] source, Integer aim) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == aim) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 折半查找(递归)
     */
    public static int binarySearchRecursion(Integer[] source, int left, int right, Integer aim) {
        if (left < right) {
            if (source[left] > aim || source[right] < aim) {
                return -1;
            }
            if (source[left] == aim) {
                return left;
            }
            if (source[right] == aim) {
                return right;
            }
            int mid = (left + right) / 2;
            if (source[mid] == aim) {
                return mid;
            } else if (source[mid] < aim) {
                //检索右侧
                return binarySearchRecursion(source, mid + 1, right, aim);
            } else if (source[mid] > aim) {
                //检索左侧
                return binarySearchRecursion(source, left, mid - 1, aim);
            }
        }
        return -1;
    }

    /**
     * 折半查找(非递归)
     */
    public static int binarySearchNonRecursion(Integer[] source, int aim) {
        int left = 0;
        int right = source.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (source[mid] == aim) {
                return mid;
            }
            if (source[mid] < aim) {
                left = mid + 1;
            }
            if (source[mid] > aim) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
