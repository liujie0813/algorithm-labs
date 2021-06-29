package com.timberliu.algorithm.tree.no0144_2_binaryTreePreorderTraversal.related.no0094_1_binaryTreeInorderTraversal;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        return inorderList;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ -----");
        System.out.println("----- 1 -----");
        System.out.println(inorderTraversal(TreeNode.buildTree(Arrays.asList(1, null, 2, null, null, 3))));

        System.out.println("----- 2 -----");
        System.out.println(inorderTraversal(TreeNode.buildTree(Arrays.asList())));

        System.out.println("----- 3 -----");
        System.out.println(inorderTraversal(TreeNode.buildTree(Arrays.asList(1))));

    }
}

