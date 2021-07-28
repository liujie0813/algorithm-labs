package com.timberliu.algorithm.leetcode.linkedlist.no0725_2_splitLinkedListInParts;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 725. 分割链表
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int width = count / k, rem = count % k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; i++) {
            res[i] = cur;
            // -1：让 cur 指向子链表的最后一个结点
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1 && cur != null; j++) {
                cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/split-linked-list-in-parts/ -----");
        System.out.println("----- 1 -----");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l5);
        ListNode l7 = new ListNode(7, l6);
        ListNode l8 = new ListNode(8, l7);
        ListNode l9 = new ListNode(9, l8);
        Solution1 solution1 = new Solution1();
        ListNode[] listNodes1 = solution1.splitListToParts(l9, 3);
        for (int i = 0; i < listNodes1.length; i++) {
            System.out.println(i + ": " + listNodes1[i]);
        }

        System.out.println("----- 2 -----");
        ListNode l01 = new ListNode(1);
        ListNode l02 = new ListNode(2, l01);
        ListNode l03 = new ListNode(3, l02);
        ListNode l04 = new ListNode(4, l03);
        ListNode l05 = new ListNode(5, l04);
        ListNode l06 = new ListNode(6, l05);
        ListNode l07 = new ListNode(7, l06);
        ListNode l08 = new ListNode(8, l07);
        ListNode l09 = new ListNode(9, l08);
        ListNode[] listNodes2 = solution1.splitListToParts(l09, 10);
        for (int i = 0; i < listNodes2.length; i++) {
            System.out.println(i + ": " + listNodes2[i]);
        }
    }
}
