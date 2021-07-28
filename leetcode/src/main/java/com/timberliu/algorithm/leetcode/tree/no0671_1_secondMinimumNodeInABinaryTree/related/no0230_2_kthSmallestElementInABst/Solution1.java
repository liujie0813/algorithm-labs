package com.timberliu.algorithm.leetcode.tree.no0671_1_secondMinimumNodeInABinaryTree.related.no0230_2_kthSmallestElementInABst;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 *   中序遍历，遇到第k个元素时退出
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    private int res = -1;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/ -----");
        System.out.println("----- 1 -----");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.kthSmallest(TreeNode.buildTree(Arrays.asList(3,1,4,null,2)), 1));
        /**
         *    3
         *    1    4
         *    * 2  * *
         */
        System.out.println("----- 2 -----");
        Solution1 solution2 = new Solution1();
        System.out.println(solution2.kthSmallest(TreeNode.buildTree(Arrays.asList(5,3,6,2,4,null,null,1)), 3));
        /**
         * 5
         * 3     6
         * 2 4   * *
         * 1
         */
    }
}
