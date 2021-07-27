package com.timberliu.algorithm.bst.no0099_2_recoverBinarySearchTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 99. 恢复二叉搜索树
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static void recoverTree(TreeNode root) {
        Deque<TreeNode> stask = new LinkedList<>();
        TreeNode x = null, y = null, pre = null;
        while (!stask.isEmpty() || root != null) {
            while (root != null) {
                stask.push(root);
                root = root.left;
            }
            root = stask.pop();
            if (pre != null && root.val < pre.val) {
                y = root;
                // 第二次再退出
                if (x == null) {
                    x = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }

        Integer temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/recover-binary-search-tree/ -----");
        TreeNode treeNode = TreeNode.buildTree(Arrays.asList(3, 1, 4, null, null, 2));
        recoverTree(treeNode);
        System.out.println(true);

    }
}
