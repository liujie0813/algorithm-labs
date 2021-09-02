package com.timberliu.algorithm.leetcode.linkedlist.no0024_2_swapNodesInPairs.related.no0234_1_palindromeLinkedList;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 234. 回文链表
 *
 *  递归：
 *   1. left 指向链表头，check 函数递归到链表尾
 *   2. left 和 cur 的 val 比较不等返回 false
 *   3. left 指向 next，check 函数递归向上 从尾向前
 *
 * Created by liujie on 2021/3/10
 */

public class Solution1 {

    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return check(head);
    }

    private boolean check(ListNode cur) {
        if (cur == null) {
            return true;
        }
        if (!check(cur.next)) {
            return false;
        }
        if (left.val != cur.val) {
            return false;
        }
        left = left.next;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/palindrome-linked-list/ -----");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);

        Solution1 solution1 = new Solution1();
        boolean palindrome = solution1.isPalindrome(l4);
        System.out.println(palindrome);
    }
}
