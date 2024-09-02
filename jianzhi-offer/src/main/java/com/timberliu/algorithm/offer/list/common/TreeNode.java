package com.timberliu.algorithm.offer.list.common;

import java.util.List;

/**
 * Created by liujie on 2024/9/2
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

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

    public static String printV1(TreeNode root) {
        StringBuilder sb = new StringBuilder("" + root.val);
        TreeNode cur = root.right;
        while (cur != root) {
            sb.append(", ").append(cur.val);
            cur = cur.right;
        }
        return sb.toString();
    }

}
