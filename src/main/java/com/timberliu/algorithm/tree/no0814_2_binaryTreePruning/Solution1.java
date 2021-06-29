package com.timberliu.algorithm.tree.no0814_2_binaryTreePruning;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 814. 二叉树剪枝
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左右子树已经剪好了
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 左右子树为 null，并且 root 为 0，直接剪去
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        // root 为 1，或者 left/right 不为 null，都不能剪
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-pruning/ -----");
        System.out.println("----- 1 -----");
        TreeNode treeNode = pruneTree(TreeNode.buildTree(Arrays.asList(1, null, 0, null, null, 0, 1)));
        System.out.println(treeNode);

        System.out.println("----- 2 -----");
        TreeNode treeNode1 = pruneTree(TreeNode.buildTree(Arrays.asList(1, 0, 1, 0, 0, 0, 1)));
        System.out.println(treeNode1);

    }
}
