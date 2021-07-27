package com.timberliu.algorithm.bst.no0108_1_convertSortedArrayToBinarySearchTree;

import com.timberliu.algorithm.tree.TreeNode;

/**
 *
 *  108. 将有序数组转换为二叉搜索树
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/ -----");
        TreeNode treeNode1 = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode1);

        TreeNode treeNode2 = sortedArrayToBST(new int[]{1, 2});
        System.out.println(treeNode2);

    }
}
