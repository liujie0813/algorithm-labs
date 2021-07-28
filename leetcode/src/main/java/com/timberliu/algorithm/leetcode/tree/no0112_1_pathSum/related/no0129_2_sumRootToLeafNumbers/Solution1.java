package com.timberliu.algorithm.leetcode.tree.no0112_1_pathSum.related.no0129_2_sumRootToLeafNumbers;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 129. 求根到叶子节点数字之和
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private static int sumNumbers(TreeNode root, int curNum) {
        if (root == null) {
            return 0;
        }
        curNum = curNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curNum;
        }
        return sumNumbers(root.left, curNum) + sumNumbers(root.right, curNum);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/ -----");
        System.out.println("----- 1 -----");
        System.out.println(sumNumbers(TreeNode.buildTree(Arrays.asList(1, 2, 3))));

        System.out.println("----- 2 -----");
        System.out.println(sumNumbers(TreeNode.buildTree(Arrays.asList(4, 9, 0, 5, 1))));

    }
}
