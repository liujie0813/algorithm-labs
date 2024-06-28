package com.timberliu.algorithm.leetcode.tree.build_tree.no0105_2_constructTreeFromPreorderAndInorder;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

/**
 * 105. 从前序到中序遍历序列构造二叉树 **
 *
 * @author liujie
 * @date 2024/6/20
 */

public class Solution1 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inRootIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == preorder[preStart]) {
				inRootIndex = i;
				break;
			}
		}
		int leftLen = inRootIndex - inStart;
		root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inRootIndex - 1);
		root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, inRootIndex + 1, inEnd);
		return root;
	}

}
