package com.timberliu.algorithm.offer.list.no155_2_bstToSortedList;

import com.timberliu.algorithm.offer.list.common.TreeNode;

import java.util.Arrays;

/**
 * 155. 将二叉搜索树转换为排序的双向循环链表
 *
 *   定义 head、prev 用于记录链表头指针、前一个指针
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
		// 循环
		head.left = prev;
		prev.right = head;
		return head;
	}

	private static TreeNode head, prev;

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (prev == null) {
			// 左下角为 head
			head = root;
		} else {
			// 与前一个相连
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		dfs(root.right);
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		TreeNode head = TreeNode.buildTree(Arrays.asList(4, 2, 5, 1, 3));
		TreeNode res = solution1.treeToDoublyList(head);
		System.out.println(TreeNode.printV1(res));
	}

}
