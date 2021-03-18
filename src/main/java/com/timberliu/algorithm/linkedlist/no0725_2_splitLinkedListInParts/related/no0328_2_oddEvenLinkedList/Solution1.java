package com.timberliu.algorithm.linkedlist.no0725_2_splitLinkedListInParts.related.no0328_2_oddEvenLinkedList;

import com.timberliu.algorithm.linkedlist.ListNode;

/**
 * 328. 奇偶链表
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode oddPrev = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode evenPrev = evenHead;

        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = null;
            if (i % 2 == 1) {
                oddPrev.next = cur;
                oddPrev = oddPrev.next;
            } else {
                evenPrev.next = cur;
                evenPrev = evenPrev.next;
            }
            cur = nex;
            i++;
        }
        oddPrev.next = evenHead.next;
        return oddHead.next;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/odd-even-linked-list/ -----");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l5);
        ListNode l7 = new ListNode(7, l6);
        ListNode l8 = new ListNode(8, l7);
        ListNode l9 = new ListNode(9, l8);
        Solution1 solution1 = new Solution1();
        ListNode head = solution1.oddEvenList1(l9);
        System.out.println(head);
    }

}
