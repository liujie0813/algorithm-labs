package com.timberliu.algorithm.leetcode.tree.no0104_1_maximumDepthOfBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 104. 二叉树的最大深度
 *
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(maxDepth(TreeNode.buildTree(Arrays.asList(3,9,20,null,null,15,7))));
    }
}
