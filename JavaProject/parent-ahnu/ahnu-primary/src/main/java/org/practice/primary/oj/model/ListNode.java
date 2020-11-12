package org.practice.primary.oj.model;

/**
 * Definition for singly-linked list.
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
