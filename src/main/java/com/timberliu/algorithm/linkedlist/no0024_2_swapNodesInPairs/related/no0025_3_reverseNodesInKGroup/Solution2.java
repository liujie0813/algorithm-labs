package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs.related.no0025_3_reverseNodesInKGroup;

import com.timberliu.algorithm.linkedlist.ListNode;

/**
 * 25. K 个一组翻转链表
 *
 * Created by liujie on 2021/3/10
 */

public class Solution2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prevEnd = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            ListNode newHead = reverse(cur, k);
            if (last) {
                reverse(newHead, k);
                break;
            }
            prevEnd.next = newHead;
            prevEnd = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }

    private boolean last = false;

    /**
     * 反转
     */
    public ListNode reverse(ListNode head, int n) {
        ListNode prev = null;
        ListNode cur = head;
        int i = 1;
        while (cur != null && i <= n) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            i++;
        }
        if (cur == null && i <= n) {
            last = true;
        } else {
            head.next = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/reverse-nodes-in-k-group/ -----");
        System.out.println("----- 1 -----");
        Solution2 solution1 = new Solution2();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode head1 = solution1.reverseKGroup(l2, 1);
        System.out.println(head1);
    }
}
