package com.timberliu.algorithm.leetcode.bfs_dfs.no0133_2_cloneGraph;

import java.util.*;

/**
 * 133. 克隆图
 *
 * 广度优先搜索
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution2 {

	static class Node {
		public int val;
		public List<Node> neighbors;
		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}
		public Node(int val) {
			this.val = val;
			neighbors = new ArrayList<Node>();
		}
		public Node(int val, ArrayList<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
		public void setNeighbors(ArrayList<Node> neighbors) {
			this.neighbors = neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		// 已经克隆过
		Map<Node, Node> cloned = new HashMap<>();
		Deque<Node> queue = new LinkedList<>();
		queue.add(node);
		cloned.put(node, new Node(node.val, new ArrayList<>()));

		while (!queue.isEmpty()) {
			Node head = queue.poll();
			for (Node neighbor : head.neighbors) {
				if (!cloned.containsKey(neighbor)) {
					queue.add(neighbor);
					cloned.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
				}
				cloned.get(head).neighbors.add(cloned.get(neighbor));
			}
		}
		return cloned.get(node);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/clone-graph/ -----");
		System.out.println("----- 1 -----");

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		ArrayList<Node> nodes1 = new ArrayList<>();
		nodes1.add(node2);
		nodes1.add(node4);
		node1.setNeighbors(nodes1);
		ArrayList<Node> nodes2 = new ArrayList<>();
		nodes2.add(node1);
		nodes2.add(node3);
		node2.setNeighbors(nodes2);
		ArrayList<Node> nodes3 = new ArrayList<>();
		nodes3.add(node2);
		nodes3.add(node4);
		node3.setNeighbors(nodes3);
		ArrayList<Node> nodes4 = new ArrayList<>();
		nodes4.add(node1);
		nodes4.add(node3);
		node4.setNeighbors(nodes4);

		Solution2 solution2 = new Solution2();
		Node res = solution2.cloneGraph(node1);
		System.out.println(res);
	}
}
