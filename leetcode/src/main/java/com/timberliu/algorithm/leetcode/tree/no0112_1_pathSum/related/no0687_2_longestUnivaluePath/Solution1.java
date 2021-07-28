package com.timberliu.algorithm.leetcode.tree.no0112_1_pathSum.related.no0687_2_longestUnivaluePath;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 687. 最长同值路径
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    static int ans;

    public static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        doLongestUnivaluePath(root);
        return ans;
    }

    // 搜索以 root 为起点的最长同值路径
    private static int doLongestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doLongestUnivaluePath(root.left);
        int right = doLongestUnivaluePath(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        /* 最大同值路径
         *  1. 以root为起点的左子树的最长同值路径
         *  2. 以root为起点的右子树的最长同值路径
         *  3. 左右子树连一起的最长同值路径
         */
        ans = Math.max(ans, arrowLeft + arrowRight);
        // 返回结果为 分别以当前root节点为起点的左右子树的较大同值路径
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-univalue-path/ -----");
        System.out.println("----- 1 -----");
        System.out.println(longestUnivaluePath(TreeNode.buildTree(Arrays.asList(5,4,5,1,1,null,5))));

        System.out.println("----- 2 -----");
        System.out.println(longestUnivaluePath(TreeNode.buildTree(Arrays.asList(1,4,5,4,4,null,5))));

    }
}
