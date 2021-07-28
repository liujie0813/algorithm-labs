package com.timberliu.algorithm.leetcode.tree.no0572_1_subtreeOfAnotherTree.related.no0101_1_symmetricTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 *
 * Created by liujie on 2021/6/16
 */

public class Solution1 {

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    private static boolean isSymmetric1(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            }
            if ((first == null || second == null) || (first.val != second.val)) {
                return false;
            }
            queue.offer(root1.left);
            queue.offer(root2.right);

            queue.offer(root1.right);
            queue.offer(root2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/symmetric-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isSymmetric(TreeNode.buildTree(Arrays.asList(1,2,2,3,4,4,3))));

        System.out.println("----- 2 -----");
        System.out.println(isSymmetric(TreeNode.buildTree(Arrays.asList(1,2,2,null,3,null,3))));

    }
}
