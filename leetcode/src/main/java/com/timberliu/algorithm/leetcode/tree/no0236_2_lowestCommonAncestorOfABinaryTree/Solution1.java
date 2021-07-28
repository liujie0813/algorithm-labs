package com.timberliu.algorithm.leetcode.tree.no0236_2_lowestCommonAncestorOfABinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 236. 二叉树的最近公共祖先
 *
 *   如果 root 是 p、q 的最近公共祖先，有三种情况：
 *     1. p 和 q 和 root 的子树中，且分列 root 的两侧
 *     2. p = root，且 q 在左（或右）子树中
 *     3. q = root，且 p 在左（或右）子树中
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(lowestCommonAncestor(TreeNode.buildTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4)),
                new TreeNode(5), new TreeNode(1)));

    }
}
