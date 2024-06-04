package com.timberliu.algorithm.basic.linkedlist;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Timber
 * @date 2023/7/2
 */
public class TwoNumberMinus {

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode twoNumberMinus(ListNode first, ListNode second) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (first != null || second != null) {
			int num = first.val;
			// 借一位
			if (second != null && num < second.val) {
				if (first.next.val > 0) {
					first.next.val--;
				} else {
					ListNode cur = first.next;
					while (cur.val == 0) {
						cur.val = 9;
						cur = cur.next;
					}
					cur.val--;
				}
				num += 10;
			}
			first = first.next;
			if (second != null) {
				num -= second.val;
				second = second.next;
			}

			prev.next = new ListNode(num);
			prev = prev.next;
		}
		return dummy.next;
	}

	public static ListNode buildNode(List<Integer> arr) {
		ListNode head = null;
		for (Integer val : arr) {
			head = new ListNode(val, head);
		}
		return head;
	}

	public static String print(ListNode head) {
		Deque<Integer> stack = new LinkedList<>();
		while (head != null) {
			stack.push(head.val);
			head = head.next;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ListNode first1 = buildNode(Arrays.asList(4, 5, 6));
		ListNode second1 = buildNode(Arrays.asList(1, 2, 3));
		ListNode res1 = twoNumberMinus(first1, second1);
		System.out.println(print(res1));

		ListNode first2 = buildNode(Arrays.asList(4, 0, 0, 4));
		ListNode second2 = buildNode(Arrays.asList(1, 9, 9));
		ListNode res2 = twoNumberMinus(first2, second2);
		System.out.println(print(res2));

		ListNode first3 = buildNode(Arrays.asList(4, 8, 4));
		ListNode second3 = buildNode(Arrays.asList(1, 9, 9));
		ListNode res3 = twoNumberMinus(first3, second3);
		System.out.println(print(res3));

	}

}
