package com.timberliu.algorithm.leetcode.bst.no0700_1_searchInaBinarySearchTree.related.no0776_2_splitBST;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 776. 拆分二叉搜索树
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    /**
     * res[0]  小于等于 v 的子树
     * res[1]  大于 v 的子树
     */
    public static TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (target < root.val) {
            TreeNode[] res = splitBST(root.left, target);
            root.left = res[1];
            res[1] = root;
            return res;
        } else {
            TreeNode[] res = splitBST(root.right, target);
            root.right = res[0];
            res[0] = root;
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/split-bst/ -----");
        TreeNode[] treeNodes = splitBST(TreeNode.buildTree(Arrays.asList(4, 2, 6, 1, 3, 5, 7)), 2);
        System.out.println(treeNodes);

    }
}
