package com.timberliu.algorithm.leetcode.tree.traversal.no0637_1_averageOfLevelsInBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                val += treeNode.val;
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(val / size);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(averageOfLevels(TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7))));

    }
}
