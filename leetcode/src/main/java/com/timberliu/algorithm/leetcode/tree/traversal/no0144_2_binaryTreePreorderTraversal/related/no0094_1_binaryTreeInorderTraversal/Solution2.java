package com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal.related.no0094_1_binaryTreeInorderTraversal;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 中序遍历
 *
 *  迭代法
 *
 * Created by liujie on 2021/6/29
 */

public class Solution2 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
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

