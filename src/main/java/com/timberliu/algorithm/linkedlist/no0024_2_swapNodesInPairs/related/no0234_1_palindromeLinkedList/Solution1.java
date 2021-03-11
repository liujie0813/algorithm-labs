package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs.related.no0234_1_palindromeLinkedList;

/**
 * 234. 回文链表
 *
 *
 *
 * Created by liujie on 2021/3/10
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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

    public boolean isPalindrome1(ListNode head) {
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

        Solution1 solution1 = new Solution1();
        boolean palindrome = solution1.isPalindrome1(l4);
        System.out.println(palindrome);
    }
}
