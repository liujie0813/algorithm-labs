package com.timberliu.algorithm.leetcode.tree.no0104_1_maximumDepthOfBinaryTree.related.no0110_1_balancedBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 110. 平衡二叉树
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }

    public static boolean isBalanced(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return true;
        }
        int[] leftHeight = new int[1];
        boolean leftBalanced = isBalanced(root.left, leftHeight);
        if (!leftBalanced) {
            return false;
        }

        int[] rightHeight = new int[1];
        boolean rightBalanced = isBalanced(root.right, rightHeight);
        if (!rightBalanced) {
            return false;
        }

        height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
        return Math.abs(leftHeight[0] - rightHeight[0]) <= 1;
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
