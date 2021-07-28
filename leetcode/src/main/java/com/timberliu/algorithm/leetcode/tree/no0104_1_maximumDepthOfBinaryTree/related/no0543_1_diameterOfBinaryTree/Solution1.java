package com.timberliu.algorithm.leetcode.tree.no0104_1_maximumDepthOfBinaryTree.related.no0543_1_diameterOfBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 543. 二叉树的直径
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] maxLen = new int[1];
        depthOfBinaryTree(root, maxLen);
        return maxLen[0];
    }

    // 深度
    private static int depthOfBinaryTree(TreeNode root, int[] maxLength) {
        if (root == null) {
            return 0;
        }
        int leftHeight = depthOfBinaryTree(root.left, maxLength);
        int rightHeight = depthOfBinaryTree(root.right, maxLength);
        maxLength[0] = Math.max(maxLength[0], leftHeight + rightHeight);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/diameter-of-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(diameterOfBinaryTree(TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5))));

        System.out.println("----- 2 -----");
        System.out.println(diameterOfBinaryTree(TreeNode.buildTree(Arrays.asList(1, null, 2))));

    }
}
