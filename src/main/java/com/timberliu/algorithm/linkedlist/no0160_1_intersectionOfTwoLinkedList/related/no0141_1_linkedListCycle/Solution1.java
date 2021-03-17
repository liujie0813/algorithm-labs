package com.timberliu.algorithm.linkedlist.no0160_1_intersectionOfTwoLinkedList.related.no0141_1_linkedListCycle;

/**
 * 141. 环形链表
 *
 * Created by liujie on 2021/3/17
 */

public class Solution1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public String toString(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

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
