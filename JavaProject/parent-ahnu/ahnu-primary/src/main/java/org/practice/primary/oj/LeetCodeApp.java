package org.practice.primary.oj;

import org.practice.primary.oj.model.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc https://leetcode-cn.com
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年7月8日14:41:19
 * <p>
 * @Version 1.0
 */
public class LeetCodeApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
//            int[] nums = new int[]{2, 7, 11, 15};
//            int target = 9;
//            twoSum(nums, target);

//            ListNode a = new ListNode(5);
//            a.next = new ListNode(4);
//            a.next.next = new ListNode(3);
//            ListNode b = new ListNode(5);
//            b.next = new ListNode(6);
//            b.next.next = new ListNode(4);
//            ListNode c = addTwoNumbers(a, b);

//            lengthOfLongestSubstring("pwwkew");

//            int[] nums1 = new int[]{};
//            int[] nums2 = new int[]{2, 4};
//            findMedianSortedArrays(nums1, nums2);

//            longestPalindrome("cbbd");

//            convert("LEETCODEISHIRING", 4);

//            reverse(1534236469);

//            String input = "2147483649";
//            Integer result = myAtoi(input);
//            System.out.println(result);

//            isPalindrome(101);

            isMatch("aab", "c*a*b");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 两数之和
     * https://leetcode-cn.com/problems/two-sum/
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; i < nums.length && i != j; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 两数相加
     * https://leetcode-cn.com/problems/add-two-numbers/
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode iterator = head;
        Integer mode = 0;
        while (l1 != null || l2 != null || mode > 0) {
            iterator.next = new ListNode(0);
            Integer sum = mode;
            if (l1 != null && l2 != null) {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            mode = sum / 10;
            iterator.next.val = sum % 10;
            iterator = iterator.next;
        }
        head = head.next;
        return head;
    }

    /**
     * 无重复字符的最长子串
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * abcabcbb，返回3
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
//        List<String> parts = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < chars.length; j++) {
                if (sb.toString().contains(String.valueOf(chars[j]))) {
                    break;
                }
                sb.append(String.valueOf(chars[j]));
            }
            if (sb.toString().length() > maxLength) {
                maxLength = sb.toString().length();
            }
//            parts.add(sb.toString());
        }
        System.out.println(maxLength);
//        System.out.println(parts.size());
        return maxLength;
    }

    /**
     * 寻找两个有序数组的中位数
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] result = new int[nums1.length + nums2.length];
        //排序
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    result[i + j] = nums1[i];
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    result[i + j] = nums2[j];
                    j++;
                } else if (nums1[i] == nums2[j]) {
                    result[i + j] = nums1[i];
                    result[i + j + 1] = nums2[j];
                    i++;
                    j++;
                }
            } else if (i < nums1.length) {
                result[i + j] = nums1[i];
                i++;
            } else if (j < nums2.length) {
                result[i + j] = nums2[j];
                j++;
            }
        }
        double mid = 0;
        if (result.length <= 0) {
            return mid;
        }
        if (result.length % 2 == 0) {
            int midIndex = result.length / 2;
            mid = (result[midIndex - 1] + result[midIndex]) / 2.0;
        } else {
            int midIndex = result.length / 2;
            mid = result[midIndex];
        }
        return mid;
    }

    /**
     * 最长回文子串
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     */
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<String> huiwen = new ArrayList<>();
        String longest = "";
        if (s.length() > 0) {
            longest = s.substring(0, 1);
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j > i; j--) {
                if (chars[i] == chars[j]) {
                    boolean isHuiwen = isPalindrome(chars, i, j);
                    if (isHuiwen && longest.length() < j - i + 1) {
                        longest = s.substring(i, j + 1);
                        huiwen.add(s.substring(i, j + 1));
                    }
                }
            }
        }
        System.out.println(huiwen.size());
        return longest;
    }

    private static boolean isPalindrome(char[] chars, int i, int j) {
        for (; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Z 字形变换
     * https://leetcode-cn.com/problems/zigzag-conversion/
     */
    public static String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows <= 1) {
            return s;
        }
        int increment = 2 * (numRows - 1);//10
        List<StringBuilder> sbList = new ArrayList<>(numRows);
        String result = "";
        for (int i = 0; i < numRows; i++) {
            int multi = 0;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int index1 = i + multi * increment;
                if (index1 >= s.length()) {
                    break;
                }
                String s1 = s.substring(index1, index1 + 1);
                sb.append(s1);
                if (i > 0 && i < numRows - 1) {
                    int index2 = increment - i + multi * increment;
                    if (index2 >= s.length()) {
                        break;
                    }
                    String s2 = s.substring(index2, index2 + 1);
                    sb.append(s2);
                }
                multi++;
            }
            result += sb.toString();
            sbList.add(sb);
        }
        return result;
    }

    /**
     * 整数反转
     * 132 -120
     * https://leetcode-cn.com/problems/reverse-integer/
     */
    public static int reverse(int x) {
//        char[] chars = String.valueOf(x).toCharArray();
//        int result = 0;
//        for (int i = chars.length - 1; i > 0; i--) {
//            int tmp = Integer.valueOf(chars[i]);
//            result = result * 10 + tmp;
//        }
//        if (String.valueOf(chars[0]).matches("\\d")) {
//            result = result * 10 + Integer.valueOf(chars[0]);
//        } else if (String.valueOf(chars[0]).equals("-")) {
//            result = -result;
//        }
        if (x < -Math.pow(2, 31) || x > Math.pow(2, 31) - 1) {
            return 0;
        }
        String str = String.valueOf(x);
        long result = 0l;
        for (int i = str.length() - 1; i > 0; i--) {
            int tmp = Integer.valueOf(str.substring(i, i + 1));
            result = result * 10 + tmp;
        }
        if (str.substring(0, 1).matches("\\d")) {
            result = result * 10 + Integer.valueOf(str.substring(0, 1));
        } else if (str.substring(0, 1).equals("-")) {
            result = -result;
        }
        if (result < -Math.pow(2, 31) || result > Math.pow(2, 31) - 1) {
            return 0;
        }
        return (int) result;
    }

    /**
     * 字符串转换整数 (atoi)
     * PS：2019年12月2日12:00:59
     * https://leetcode-cn.com/problems/string-to-integer-atoi/
     */
    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() <= 0) {
            return 0;
        }
        String positive = "+";
        String negative = "-";
        String digitRegex = "[0-9]";
        String first = str.substring(0, 1);
        if (!first.matches(digitRegex) && !first.equals(positive) && !first.equals(negative)) {
            return 0;
        }
        boolean isNegative = false;
        if (first.equals(positive) || first.equals(negative)) {
            isNegative = first.equals(negative) ? true : false;
            str = str.substring(1);
        }
        Integer num = 0;
        Integer index = 0;
        while (index < str.length()) {
            String element = str.substring(index, index + 1);
            if (!element.matches(digitRegex)) {
                break;
            }
            Integer append = Integer.valueOf(element);
            //Integer.MAX_VALUE = 2147483647
            if (!isNegative && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && append > 7))) {
                return Integer.MAX_VALUE;
            }
            //Integer.MIN_VALUE = -2147483648
            if (isNegative && (-num < Integer.MIN_VALUE / 10 || (-num == Integer.MIN_VALUE / 10 && append > 8))) {
                return Integer.MIN_VALUE;
            }
            num = num * 10 + append;
            index++;
        }
        num = isNegative ? -num : num;
        return num;
    }

    /**
     * 回文数
     * PS：2019年12月2日14:19:48
     * https://leetcode-cn.com/problems/palindrome-number/
     */
    public static boolean isPalindrome(Integer x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        List<Integer> parts = new ArrayList<>();
        Integer mode = 10;
        while (true) {
            if (x <= 0) {
                break;
            }
            Integer tmp = x % mode;
            parts.add(tmp);
            x = x / 10;
        }
        for (int i = 0; i < parts.size() / 2; i++) {
            if (!parts.get(i).equals(parts.get(parts.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 正则表达式匹配
     * PS:
     * https://leetcode-cn.com/problems/regular-expression-matching/
     */
    public static boolean isMatch(String s, String p) {
        String[] input = s.split("");
        String[] regex = p.split("");
        Queue headIndex = new ArrayDeque();

        for (int i = 0; i < regex.length; i++) {

        }

        return false;
    }
}


