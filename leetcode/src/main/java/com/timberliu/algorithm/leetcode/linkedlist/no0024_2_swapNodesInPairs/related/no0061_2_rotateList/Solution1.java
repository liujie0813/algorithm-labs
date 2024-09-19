package com.timberliu.algorithm.leetcode.linkedlist.no0024_2_swapNodesInPairs.related.no0061_2_rotateList;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 61. 旋转链表
 *
 *  先连成环，再从 k 处断开
 *
 * Created by liujie on 2021/3/11
 */

public class Solution1 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        // 此时 cur 指向尾节点
        cur.next = head;
        ListNode prev = cur;
        for (int i = k; i < count; i++) {
            prev = prev.next;
        }
        ListNode newHead = prev.next;
        prev.next = null;
        return newHead;
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
        ListNode head1 = solution1.rotateRight(l5, 2);
        System.out.println(head1);

    }
}
