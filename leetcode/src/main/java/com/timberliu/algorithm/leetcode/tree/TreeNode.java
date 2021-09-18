package com.timberliu.algorithm.leetcode.tree;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liujie on 2021/4/28
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(List<Integer> list) {
        return buildTree(list, 0);
    }

    private static TreeNode buildTree(List<Integer> list, int root) {
        if (list.size() <= root) {
            return null;
        }
        if (list.get(root) == null) {
            return null;
        }
        TreeNode rootNode = new TreeNode(list.get(root));
        rootNode.left = buildTree(list, root * 2 + 1);
        rootNode.right = buildTree(list, root * 2 + 2);
        return rootNode;
    }

    public static TreeNode getTreeNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode res = null;
        if (root.left != null) {
            res = getTreeNode(root.left, val);
        } else {
            res = getTreeNode(root.right, val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(treeNode);
    }

}
