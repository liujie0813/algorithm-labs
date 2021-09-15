package com.timberliu.algorithm.leetcode.bfs_dfs.no0133_2_cloneGraph;

import java.util.*;

/**
 * 133. 克隆图
 *
 * 深度优先搜索
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution1 {

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

	private Map<Node, Node> cloned = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		if (cloned.containsKey(node)) {
			return cloned.get(node);
		}
		Node newNode = new Node(node.val);
		cloned.put(node, newNode);
		ArrayList<Node> newNeighbors = new ArrayList<>();
		for (Node neighbor : node.neighbors) {
			Node newNeighbor = cloneGraph(neighbor);
			newNeighbors.add(newNeighbor);
		}
		newNode.neighbors = newNeighbors;
		return newNode;
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

		Solution1 solution1 = new Solution1();
		Node res = solution1.cloneGraph(node1);
		System.out.println(res);
	}
}
