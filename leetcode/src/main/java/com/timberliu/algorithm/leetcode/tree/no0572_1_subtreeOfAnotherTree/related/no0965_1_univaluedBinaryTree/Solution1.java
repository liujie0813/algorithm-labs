package com.timberliu.algorithm.leetcode.tree.no0572_1_subtreeOfAnotherTree.related.no0965_1_univaluedBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 965. 单值二叉树
 *
 * Created by liujie on 2021/5/8
 */

public class Solution1 {

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/univalued-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isUnivalTree(TreeNode.buildTree(Arrays.asList(1,1,1,1,1,null,1))));

        System.out.println("----- 2 -----");
        System.out.println(isUnivalTree(TreeNode.buildTree(Arrays.asList(2,2,2,5,2))));

    }
}
