package com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal.related.no0145_1_binaryTreePostorderTraversal;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 后序遍历
 *
 *  左-右-中
 *
 * Created by liujie on 2021/6/29
 */

public class Solution2 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        // 中-右-左
        // 左-右-中
        Collections.reverse(res);
        return res;
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
