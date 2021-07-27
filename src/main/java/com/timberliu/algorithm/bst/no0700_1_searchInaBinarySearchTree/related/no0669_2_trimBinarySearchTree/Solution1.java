package com.timberliu.algorithm.bst.no0700_1_searchInaBinarySearchTree.related.no0669_2_trimBinarySearchTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 *
 * 669. 修剪二叉搜索树
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/trim-a-binary-search-tree/ -----");
        TreeNode treeNode = trimBST(TreeNode.buildTree(Arrays.asList(3, 0, 4, null, 2, null, null, null, null, 1)), 1, 3);
        System.out.println(treeNode);
    }
}
