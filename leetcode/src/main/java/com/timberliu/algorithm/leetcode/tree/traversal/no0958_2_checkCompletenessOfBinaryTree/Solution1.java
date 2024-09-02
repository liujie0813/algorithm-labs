package com.timberliu.algorithm.leetcode.tree.traversal.no0958_2_checkCompletenessOfBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 958. 二叉树的完全性校验
 *
 *   完全二叉树：层序遍历中遇到 null 之后不能再出现非空节点
 *   满二叉树：每层的非空节点为 2的level次方
 *
 * @author liujie
 * @date 2024/9/2
 */

public class Solution1 {

	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean hasNull = false;
		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			if (hasNull && poll != null) {
				return false;
			}
			if (poll == null) {
				hasNull = true;
			} else {
				queue.offer(poll.left);
				queue.offer(poll.right);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		TreeNode treeNode1 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
		boolean res = solution1.isCompleteTree(treeNode1);
		System.out.println(res);

		TreeNode treeNode2 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, null, 8));
		boolean res2 = solution1.isCompleteTree(treeNode2);
		System.out.println(res2);

	}

}
