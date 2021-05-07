package com.timberliu.algorithm.tree.no0104_1_maximumDepthOfBinaryTree.related.no0110_1_balancedBinaryTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 110. 平衡二叉树
 *
 * Created by liujie on 2021/4/28
 */

public class Solution2 {

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    // 树平衡，返回树的高度
    // 树不平衡，返回 -1
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/balanced-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isBalanced(TreeNode.buildTree(Arrays.asList(3,9,20,null,null,15,7))));

        System.out.println("----- 2 -----");
        System.out.println(isBalanced(TreeNode.buildTree(Arrays.asList(1,2,2,3,3,null,null,4,4))));

        System.out.println("----- 3 -----");
        System.out.println(isBalanced(TreeNode.buildTree(Arrays.asList())));


    }
}
