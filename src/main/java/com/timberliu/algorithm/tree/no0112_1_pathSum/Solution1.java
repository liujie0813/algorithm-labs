package com.timberliu.algorithm.tree.no0112_1_pathSum;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 112. 路径总和
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/path-sum/ -----");
        System.out.println("----- 1 -----");
        System.out.println(hasPathSum(TreeNode.buildTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1)), 22));

        System.out.println("----- 2 -----");
        System.out.println(hasPathSum(TreeNode.buildTree(Arrays.asList(1,2,3)), 5));

        System.out.println("----- 3 -----");
        System.out.println(hasPathSum(TreeNode.buildTree(Arrays.asList(1,2)), 1));

    }
}
