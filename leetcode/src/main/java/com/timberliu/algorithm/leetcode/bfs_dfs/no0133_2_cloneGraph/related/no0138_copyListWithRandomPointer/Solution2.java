package com.timberliu.algorithm.leetcode.bfs_dfs.no0133_2_cloneGraph.related.no0138_copyListWithRandomPointer;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * 广度优先搜索
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution2 {

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public void setRandom(Node random) {
			this.random = random;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Map<Node, Node> cloned = new HashMap<>();
		Deque<Node> queue = new LinkedList<>();
		queue.offer(head);
		cloned.put(head, new Node(head.val));
		while (!queue.isEmpty()) {
			Node top = queue.poll();
			if (top.next != null) {
				if (!cloned.containsKey(top.next)) {
					queue.offer(top.next);
					cloned.put(top.next, new Node(top.next.val));
				}
				cloned.get(top).next = cloned.get(top.next);
			}
			if (top.random != null) {
				if (!cloned.containsKey(top.random)) {
					queue.offer(top.random);
					cloned.put(top.random, new Node(top.random.val));
				}
				cloned.get(top).random = cloned.get(top.random);
			}
		}
		return cloned.get(head);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/copy-list-with-random-pointer/ -----");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.next = node2;
		node1.random = node2;
		node2.random = node2;
		Solution2 solution2 = new Solution2();
		Node res = solution2.copyRandomList(node1);
		System.out.println();
	}
}
