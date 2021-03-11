package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs.related.no0092_2_reverseLinkedList2;

/**
 * 92. 反转链表 2
 *
 *   递归实现
 *
 * Created by liujie on 2021/3/10
 */

public class Solution2 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            // 反转从 head 开始的 right 个元素
            return reverseN(head, right);
        }
        // 从 left - 1 位置处的 right - 1 个元素
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;

    /**
     * 反转链表的前 n 个元素
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录后驱节点
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
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
        System.out.println("----- https://leetcode-cn.com/problems/reverse-linked-list-ii/ -----");
        System.out.println("----- 1 -----");

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode l5 = new ListNode(1, l4);
        Solution2 solution1 = new Solution2();
        ListNode head1 = solution1.reverseBetween(l5, 2, 4);
        System.out.println(solution1.toString(head1));

        System.out.println("----- 2 -----");
        solution1.successor = null;

        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(4, l6);
        ListNode l8 = new ListNode(3, l7);
        ListNode l9 = new ListNode(2, l8);
        ListNode l10 = new ListNode(1, l9);
        ListNode head2 = solution1.reverseBetween(l10, 1, 5);
        System.out.println(solution1.toString(head2));
    }
}
