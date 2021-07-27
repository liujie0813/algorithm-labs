package com.timberliu.algorithm.bst.no0501_1_findModeInBinarySearchTree.related.no0530_1_minimumAbsoluteDifferenceInBst;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 *  中序遍历过程中比较前驱结点与当前节点
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    private Integer res;
    private Integer pre;

    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ -----");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getMinimumDifference(TreeNode.buildTree(Arrays.asList(1, null, 3, null, null, 2))));

    }
}
