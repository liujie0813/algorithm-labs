package com.timberliu.algorithm.leetcode.linkedlist.no0148_2_sortList.related.no0147_2_insertionSortList;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 147. 对链表进行插入排序
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    /**
     * 时间复杂度 O(n^2) 任何情况
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode p = head;
        while (p.next != null) {
            ListNode prev = dummy;
            while (prev.next != p.next && prev.next.val < p.next.val) {
                prev = prev.next;
            }
            if (prev.next == p.next) {
                p = p.next;
            } else {
                ListNode tmp = p.next;
                p.next = tmp.next;
                tmp.next = prev.next;
                prev.next = tmp;
            }
        }
        return dummy.next;
    }

    /**
     * 时间复杂度：O(n^2)
     *   最好情况下复杂度为 O(n)
     * @param head
     * @return
     */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head.next, lastSorted = head;
        while (cur != null) {
            // 对已经有序的节点 直接跳过
            if (lastSorted.val < cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val < cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/insertion-sort-list/ -----");
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(4, l5);
        Solution1 solution1 = new Solution1();
        ListNode newHead = solution1.insertionSortList1(l6);
        System.out.println(newHead);
    }
}
