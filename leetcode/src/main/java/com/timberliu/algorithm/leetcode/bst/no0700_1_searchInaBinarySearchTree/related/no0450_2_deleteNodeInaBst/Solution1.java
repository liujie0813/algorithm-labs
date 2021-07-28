package com.timberliu.algorithm.leetcode.bst.no0700_1_searchInaBinarySearchTree.related.no0450_2_deleteNodeInaBst;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode t = root;
            root = min(t.right);
            // 下面两行顺序不能调换
            // 将 t.right 子树中最小键删除后，再将 root.left 指向 t.left
            root.right = deleteMin(t.right);
            root.left = t.left;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode min(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/delete-node-in-a-bst/ -----");
        Solution1 solution1 = new Solution1();
        TreeNode treeNode1 = solution1.deleteNode(TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 3);
        System.out.println(treeNode1);

    }
}
