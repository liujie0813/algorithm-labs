package com.timberliu.algorithm.leetcode.tree.no0112_1_pathSum.related.no0124_3_binaryTreeMaximumPathSum;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 124. 二叉树中的最大路径和
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    static int ans;

    public static int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        doMaxPathSum(root);
        return ans;
    }

    // 以 root 为起点的最大路径和
    private static int doMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果路径和小于 0，不再考虑
        int left = Math.max(doMaxPathSum(root.left), 0);
        int right = Math.max(doMaxPathSum(root.right), 0);
        // 更新最大路径和  左子树+根+右子树
        ans = Math.max(ans, left + right + root.val);
        // 返回结果：以 root 为起点，所以只需要 left、right 中较大者 + root
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/ -----");
        System.out.println("----- 1 -----");
        System.out.println(maxPathSum(TreeNode.buildTree(Arrays.asList(-10,9,20,null,null,15,7))));

        System.out.println("----- 2 -----");
        System.out.println(maxPathSum(TreeNode.buildTree(Arrays.asList(1, 2, 3))));
        StringJoiner stringJoiner = new StringJoiner(".");
        stringJoiner.toString();
    }
}
