package com.timberliu.algorithm.leetcode.bst.no0501_1_findModeInBinarySearchTree.related.no0098_2_validateBinarySearchTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 98. 验证二叉搜索树
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/validate-binary-search-tree/ -----");
        System.out.println(isValidBST(TreeNode.buildTree(Arrays.asList(2, 1, 3))));

        System.out.println(isValidBST(TreeNode.buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6))));

    }
}
