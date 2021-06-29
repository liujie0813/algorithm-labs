package com.timberliu.algorithm.tree.no0226_1_invertBinaryTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 226. 翻转二叉树
 *
 * Created by liujie on 2021/5/8
 */

public class Solution1 {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先递归翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 交换两个子树即可
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/invert-binary-tree/ -----");
        System.out.println("----- 1 -----");
        TreeNode treeNode = invertTree(TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9)));
        System.out.println(treeNode);
    }
}
