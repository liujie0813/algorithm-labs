package com.timberliu.algorithm.leetcode.linkedlist.no0160_1_intersectionOfTwoLinkedList.related.no0141_1_linkedListCycle;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 141. 环形链表
 *
 *  判断是否有环：快慢指针
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/linked-list-cycle/ -----");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l5);
        l1.next = l4;

        Solution1 solution1 = new Solution1();
        boolean b = solution1.hasCycle(l6);
        System.out.println(b);
    }
}
