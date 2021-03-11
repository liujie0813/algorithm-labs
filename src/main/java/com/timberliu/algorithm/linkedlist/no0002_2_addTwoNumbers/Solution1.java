package com.timberliu.algorithm.linkedlist.no0002_2_addTwoNumbers;

import com.timberliu.algorithm.linkedlist.no0707_2_designLinkedList.MyLinkedList01;

/**
 * 两数相加
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 * Created by liujie on 2021/3/9
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode head;
    private ListNode tail;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            sum = extra;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            if (sum > 9) {
                sum -= 10;
                extra = 1;
            } else {
                extra = 0;
            }
            addNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    private void addNode(int val) {
        if (head == null) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2, l4);
        ListNode l6 = new ListNode(3, l5);
        ListNode l7 = new ListNode(4, l6);

        Solution1 solution1 = new Solution1();
        ListNode listNode = solution1.addTwoNumbers(l3, l7);
        System.out.println(solution1.toString(listNode));
    }
}
