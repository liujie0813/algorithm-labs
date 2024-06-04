package com.timberliu.algorithm.leetcode.linkedlist.no0083_1_removeDuplicatesFromSortedList.related.no0019_removeNthFromEnd;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author liujie
 * @date 2024/6/4
 */

public class Solution1 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		while (fast != null && n-- > 0) {
			fast = fast.next;
		}
		ListNode dummy = new ListNode(-1, head);
		ListNode prev = dummy;
		while (fast != null) {
			prev = prev.next;
			fast = fast.next;
		}
		prev.next = prev.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4, l1);
		ListNode l3 = new ListNode(3, l2);
		ListNode l4 = new ListNode(2, l3);
		ListNode l5 = new ListNode(1, l4);
		Solution1 solution1 = new Solution1();
		ListNode listNode = solution1.removeNthFromEnd(l5, 5);
		System.out.println(listNode);

	}

}
