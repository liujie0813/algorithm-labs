package com.timberliu.algorithm.leetcode.linkedlist.no0024_2_swapNodesInPairs.related.no0025_3_reverseNodesInKGroup;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 25. K 个一组翻转链表
 *
 *   关键点：
 *    1. 确定当前反转的子链表的范围
 *    2. 反转后将前后子链表连起来
 *
 * Created by liujie on 2021/3/10
 */

public class Solution3 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        // 前一个子链表的最后一个节点
        ListNode prevEnd = dummyHead;
        // 当前子链表的第一个节点
        ListNode curStart = head;
        ListNode cur = head;
        while (cur != null) {
            for (int i = 1; i < k && cur != null; i++) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            // 下一个节点存下来
            ListNode nexStart = cur.next;
            cur.next = null;
            prevEnd.next = reverse(curStart);
            curStart.next = nexStart;

            prevEnd = curStart;
            cur = curStart = nexStart;
        }
        return dummyHead.next;
    }

    /**
     * 反转
     */
    public ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/reverse-nodes-in-k-group/ -----");
        System.out.println("----- 1 -----");
        Solution3 solution1 = new Solution3();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        System.out.println(l5);
        ListNode head1 = solution1.reverseKGroup(l5, 2);
        System.out.println(head1);
    }
}
