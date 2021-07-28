package com.timberliu.algorithm.leetcode.bst.no0700_1_searchInaBinarySearchTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 700. 二叉搜索树中的搜索
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/search-in-a-binary-search-tree/ -----");
        TreeNode treeNode1 = searchBST(TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3)), 2);
        System.out.println(treeNode1);

    }
}
