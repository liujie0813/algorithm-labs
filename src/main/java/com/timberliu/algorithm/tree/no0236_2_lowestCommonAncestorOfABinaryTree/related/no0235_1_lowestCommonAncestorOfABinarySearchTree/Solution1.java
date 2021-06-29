package com.timberliu.algorithm.tree.no0236_2_lowestCommonAncestorOfABinaryTree.related.no0235_1_lowestCommonAncestorOfABinarySearchTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 *  二叉搜索树：最近公共祖先 cur 必然处于 p 和 q 之间
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (true) {
            if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                break;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(lowestCommonAncestor(TreeNode.buildTree(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5)),
                new TreeNode(2), new TreeNode(8)).val);

        System.out.println("----- 2 -----");
        System.out.println(lowestCommonAncestor(TreeNode.buildTree(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5)),
                new TreeNode(3), new TreeNode(5)).val);

    }
}
