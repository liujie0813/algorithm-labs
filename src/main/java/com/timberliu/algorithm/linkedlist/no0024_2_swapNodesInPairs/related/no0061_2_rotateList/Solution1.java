package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs.related.no0061_2_rotateList;

/**
 * 61. 旋转链表
 *
 * Created by liujie on 2021/3/11
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            if (cur.next == null) {
                tail = cur;
            }
            cur = cur.next;
            count++;
        }
        k = k % count;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        for (int i = k; i < count; i++) {
            prev = prev.next;
        }
        tail.next = dummyHead.next;
        dummyHead.next = prev.next;
        prev.next = null;
        return dummyHead.next;
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
        System.out.println("----- https://leetcode-cn.com/problems/rotate-list/ -----");
        System.out.println("----- 1 -----");
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode head1 = solution1.rotateRight(l5, 0);
        System.out.println(solution1.toString(head1));

    }
}
