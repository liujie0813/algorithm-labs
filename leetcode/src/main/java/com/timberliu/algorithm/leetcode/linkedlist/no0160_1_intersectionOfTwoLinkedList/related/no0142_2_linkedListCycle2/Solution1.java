package com.timberliu.algorithm.leetcode.linkedlist.no0160_1_intersectionOfTwoLinkedList.related.no0142_2_linkedListCycle2;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 142. 环形链表 2
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/linked-list-cycle-ii/ -----");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l5);
        l1.next = l4;

        Solution1 solution1 = new Solution1();
        ListNode node = solution1.detectCycle(l6);
        System.out.println(node.val);
    }
}
