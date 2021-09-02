package com.timberliu.algorithm.leetcode.linkedlist.no0203_1_removeLinkedListElements;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 203. 移除链表元素
 *
 * @author liujie
 * @date 2021/8/23
 */

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/remove-linked-list-elements/ -----");
        System.out.println("----- 1 -----");
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        ListNode listNode = new Solution2().removeElements(head, 6);
        System.out.println(listNode);
    }

}
