package com.timberliu.algorithm.leetcode.tree.no0637_1_averageOfLevelsInBinaryTree.related.no0102_2_binaryTreeLevelOrderTraversal;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 *
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-level-order-traversal/ -----");
        System.out.println("----- 1 -----");
        System.out.println(levelOrder(TreeNode.buildTree(Arrays.asList(3,9,20,null,null,15,7))));

    }
}
