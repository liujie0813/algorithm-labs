package com.timberliu.algorithm.company.hw.linked_list.no006_1_middleNodeOfList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 6. 单向链表中间节点
 *
 *
 * @author liujie
 * @date 2023/4/11
 */

public class Solution1 {

	public static class ListNode {
		private int value;
		private String next;
		public ListNode(int value, String next) {
			this.value = value;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		String[] firstLines = firstLine.split(" ");
		String headAddr = firstLines[0];
		int n = Integer.parseInt(firstLines[1]);

		Map<String, ListNode> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			String[] lines = line.split(" ");
			String curAddr = lines[0];
			int value = Integer.parseInt(lines[1]);
			String nextAddr = lines[2];
			map.put(curAddr, new ListNode(value, nextAddr));
		}

		int len = 0;
		ListNode head = map.get(headAddr);
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = "-1".equals(cur.next) ? null : map.get(cur.next);
		}

		int index = 0;
		while (head != null) {
			if (len / 2 == index) {
				System.out.println(head.value);
				return;
			}
			index++;
			head = "-1".equals(head.next) ? null : map.get(head.next);
		}
	}

}
