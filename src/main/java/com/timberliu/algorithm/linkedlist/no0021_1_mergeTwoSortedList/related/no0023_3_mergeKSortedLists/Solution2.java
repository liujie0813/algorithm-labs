package com.timberliu.algorithm.linkedlist.no0021_1_mergeTwoSortedList.related.no0023_3_mergeKSortedLists;

import com.timberliu.algorithm.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 k 个升序链表
 *
 * Created by liujie on 2021/3/17
 */

public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            prev.next = listNode;
            prev = prev.next;
            if (listNode.next != null) {
                queue.offer(listNode.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/merge-two-sorted-lists/ -----");
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(-1, l2);

        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(4, l4);
        ListNode l6 = new ListNode(1, l5);

        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(5, l7);
        ListNode l9 = new ListNode(4, l8);

        ListNode[] list = {l3, l6, l9, null};
        Solution2 solution1 = new Solution2();
        ListNode newHead = solution1.mergeKLists(list);
        System.out.println(newHead);
    }
}
