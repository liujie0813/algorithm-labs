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
        ListNode cur = head;
        // 当前子链表的最后一个节点
        ListNode curEnd = head;
        while (curEnd != null) {
            for (int i = 1; i < k && curEnd != null; i++) {
                curEnd = curEnd.next;
            }
            if (curEnd == null) {
                break;
            }
            // 下一个节点存下来
            ListNode nexStart = curEnd.next;
            curEnd.next = null;
            prevEnd.next = reverse(cur);
            cur.next = nexStart;

            prevEnd = cur;
            curEnd = cur = nexStart;
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
        ListNode head1 = solution1.reverseKGroup(l5, 5);
        System.out.println(head1);
    }
}
