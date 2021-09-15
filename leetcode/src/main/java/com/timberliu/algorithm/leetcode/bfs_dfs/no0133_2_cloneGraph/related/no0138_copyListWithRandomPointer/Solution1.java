package com.timberliu.algorithm.leetcode.bfs_dfs.no0133_2_cloneGraph.related.no0138_copyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * 深度优先搜索
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution1 {

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

	private Map<Node, Node> cloned = new HashMap<>();

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		if (cloned.containsKey(head)) {
			return cloned.get(head);
		}
		Node newNode = new Node(head.val);
		cloned.put(head, newNode);
		newNode.next = copyRandomList(head.next);
		newNode.random = copyRandomList(head.random);
		return newNode;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/copy-list-with-random-pointer/ -----");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.next = node2;
		node1.random = node2;
		node2.random = node2;
		Solution1 solution1 = new Solution1();
		Node res = solution1.copyRandomList(node1);
		System.out.println();
	}
}
