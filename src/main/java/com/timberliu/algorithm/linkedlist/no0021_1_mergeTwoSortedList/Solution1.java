package com.timberliu.algorithm.linkedlist.no0021_1_mergeTwoSortedList;

/**
 * 21. 合并两个有序链表
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public String toString(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/merge-two-sorted-lists/ -----");
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(8, l4);
        ListNode l6 = new ListNode(4, l5);
        ListNode l7 = new ListNode(2, l6);

        Solution1 solution1 = new Solution1();
        ListNode newHead = solution1.mergeTwoLists2(l3, l7);
        System.out.println(solution1.toString(newHead));
    }
}
