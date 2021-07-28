package com.timberliu.algorithm.leetcode.tree.no0572_1_subtreeOfAnotherTree.related.no0100_1_sameTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 100. 相同的树
 *
 * Created by liujie on 2021/5/8
 */

public class Solution1 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/same-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isSameTree(TreeNode.buildTree(Arrays.asList(1,2,3)), TreeNode.buildTree(Arrays.asList(1,2,3))));

        System.out.println("----- 2 -----");
        System.out.println(isSameTree(TreeNode.buildTree(Arrays.asList(1,2)), TreeNode.buildTree(Arrays.asList(1,null,2))));

        System.out.println("----- 3 -----");
        System.out.println(isSameTree(TreeNode.buildTree(Arrays.asList(1,2,1)), TreeNode.buildTree(Arrays.asList(1,1,2))));

    }
}
