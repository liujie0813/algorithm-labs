package com.timberliu.algorithm.linkedlist.no0160_1_intersectionOfTwoLinkedList;

import com.timberliu.algorithm.linkedlist.ListNode;

/**
 * 160. 相交链表
 *
 *
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        int firstCount = 0;
        while (first != null) {
            firstCount++;
            first = first.next;
        }

        ListNode second = headB;
        int secondCount = 0;
        while (second != null) {
            secondCount++;
            second = second.next;
        }

        ListNode longer = headA;
        ListNode shorter = headB;
        int diff = firstCount - secondCount;
        if (diff < 0) {
            longer = headB;
            shorter = headA;
            diff = secondCount - firstCount;
        }
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (shorter != null && longer != null) {
            if (shorter == longer) {
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode first = headA, second = headB;
        while (first != second) {
            first = first.next == null ? headB : first.next;
            second = second.next == null ? headA : second.next;
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/intersection-of-two-linked-lists/ -----");
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(2, l2);

        ListNode l4 = new ListNode(3, l3);
        ListNode l5 = new ListNode(4, l4);
        ListNode l6 = new ListNode(5, l5);

        ListNode l7 = new ListNode(7, l3);
        ListNode l8 = new ListNode(8, l7);

        Solution1 solution1 = new Solution1();
        ListNode intersectionNode = solution1.getIntersectionNode1(l8, l6);
        System.out.println(intersectionNode.val);
    }
}
