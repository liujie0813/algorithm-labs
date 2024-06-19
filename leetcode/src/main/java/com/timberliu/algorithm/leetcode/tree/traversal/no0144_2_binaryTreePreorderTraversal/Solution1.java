package com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorderTraversal(root, preorderList);
        return preorderList;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ -----");
        System.out.println("----- 1 -----");
        System.out.println(preorderTraversal(TreeNode.buildTree(Arrays.asList(1, null, 2, null, null, 3))));

        System.out.println("----- 2 -----");
        System.out.println(preorderTraversal(TreeNode.buildTree(Arrays.asList())));

        System.out.println("----- 3 -----");
        System.out.println(preorderTraversal(TreeNode.buildTree(Arrays.asList(1))));

    }
}
