package com.timberliu.algorithm.leetcode.bst.no0700_1_searchInaBinarySearchTree.related.no0701_2_insertIntoaBinarySearchTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right =  insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/ -----");
        TreeNode treeNode1 = insertIntoBST(TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3)), 5);
        System.out.println(treeNode1);

    }
}
