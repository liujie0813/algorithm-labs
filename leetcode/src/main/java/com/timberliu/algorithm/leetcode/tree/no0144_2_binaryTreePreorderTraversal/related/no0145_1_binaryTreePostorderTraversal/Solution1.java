package com.timberliu.algorithm.leetcode.tree.no0144_2_binaryTreePreorderTraversal.related.no0145_1_binaryTreePostorderTraversal;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        postorderTraversal(root, postorderList);
        return postorderList;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-postorder-traversal/ -----");
        System.out.println("----- 1 -----");
        System.out.println(postorderTraversal(TreeNode.buildTree(Arrays.asList(1, null, 2, null, null, 3))));

        System.out.println("----- 2 -----");
        System.out.println(postorderTraversal(TreeNode.buildTree(Arrays.asList())));

        System.out.println("----- 3 -----");
        System.out.println(postorderTraversal(TreeNode.buildTree(Arrays.asList(1))));

    }
}
