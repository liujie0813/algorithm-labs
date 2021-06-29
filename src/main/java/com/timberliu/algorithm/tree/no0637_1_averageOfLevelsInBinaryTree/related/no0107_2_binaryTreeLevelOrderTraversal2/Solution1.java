package com.timberliu.algorithm.tree.no0637_1_averageOfLevelsInBinaryTree.related.no0107_2_binaryTreeLevelOrderTraversal2;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add( list);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println();

    }
}
