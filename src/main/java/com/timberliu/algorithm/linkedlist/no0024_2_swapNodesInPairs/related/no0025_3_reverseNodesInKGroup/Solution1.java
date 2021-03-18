package com.timberliu.algorithm.linkedlist.no0024_2_swapNodesInPairs.related.no0025_3_reverseNodesInKGroup;

import com.timberliu.algorithm.linkedlist.ListNode;

/**
 * 25. K 个一组翻转链表
 *
 *   三种解法大致为同一思路
 *      第一种为自己所写，虽成功，但代码欠缺优雅，逻辑不够清晰
 *      第二种改进：使用虚拟节点，去除第一次反转单独处理逻辑
 *      第三种改进：先使用循环确定当前逆转范围，再连接前后子链表，逻辑更加清晰
 *
 * Created by liujie on 2021/3/10
 */

public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prevEnd = null;
        ListNode cur = head;
        boolean firstReverse = true;
        while (cur != null) {
            ListNode newHead = reverse(cur, k);
            if (last) {
                reverse(newHead, k);
                break;
            }
            if (firstReverse) {
                head = newHead;
                firstReverse = false;
            } else {
                prevEnd.next = newHead;
            }
            prevEnd = cur;
            cur = cur.next;
        }
        return head;
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
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode head1 = solution1.reverseKGroup(l4, 4);
        System.out.println(head1);
    }
}
