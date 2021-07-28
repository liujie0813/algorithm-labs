package com.timberliu.algorithm.leetcode.tree.no0617_1_mergeTwoBinaryTrees;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 617. 合并二叉树
 *
 * Created by liujie on 2021/5/8
 */

public class Solution1 {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/merge-two-binary-trees/ -----");
        System.out.println("----- 1 -----");
        TreeNode treeNode = mergeTrees(TreeNode.buildTree(Arrays.asList(1, 3, 2, 5)), TreeNode.buildTree(Arrays.asList(2, 1, 3, null, 4, 7)));
        System.out.println(treeNode);

    }
}
