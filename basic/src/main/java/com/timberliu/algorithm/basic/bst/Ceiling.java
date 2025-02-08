package com.timberliu.algorithm.basic.bst;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2025/2/8
 */

public class Ceiling {
	
	public static TreeNode findCeiling(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			return root;
		} else if (root.val < key) {
			return findCeiling(root.right, key);
		} else {
			TreeNode t = findCeiling(root.left, key);
			if (t == null) {
				return root;
			} else {
				return t;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(Arrays.asList(7, 3, 11, 1, 5, 9, 13));
		System.out.println(findCeiling(root, 5).val);
		System.out.println(findCeiling(root, 6).val);
		System.out.println(findCeiling(root, 7).val);
		System.out.println(findCeiling(root, 8).val);
		System.out.println(findCeiling(root, 9).val);
		
	}
	
}
