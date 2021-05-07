package com.timberliu.algorithm.tree.no0104_1_maximumDepthOfBinaryTree.related.no0111_1_minimumDepthOfBinaryTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 111. 二叉树的最小深度
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(minDepth(TreeNode.buildTree(Arrays.asList(3,9,20,null,null,15,7))));

        System.out.println("----- 1 -----");
        System.out.println(minDepth(TreeNode.buildTree(Arrays.asList(2,null,3,null,4,null,5,null,6))));
        System.out.println();
    }

}
