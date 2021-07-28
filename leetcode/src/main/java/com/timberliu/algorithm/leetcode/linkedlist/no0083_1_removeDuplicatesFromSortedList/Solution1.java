package com.timberliu.algorithm.leetcode.linkedlist.no0083_1_removeDuplicatesFromSortedList;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * Created by liujie on 2021/3/11
 */

public class Solution1 {

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur;
            while (nex.next != null && nex.val == nex.next.val) {
                nex = nex.next;
            }
            cur.next = nex.next;
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/ -----");
        System.out.println("----- 1 -----");
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);
        ListNode l5 = new ListNode(1, l4);
        ListNode head1 = solution1.deleteDuplicates(l5);
        System.out.println(head1);

        System.out.println("----- 2 -----");
        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(1, l8);
        ListNode l10 = new ListNode(1, l9);
        ListNode head2 = solution1.deleteDuplicates(l10);
        System.out.println(head2);
    }
}
