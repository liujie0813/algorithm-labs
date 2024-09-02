package com.timberliu.algorithm.offer.list.no155_2_bstToSortedList.related.noxxx_2_bstToSortedList;

import com.timberliu.algorithm.offer.list.common.TreeNode;

import java.util.Arrays;

/**
 * 二叉搜索树 后序遍历 转化为 双向链表
 *
 * @author liujie
 * @date 2024/9/2
 */

public class Solution1 {

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return null;
		}
		dfs(root);
		head.left = prev;
		prev.right = head;
		return head;
	}

	private static TreeNode prev, head;

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		dfs(root.right);
		// 两个子树的链表已经连到一起了；
		if (prev == null) {
			head = root;
		} else {
			prev.right = root;
		}
		root.left = prev;
		prev = root;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		TreeNode treeNode = TreeNode.buildTree(Arrays.asList(7,3,6,1,2,4,5));
		TreeNode res = solution1.treeToDoublyList(treeNode);
		System.out.println(TreeNode.printV1(res));

	}

}
