package com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 *
 * Created by liujie on 2021/6/29
 */

public class Solution2 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
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
