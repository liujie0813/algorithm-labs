package com.timberliu.algorithm.bst.no0501_1_findModeInBinarySearchTree.related.no0538_1_convertBstToGreaterTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 *  每个节点 node 的新值等于原树中大于或等于 node.val 的值之和
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public static TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Integer post = 0;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val = post = cur.val + post;
            cur = cur.left;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ -----");
        TreeNode treeNode1 = TreeNode.buildTree(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
        treeNode1 = convertBST(treeNode1);
        System.out.println(treeNode1);

        TreeNode treeNode2 = TreeNode.buildTree(Arrays.asList(0, null, 1));
        treeNode2 = convertBST(treeNode2);
        System.out.println(treeNode2);

        TreeNode treeNode3 = TreeNode.buildTree(Arrays.asList(1, 0, 2));
        treeNode3 = convertBST(treeNode3);
        System.out.println(treeNode3);

    }

}
