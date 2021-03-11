package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs.related.no0206_1_reverseLinkedList;

/**
 * 206. 反转链表
 *
 * Created by liujie on 2021/3/10
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 循环解法
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    /**
     * 递归解法
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
        System.out.println("----- https://leetcode-cn.com/problems/reverse-linked-list/ -----");
        System.out.println("----- 1 ------");

        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode head1 = solution1.reverseList1(l3);
        System.out.println(solution1.toString(head1));

        System.out.println("----- 2 ------");

        ListNode l4 = new ListNode(1);
        ListNode head2 = solution1.reverseList1(l4);
        System.out.println(solution1.toString(head2));

        System.out.println("----- 3 ------");

        ListNode head3 = solution1.reverseList1(null);
        System.out.println(solution1.toString(head3));
    }
}
