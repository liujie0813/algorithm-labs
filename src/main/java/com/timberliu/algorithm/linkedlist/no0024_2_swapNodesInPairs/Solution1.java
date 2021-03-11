package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs;

/**
 * 24. 两两交换链表中的节点
 *
 *   注意：除了交换两个节点外，还要之前的节点指向新的节点（prev 指向 nex）
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
    public ListNode swapPairs0(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next;
            ListNode nex = cur.next;
            prev.next = nex;
            // 下面两行不能交换
            cur.next = nex.next;
            nex.next = cur;
            prev = cur;
        }
        return dummyHead.next;
    }

    /**
     * 递归解法
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nex = head.next;
        head.next = swapPairs1(nex.next);
        nex.next = head;
        return nex;
    }

    /**
     * 递归解法2
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rest = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs2(rest);
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
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);

        Solution1 solution1 = new Solution1();
        ListNode res1 = solution1.swapPairs0(l4);
        System.out.println(solution1.toString(res1));
    }
}
