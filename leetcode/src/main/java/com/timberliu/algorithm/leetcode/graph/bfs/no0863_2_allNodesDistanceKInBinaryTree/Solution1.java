package com.timberliu.algorithm.leetcode.graph.bfs.no0863_2_allNodesDistanceKInBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution1 {

	private Map<TreeNode, TreeNode> map = new HashMap<>();
	private TreeNode startNode;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		transfrom(root, target);

		Set<TreeNode> visited = new HashSet<>();
		visited.add(startNode);

		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(startNode);
		while (!queue.isEmpty() && k-- > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode prevNode = queue.poll();
				if (prevNode.left != null && !visited.contains(prevNode.left)) {
					visited.add(prevNode.left);
					queue.offer(prevNode.left);
				}
				if (prevNode.right != null && !visited.contains(prevNode.right)) {
					visited.add(prevNode.right);
					queue.offer(prevNode.right);
				}
				TreeNode treeNode = map.get(prevNode);
				if (treeNode != null && !visited.contains(treeNode)) {
					visited.add(treeNode);
					queue.offer(treeNode);
				}
			}
		}

		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			res.add(queue.poll().val);
		}
		return res;
	}

	private void transfrom(TreeNode root, TreeNode target) {
		if (root == null) {
			return;
		}
		if (root == target) {
			startNode = root;
		}
		if (root.left != null) {
			map.put(root.left, root);
			transfrom(root.left, target);
		}
		if (root.right != null) {
			map.put(root.right, root);
			transfrom(root.right, target);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/ -----");
		System.out.println("----- 1 -----");
		TreeNode root1 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
		TreeNode target1 = TreeNode.getTreeNode(root1, 5);

		Solution1 solution1 = new Solution1();
		List<Integer> res = solution1.distanceK(root1, target1, 2);
		System.out.println(res);

	}

}