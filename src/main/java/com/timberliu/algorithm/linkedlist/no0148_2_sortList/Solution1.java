package com.timberliu.algorithm.linkedlist.no0148_2_sortList;

import com.timberliu.algorithm.linkedlist.ListNode;

/**
 * 148. 排序链表
 *
 *   原理？
 *     1. 快慢指针找到链表中间节点
 *     2. 断开链表，对 left、right 递归排序
 *     3. 合并两个有序子链表
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return mergeOrderedList2(left, right);
    }

    private ListNode mergeOrderedList1(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        prev.next = left == null ? right : left;
        return dummy.next;
    }

    private ListNode mergeOrderedList2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2  == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = mergeOrderedList2(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeOrderedList2(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sort-list/ -----");
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(4, l5);
        Solution1 solution1 = new Solution1();
        ListNode newHead = solution1.sortList(l6);
        System.out.println(newHead);
    }
}
