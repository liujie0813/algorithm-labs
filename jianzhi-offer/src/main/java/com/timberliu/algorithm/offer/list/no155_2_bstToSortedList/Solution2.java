package com.timberliu.algorithm.offer.list.no155_2_bstToSortedList;

import com.timberliu.algorithm.offer.list.common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 将二叉搜索树转换为排序的双向循环链表
 *
 *   定义 head、prev 用于记录链表头指针、前一个指针
 *
 * @author liujie
 * @date 2024/9/2
 */

public class Solution2 {

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode head = null, prev = null;
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (prev == null) {
					head = cur;
				} else {
					prev.right = cur;
					cur.left = prev;
				}
				prev = cur;
				cur = cur.right;
			}
		}
		head.left = prev;
		prev.right = head;
		return head;
	}

	public static void main(String[] args) {
		Solution2 solution1 = new Solution2();
		TreeNode head = TreeNode.buildTree(Arrays.asList(4, 2, 5, 1, 3));
		TreeNode res = solution1.treeToDoublyList(head);
		System.out.println(TreeNode.printV1(res));
	}

}
