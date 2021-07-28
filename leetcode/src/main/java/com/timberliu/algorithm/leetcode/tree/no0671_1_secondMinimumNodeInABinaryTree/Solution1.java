package com.timberliu.algorithm.leetcode.tree.no0671_1_secondMinimumNodeInABinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 671. 二叉树中第二小的节点
 *
 *   不等于根节点的最小值，即为第二小的值
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static int findSecondMinimumValue(TreeNode root) {
        // 无左右节点，返回 -1
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        // 左子树中不等于根节点的值，不等直接就是 left，否则去递归查找
        int leftSecondMin = root.val != root.left.val ? root.left.val : findSecondMinimumValue(root.left);
        int rightSecondMin = root.val != root.right.val ? root.right.val : findSecondMinimumValue(root.right);

        if (leftSecondMin != -1 && rightSecondMin != -1) {
            return Math.min(leftSecondMin, rightSecondMin);
        }
        return Math.max(leftSecondMin, rightSecondMin);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findSecondMinimumValue(TreeNode.buildTree(Arrays.asList(2,2,5,null,null,5,7))));

        System.out.println("----- 2 -----");
        System.out.println(findSecondMinimumValue(TreeNode.buildTree(Arrays.asList(2,2,2))));

        System.out.println("----- 3 -----");
        System.out.println(findSecondMinimumValue(TreeNode.buildTree(Arrays.asList(1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1))));

    }

}
