package com.timberliu.algorithm.bst.no0501_1_findModeInBinarySearchTree.related.no0098_2_validateBinarySearchTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 *
 *  使用 stack 遍历法：在中序遍历时，检查当前节点的值是否大于前一个中序遍历的节点的值即可
 *                   1. 如果均大于则该序列是升序的；2. 否则不是
 *
 * Created by liujie on 2021/7/27
 */

public class Solution2 {

    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int inorder = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/validate-binary-search-tree/ -----");
        System.out.println(isValidBST(TreeNode.buildTree(Arrays.asList(2, 1, 3))));

        System.out.println(isValidBST(TreeNode.buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6))));

    }
}
