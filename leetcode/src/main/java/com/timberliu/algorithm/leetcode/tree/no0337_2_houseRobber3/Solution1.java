package com.timberliu.algorithm.leetcode.tree.no0337_2_houseRobber3;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 337. 打家劫舍 III
 *
 * Created by liujie on 2021/6/28
 */

public class Solution1 {

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 打劫根节点（打劫左右子树的子节点）
        int value1 = root.val;
        if (root.left != null) {
            value1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            value1 += rob(root.right.left) + rob(root.right.right);
        }
        // 不打劫根节点（打劫左右子节点）
        int value2 = rob(root.left) + rob(root.right);

        return Math.max(value1, value2);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/house-robber-iii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(rob(TreeNode.buildTree(Arrays.asList(3,2,3,null,3,null,1))));

        System.out.println("----- 2 -----");
        System.out.println(rob(TreeNode.buildTree(Arrays.asList(3,4,5,1,3,null,1))));

    }
}
