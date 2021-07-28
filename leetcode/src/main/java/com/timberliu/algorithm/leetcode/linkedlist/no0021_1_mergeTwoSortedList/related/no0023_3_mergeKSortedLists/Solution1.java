package com.timberliu.algorithm.leetcode.linkedlist.no0021_1_mergeTwoSortedList.related.no0023_3_mergeKSortedLists;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 23. 合并 k 个升序链表
 *
 *   分治法
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int middle = left + (right - left) / 2;
        ListNode leftHead = mergeKLists(lists, left, middle);
        ListNode rightHead = mergeKLists(lists, middle + 1, right);
        return mergeTwoLists2(leftHead, rightHead);
    }

    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(-1, l2);

        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(4, l4);
        ListNode l6 = new ListNode(1, l5);

        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(5, l7);
        ListNode l9 = new ListNode(4, l8);

        ListNode[] list = {l3, l6, l9, null};
        Solution1 solution1 = new Solution1();
        ListNode newHead = solution1.mergeKLists1(list);
        System.out.println(newHead);
    }
}
