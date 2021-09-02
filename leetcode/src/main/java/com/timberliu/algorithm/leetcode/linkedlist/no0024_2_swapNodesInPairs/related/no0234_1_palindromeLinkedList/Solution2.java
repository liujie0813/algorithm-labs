package com.timberliu.algorithm.leetcode.linkedlist.no0024_2_swapNodesInPairs.related.no0234_1_palindromeLinkedList;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 234. 回文链表
 *
 *  原理：
 *   1. 定位到链表中间 leftHalfEnd（如果有两个 则是前一个）
 *   2. 对链表后半部分反转
 *   3. 对前半部分和后半部分循环判断
 *   4. 再反转后半部分
 *
 * @author Timber
 * @date 2021/8/29
 */
public class Solution2 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode leftHalfEnd = endOfLeftHalf(head);
        ListNode rightHead = reverse(leftHalfEnd.next);

        ListNode left = head;
        ListNode right = rightHead;
        boolean res = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        leftHalfEnd.next = reverse(rightHead);
        return res;
    }

    private ListNode endOfLeftHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/palindrome-linked-list/ -----");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);

        Solution2 solution2 = new Solution2();
        boolean palindrome = solution2.isPalindrome(l4);
        System.out.println(palindrome);
    }
}
