package com.timberliu.algorithm.leetcode.linkedlist.no0021_1_mergeTwoSortedList.related.nno0143_reorderList;

import com.timberliu.algorithm.leetcode.linkedlist.ListNode;

/**
 * 143. 重排链表
 *
 *  找到链表中点 + 后半段反转 + 合并奇偶链表
 *
 *   链表中点归后面，slow和fast都为head，最后取 slow
 *   链表中点归前面，slow为head，fast为head.next，最后取 slow.next
 *
 * @author liujie
 * @date 2024/6/11
 */

public class Solution1 {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		// 找到中间节点
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 反转
		ListNode second = slow.next;
		slow.next = null;
		second = reverse(second);
		// 合并
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		int index = 0;
		while (head != null && second != null) {
			if (index % 2 == 0) {
				prev.next = head;
				head = head.next;
			} else {
				prev.next = second;
				second = second.next;
			}
			prev = prev.next;
			index++;
		}
		prev.next = head == null ? second : head;
	}

	private ListNode reverse(ListNode head) {
		ListNode newHead = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode nex = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = nex;
		}
		return newHead;
	}

	public static void main(String[] args) {

	}

}
