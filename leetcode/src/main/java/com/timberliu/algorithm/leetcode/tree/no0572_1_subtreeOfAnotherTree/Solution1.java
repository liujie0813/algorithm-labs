package com.timberliu.algorithm.leetcode.tree.no0572_1_subtreeOfAnotherTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 572. 另一个树的子树
 *
 * Created by liujie on 2021/5/8
 */

public class Solution1 {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/subtree-of-another-tree/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isSubtree(TreeNode.buildTree(Arrays.asList(3,4,5,1,2)), TreeNode.buildTree(Arrays.asList(4,1,2))));

        System.out.println("----- 2 -----");
        System.out.println(isSubtree(TreeNode.buildTree(Arrays.asList(3,4,5,1,2,null,null,null,null,0)), TreeNode.buildTree(Arrays.asList(4,1,2))));

    }

}
