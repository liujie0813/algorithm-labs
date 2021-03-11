package com.timberliu.algorithm.linkedlist.no0002_2_addTwoNumbers.related.no0445_2_addTwoNumbers2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 445. 两数相加 2
 *
 *  不能修改原链表，通过栈来保存
 *
 * Created by liujie on 2021/3/9
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) { val = x; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> d1 = new LinkedList<>();
        while (l1 != null) {
            d1.push(l1.val);
            l1 = l1.next;
        }
        Deque<Integer> d2 = new LinkedList<>();
        while (l2 != null) {
            d2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int extra = 0;
        ListNode head = null;
        while (!d1.isEmpty() || !d2.isEmpty() || extra != 0) {
            Integer val1 = 0;
            if (!d1.isEmpty()) {
                val1 = d1.pop();
            }
            Integer val2 = 0;
            if (!d2.isEmpty()) {
                val2 = d2.pop();
            }
            sum = val1 + val2 + extra;
            if (sum > 9) {
                sum -= 10;
                extra = 1;
            } else {
                extra = 0;
            }
            head = new ListNode(sum, head);
        }
        return head;
    }

    public String toString(ListNode head) {
        Solution1.ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

    //   1 2 3
    // 1 8 7 4
    // 2 0 1 5
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(6, l1);
        ListNode l3 = new ListNode(5, l2);

        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4, l4);
        ListNode l6 = new ListNode(2, l5);
        ListNode l7 = new ListNode(7, l6);

        Solution1 solution1 = new Solution1();
        ListNode listNode = solution1.addTwoNumbers(l3, l7);
        System.out.println(solution1.toString(listNode));
    }
}
