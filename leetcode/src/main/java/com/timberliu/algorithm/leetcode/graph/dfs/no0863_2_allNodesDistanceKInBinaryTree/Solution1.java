package com.timberliu.algorithm.leetcode.graph.dfs.no0863_2_allNodesDistanceKInBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 *
 * @author Timber
 * @date 2021/9/26
 */
public class Solution1 {

	private Map<TreeNode, TreeNode> map = new HashMap<>();
	private Set<Integer> set = new HashSet<>();
	private List<Integer> res = new ArrayList<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		buildParent(root);
		dfs(target, k);
		return res;
	}

	private void dfs(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		if (set.contains(root.val)) {
			return;
		}
		set.add(root.val);
		if (k == 0) {
			res.add(root.val);
			return;
		}
		dfs(root.left, k - 1);
		dfs(root.right, k - 1);
		dfs(map.get(root), k - 1);
	}

	private void buildParent(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			map.put(root.left, root);
			buildParent(root.left);
		}
		if (root.right != null) {
			map.put(root.right, root);
			buildParent(root.right);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		TreeNode root1 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
		TreeNode target1 = TreeNode.getTreeNode(root1, 5);
		List<Integer> res1 = solution1.distanceK(root1, target1, 2);
		for (Integer a : res1) {
			System.out.print(a + ", ");
		}

	}

}
