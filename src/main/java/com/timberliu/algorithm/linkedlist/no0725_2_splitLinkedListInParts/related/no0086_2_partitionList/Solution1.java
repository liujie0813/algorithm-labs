package com.timberliu.algorithm.linkedlist.no0725_2_splitLinkedListInParts.related.no0086_2_partitionList;

import com.timberliu.algorithm.linkedlist.ListNode;

/**
 * 86. 分隔链表
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    /**
     * 遍历链表，将小于 x 的节点移动到链表开始
     *   prev 节点维护相对顺序
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val < x) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;

                tmp.next = prev.next;
                prev.next = tmp;
                if (prev == cur) {
                    cur = cur.next;
                }
                prev = prev.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 将小于 x 和 大于等于 x 的节点分到两个链表中
     *   再进行链接
     */
    public static ListNode partition1(ListNode head, int x) {
        ListNode lesser = new ListNode(-1);
        ListNode less = lesser;
        ListNode greater = new ListNode(-1);
        ListNode great = greater;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                great.next = head;
                great = great.next;
            }
            head = head.next;
        }
        great.next = null;
        less.next = greater.next;
        return lesser.next;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/partition-list/ -----");
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(4, l4);
        ListNode l6 = new ListNode(1, l5);
        ListNode head1 = partition1(l6, 3);
        System.out.println(head1);

        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(2, l7);
        ListNode head2 = partition1(l7, 2);
        System.out.println(head2);

        ListNode l9 = new ListNode(2);
        ListNode l10 = new ListNode(5, l9);
        ListNode l11 = new ListNode(2, l10);
        ListNode l12 = new ListNode(0, l11);
        ListNode l13 = new ListNode(3, l12);
        ListNode l14 = new ListNode(4, l13);
        ListNode l15 = new ListNode(1, l14);
        ListNode head3 = partition1(l15, 3);
        System.out.println(head3);

    }
}
